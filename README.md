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

如果你已经安装了 Docker，可以使用 Docker 来运行一个 MySQL 数据库服务。比如：

```shell
sudo docker run -p 3306:3306 --name mysql \
-v ~/docker/mysql/conf:/etc/mysql \
-v ~/docker/mysql/logs:/var/log/mysql \
-v ~/docker/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:5.7
```


## 示例：重现 Demo 应用的开发过程

我们在 GitHub 上放置了一个使用 dddappp 低代码工具开发的 Demo 应用。这个应用的代码分为两部分（TODO `rooch-java-service`...）：

* Rooch Move 链上合约：https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch_contracts

* ~~Java 链下服务：https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch-java-service~~

你可以按照下面的介绍重现该 Demo 的开发过程。

### 编写 DDDML 模型文件

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
--boundedContextRoochNumericalAddress 0x123 \
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

* boundedContextRoochNumericalAddress 是链上 Rooch 合约默认的数字地址。

* javaProjectsDirectoryPath 是放置链下服务代码的目录路径。链下服务由多个模块（项目）组成。它应该使用容器内的可以读写的目录路径。

* javaProjectNamePrefix 是组成链下服务的各模块的名称前缀。建议使用一个全小写的名称。

* pomGroupId 链下服务的 GroupId，我们使用 Maven 作为链下服务的项目管理工具。它应该全小写、各部分以点号分隔。

* roochMoveProjectDirectoryPath 是放置链上 Rooch 合约代码的目录路径。它应该使用容器内可以读写的目录路径。

上面的命令执行成功后，在本地目录 `/PATH/TO/test` 下应该会增加一个目录 `rooch-contracts`。

~~（TODO `rooch-java-service`...）~~

~~此时可以尝试编译链下服务。进入目录 `rooch-java-service`，执行：mvn compile~~

~~如果没有意外，编译应该可以成功。~~

此时，链上合约还不能通过编译，因为“业务逻辑”还没有实现。下面我们就来实现它们。

#### 关于生成的链上合约代码

需要注意的是，目前生成的链上合约代码，是将聚合根实体（比如 Order 聚合的那个 Order，即订单实体）的状态保存在 一个 Table 中的。

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

#### 编译 Apots Move 合约

在目录 `rooch-contracts`下 执行编译，现在应该可以编译成功了：

```shell
rooch move build
```

到现在为止，应用开发的编码阶段已经完成了！是不是非常简单？

---

下面我们来部署和测试 Demo 应用。

### 发布 Rooch 合约

在完成业务逻辑的编写之后，在目录 `rooch-contracts` 下执行以下命令，将合约发布到本地开发网络：

```shell
rooch server start
```


```shell
    rooch move publish --sender-account 0x123
```

初始化合约：

```shell
# todo ...
```


[TBD]

### TODO 链下 Java 服务 `rooch-java-service` 

运行链下 Java 服务需要设置的配置项：

* 合约部署的地址。注意，目前合约部署并调用初始化方法后，会生成一个资源账户。

* 使用的网络的 Node API 的 BaseURL（废话）。

链下 Java 服务依赖的 Rooch Node API 接口：

* [TBD]

## 一些提示

### 清理已经退出的 Docker 容器

执行命令：

```shell
docker rm $(docker ps -aq --filter "ancestor=wubuku/dddappp-rooch:0.0.1")
```
