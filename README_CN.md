# 使用 dddappp 低代码工具开发 Rooch 去中心化应用

[English](README.md) | 中文


## Prerequisites

目前 dddappp 低代码工具以 Docker 镜像的方式发布，供开发者体验。

工具所生成应用的链下服务使用 Java 语言编写，默认使用了 MySQL 数据库。

所以在开始体验前，你需要先：

* 安装 [Rooch CLI](https://github.com/rooch-network/rooch)。

* 安装 [Docker](https://docs.docker.com/engine/install/)。

* 安装 MySQL 数据库。

* 安装 JDK 和 Maven。工具目前生成的链下服务使用 Java 语言。

* 安装 curl 以及 jp 命令（jp - commandline JSON processor，可选）。我们在测试合约的时候可以使用 jp 来处理 JSON RPC 返回的 JSON 结果。

如果你已经安装了 Docker，可以使用 Docker 来运行一个 MySQL 数据库服务。比如：

```shell
sudo docker run -p 3306:3306 --name mysql \
-v ~/docker/mysql/conf:/etc/mysql \
-v ~/docker/mysql/logs:/var/log/mysql \
-v ~/docker/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:5.7
```

注意，上面的命令中我们将数据库 root 账号的密码为 123456。下面示例的 shell 命令和 Off-chain 服务的配置中我们直接使用这个 root 账号/密码。你可以视你的运行环境修改它们。

## 示例：重现 Demo 应用的开发过程

我们在 GitHub 上放置了一个使用 dddappp 低代码工具开发的 Demo 应用。这个应用的代码分为两部分：

* Rooch Move 链上合约：https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch_contracts

* Java 链下服务：https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch-java-service

你可以按照下面的介绍重现该 Demo 的开发过程。

### 编写 DDDML 模型文件

我们的低代码工具依赖 DDDML（领域驱动设计建模语言）描述的领域模型来生成应用的各部分代码。

> **提示**
> 
> 关于 DDDML，这里有一篇入门的介绍文章：[《DDDML 简介：开启去中心化应用低代码开发的钥匙》](https://github.com/wubuku/Dapp-LCDP-Demo/blob/main/IntroducingDDDML_CN.md)。这篇文章包含了本 Demo 使用的一些 DDDML 模型文件的详细讲解。 

你可以创建一个目录，比如叫做 `test`，来放置应用的所有代码，然后在该目录下面创建一个子目录 `dddml`。我们一般在这个目录下放置按照 DDDML 的规范编写的模型文件。

你可以把这里的示例模型文件下载/拷贝到 dddml 目录：https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/domain-model/rooch

在这些模型中，有些生造的例子可能已经复杂到了有点“荒谬”的地步，但我们的工具没有被“难倒”。


### 运行 dddappp 项目创建工具

使用 Docker 运行项目创建工具：

```shell
docker run \
-v /PATH/TO/test:/myapp \
wubuku/dddappp-rooch:0.0.1 \
--dddmlDirectoryPath /myapp/dddml \
--boundedContextName Test.RoochTestProj1 \
--boundedContextJavaPackageName org.test.roochtestproj1 \
--boundedContextRoochPackageName RoochTestProj1 \
--boundedContextRoochNamedAddress rooch_test_proj1 \
--javaProjectsDirectoryPath /myapp/rooch-java-service \
--javaProjectNamePrefix roochtestproj1 \
--pomGroupId test.roochtestproj1 \
--roochMoveProjectDirectoryPath /myapp/rooch-contracts
```

上面的命令参数很直白：

* 注意将 `/PATH/TO/test` 替换为你实际放置应用代码的本机目录的路径。这一行表示将该本机目录挂载到容器内的 `/myapp` 目录。

* dddmlDirectoryPath 是 DDDML 模型文件所在的目录。它应该是容器内可以读取的目录路径。

* 把参数 boundedContextName 的值理解为你要开发的应用的名称即可。名称有多个部分时请使用点号分隔，每个部分使用 PascalCase 命名风格。Bounded-context 是领域驱动设计（DDD）中的一个术语，指的是一个特定的问题域范围，包含了特定的业务边界、约束和语言，这个概念你暂时不能理解也没有太大的关系。

* boundedContextJavaPackageName 是链下服务的 Java 包名。按照 Java 的命名规范，它应该全小写、各部分以点号分隔。

* boundedContextRoochPackageName 是链上 Rooch 合约的包名。建议采用 PascalCase 命名风格。

* boundedContextRoochNamedAddress 是链上 Rooch 合约默认的命名地址。建议采用 snake_case 命名风格。

* javaProjectsDirectoryPath 是放置链下服务代码的目录路径。链下服务由多个模块（项目）组成。它应该使用容器内的可以读写的目录路径。

* javaProjectNamePrefix 是组成链下服务的各模块的名称前缀。建议使用一个全小写的名称。

* pomGroupId 链下服务的 GroupId，我们使用 Maven 作为链下服务的项目管理工具。它应该全小写、各部分以点号分隔。

* roochMoveProjectDirectoryPath 是放置链上 Rooch 合约代码的目录路径。它应该使用容器内可以读写的目录路径。

上面的命令执行成功后，在本地目录 `/PATH/TO/test` 下应该会增加两个目录 `rooch-contracts` 以及 `rooch-java-service`。

此时可以尝试编译链下服务。进入目录 `rooch-java-service`，执行：`mvn compile`。如果没有意外，编译应该可以成功。

此时，链上合约还不能通过编译，因为“业务逻辑”还没有实现。下面我们就来实现它们。

### 实现业务逻辑

工具已经在目录 `rooch-contracts/sources` 下生成了一些以 `_logic.move` 结尾的文件。文件中包含实现业务逻辑的函数的脚手架代码，即函数的签名部分。现在你只需要填充其中函数的实现部分。

你可以考虑从这里拷贝已经写好的业务逻辑的实现代码：https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch-contracts/sources

你还可以将这个 Demo 应用的代码库 clone 下来，然后执行像下面这样的一个 shell 脚本来完成拷贝工作（注意将 `_PATH_TO_/Dapp-LCDP-Demo` 和 `_PATH_TO_/test` 替换为你本机上的实际路径）：

```shell
#!/bin/bash

source_dir="_PATH_TO_/Dapp-LCDP-Demo/rooch-contracts/sources"
target_dir="_PATH_TO_/test/rooch-contracts/sources"

old_keyword="rooch_demo"
new_keyword="rooch_test_proj1"

for file in "${source_dir}"/*_logic.move; do
  if [[ -f "$file" ]] && grep -q "$old_keyword" "$file"; then
    cp "$file" "${target_dir}/$(basename "$file")"
    sed -i "" "s/$old_keyword/$new_keyword/g" "${target_dir}/$(basename "$file")"
  fi
done
```

#### 编译 Rooch Move 合约

在目录 `rooch-contracts`下编译 Move 合约代码，现在应该可以编译成功了（注意把下面的占位符 `{YOUR_ACCOUNT_ADDRESS}` 替换为你的一个账户地址）：

```shell
rooch move build --named-addresses rooch_demo={YOUR_ACCOUNT_ADDRESS}
```

到现在为止，应用开发的编码阶段已经完成了！是不是非常简单？

---

下面我们来部署和测试 Demo 应用。

### 发布 Rooch 合约

先运行一个本地的 Rooch 开发服务器：

```shell
rooch server start
```

在完成业务逻辑的编写之后，在目录 `rooch-contracts` 下执行以下命令，将合约发布到本地开发网络（注意把下面的占位符 `{YOUR_ACCOUNT_ADDRESS}` 替换为你的一个账户地址）：

```shell
rooch move publish --named-addresses rooch_demo={YOUR_ACCOUNT_ADDRESS}
```

然后，初始化合约：

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::rooch_demo_init::initialize --sender-account {YOUR_ACCOUNT_ADDRESS}
```

接下来我们可以使用 Rooch CLI 来提交一些测试交易。

测试创建一个 DaySummary 对象：

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::day_summary_aggregate::create --sender-account {YOUR_ACCOUNT_ADDRESS} --args u16:2023 string:"ChineseLunar" u8:6 bool:false u8:18 string:"Beijing" string:"bar" string:"foo" vector\<string\>:"item1","item2" vector\<string\>:"optional_1" vector\<u16\>:1,6 vector\<u32\>:3,2 vector\<u64\>:6,4 vector\<u128\>:1,2,8 vector\<u256\>:2,5,6
```

测试创建一个 Product 对象：

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::product_aggregate::create --sender-account {YOUR_ACCOUNT_ADDRESS} --args String:"product_1" u128:10000
```

可以通过 JSON RPC 查询事件，得到新创建的 Product 的 ObjectID：

```shell
curl --location --request POST 'http://localhost:50051' \
--header 'Content-Type: application/json' \
--data-raw '{
 "id":101,
 "jsonrpc":"2.0",
 "method":"rooch_getEventsByEventHandle",
 "params":["{YOUR_ACCOUNT_ADDRESS}::product::ProductCreated"]
}' | jq '.result.data[0].parsed_event_data.value.id.value.vec[0]'
```

记录输出的 Product ObjectID，使用它来替换下面的命令中的占位符 `{PRODUCT_OBJECT_ID}`。

测试创建订单（需要使用上面得到的 Product 的 ObjectID）：

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::order_aggregate::create --sender-account {YOUR_ACCOUNT_ADDRESS} --args string:"ord_001" object_id:{PRODUCT_OBJECT_ID} u64:1
```

通过 JSON RPC 查询事件，获得新创建的订单对象的 ObjectID：

```shell
curl --location --request POST 'http://localhost:50051' \
--header 'Content-Type: application/json' \
--data-raw '{
 "id":101,
 "jsonrpc":"2.0",
 "method":"rooch_getEventsByEventHandle",
 "params":["{YOUR_ACCOUNT_ADDRESS}::order::OrderCreated"]
}' | jq '.result.data[0].parsed_event_data.value.id.value.vec[0]'
```

记录输出的订单 ObjectID，使用它来替换下面的命令中的占位符 `{ORDER_OBJECT_ID}`。

测试创建订单聚合内的 OrderShipGroup 对象：

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::order_aggregate::add_order_ship_group --sender-account {YOUR_ACCOUNT_ADDRESS} --args object_id:{ORDER_OBJECT_ID} u8:1 string:"ship_method_1" object_id:{PRODUCT_OBJECT_ID} u64:1 
```

测试创建订单聚合内的 OrderItemShipGroupAssocSubitem 对象：

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::order_aggregate::add_order_item_ship_group_assoc_subitem --sender-account {YOUR_ACCOUNT_ADDRESS} --args object_id:"{ORDER_OBJECT_ID}" u8:1 object_id:"{PRODUCT_OBJECT_ID}" u16:2023 string:"ChineseLunar" u8:6 bool:false u8:18 string:"Beijing" string:"desc"
```


### 配置链下服务

打开位于目录 `rooch-java-service/roochtestproj1-service-rest/src/main/resources` 下的 `application-test.yml` 文件，找到类似下面的几行，将占位符 `{YOUR_ACCOUNT_ADDRESS}` 替换为你的账户地址：

```yaml
rooch:
  contract:
    address: "{YOUR_ACCOUNT_ADDRESS}"
    jsonrpc:
      url: "http://127.0.0.1:50051"
```

这是链下服务唯一必需配置的地方，就是这么简单。

### 创建链下服务的数据库

使用 MySQL 客户端连接本地的 MySQL 服务器，执行以下脚本创建一个空的数据库（假设名称为 test2）：

```sql
CREATE SCHEMA `test2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
```

进入 `rooch-java-service` 目录，打包 Java 项目：

```shell
mvn package
```

然后运行一个命令行工具，初始化数据库：

```shell
java -jar ./roochtestproj1-service-cli/target/roochtestproj1-service-cli-0.0.1-SNAPSHOT.jar ddl -d "./scripts" -c "jdbc:mysql://127.0.0.1:3306/test2?enabledTLSProtocols=TLSv1.2&characterEncoding=utf8&serverTimezone=GMT%2b0&useLegacyDatetimeCode=false" -u root -p 123456
```

### 启动链下服务

在 `rooch-java-service` 目录下，执行以下命令启动链下服务：

```shell
mvn -pl roochtestproj1-service-rest -am spring-boot:run
```

现在，你可以访问 RESTful API 获取已创建的订单信息：http://localhost:1023/api/Orders

可以使用参数过滤订单信息，比如：http://localhost:1023/api/Orders?totalAmount=10000

通过这个接口，你可以获取已创建的 Product 对象的列表：http://localhost:1023/api/Products

通过这个接口，你可以获取已创建的 DaySummary 对象的列表：http://localhost:1023/api/DaySummaries


### 源代码

你可能已经注意到，根据以上过程重现的源代码已经放置在本代码库：https://github.com/dddappp/A-Rooch-Demo

## 忽略某些文件的生成

项目创建工具生成的代码文件中，有一大部分是根据模型推导而来的样板代码。当模型发生了修改后，重新运行项目创建工具，这些代码文件默认情况下会被重新生成和覆盖。这些文件的开头大多数都有“autogenerated”字样的注释。

如果你想要修改这些文件，并且在重新生成代码时它们不被覆盖，那么你可以在特定的目录下放置一个 `.dddmlignore` 文件来做到这一点：

* javaProjectsDirectoryPath 参数指定的目录。
* roochMoveProjectDirectoryPath 参数指定的目录。

`.dddmlignore` 文件与 `.gitignore` 文件类似，每一行代表一个忽略规则。比如，下面的规则表示需要忽略重新生成所有目录层级中以 Order 或 order 开头的文件：

```text
**/[Oo]rder*
```

## 一些提示

### 使用这个 Rooch Move CLI Cheatsheet

在链下服务启动后，你可以访问这个网址，得到一个如何使用 Rooch Move CLI 调用链上合约的速查表（Cheatsheet）：http://localhost:1023/api/rooch.contract/RoochMoveCLICheatsheet.md

在 Cheatsheet 中已经把刚才发布的 Move 合约的地址帮你填好了。你需要填写的参数是一些“有名字”的占位符。 你可以拷贝这些命令，视你的需要稍作修改，然后在命令行终端中直接执行。

### 如何编写 DDDML 领域模型

#### 使用 JSON Schema

你可能会觉得手写 DSL 模型有点麻烦，别担心，我们已经在编写 DDDML 的 JSON Schema。这里有个还有待完善的 Schema 文件：https://raw.githubusercontent.com/wubuku/dddml-spec/master/schemas/dddml-schema.json

DDDML 是一种基于 YAML 的 DSL，而 YAML 是 JSON 的超集，所以 JSON Schema 可以生效。

如果你的 IDE 支持，你可以配置一下，然后在用 DDDML 编写模型的时候，就有自动补全之类的支持了。

比如，在 VS Code 的 `.vscode/settings.json` 文件中可以像这样设置：

```json
{
    "yaml.schemas": {
        "https://raw.githubusercontent.com/wubuku/dddml-spec/master/schemas/dddml-schema.json": [
            "dddml/*.yaml", //file match pattern
            "dddml/*.yml"
        ]
    }
}
```

### 清理已经退出的 Docker 容器

执行命令：

```shell
docker rm $(docker ps -aq --filter "ancestor=wubuku/dddappp-rooch:0.0.1")
```

