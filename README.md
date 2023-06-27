# Developing Rooch Decentralized Applications using the dddappp Low-Code Tool

English | [中文](README_CN.md)


## Prerequisites

Currently, the dddappp low-code tool is published as a Docker image for developers to experience.

The off-chain services generated by the tool are written in Java and use the MySQL database by default.

So before getting started, you need to:

* Install [Rooch CLI](https://github.com/rooch-network/rooch).

* Install [Docker](https://docs.docker.com/engine/install/).

* Install MySQL database server.

* Install JDK and Maven. The off-chain services generated by the tool currently use Java.

* Install `curl` and `jp` command (jp - commandline JSON processor, optional). We can use jp to process JSON RPC returned JSON results when testing contracts.

If you have already installed Docker, you can use Docker to run a MySQL database server. For example:

```shell
sudo docker run -p 3306:3306 --name mysql \
-v ~/docker/mysql/conf:/etc/mysql \
-v ~/docker/mysql/logs:/var/log/mysql \
-v ~/docker/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:5.7
```

Note that in the above command we set the password of the database `root` account to `123456`, and in the following example shell commands and configuration of the Off-chain service we use this root account/password directly. You can modify them according to your running environment.

## Example: Reproduce the Development Process of the Demo Application

We have placed a Demo application developed using the dddappp low-code tool on GitHub. The application code is divided into two parts:

* Rooch Move on-chain contracts: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch_contracts

* Java off-chain service: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch-java-service

You can follow the instructions below to reproduce the development process of this Demo. 

It should be noted that we assume that you want to deploy the Move contracts to the Rooch local server, so we skip the instructions on how to modify certain configuration files required for deployment to other networks.

### Write DDDML Model Files

Our low-code tool relies on the domain model described by DDDML (Domain-Driven Design Modeling Language) to generate various parts of the application code.

> **Tip**
>
> About DDDML, here is an introductory article: ["Introducing DDDML: The Key to Low-Code Development for Decentralized Applications"](https://github.com/wubuku/Dapp-LCDP-Demo/blob/main/IntroducingDDDML.md). This article contains detailed explanations of some DDDML model files used in this Demo.

You can create a directory, for example, called `test`, to place all the application code, and then create a subdirectory `dddml` within this directory. We generally put the model files written according to the DDDML specification in this directory.

You can download/copy the sample model files here to the `dddml` directory: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/domain-model/rooch

In these models, some of the fabricated examples may have become a bit "absurdly" complicated, but our tool is not "stumped".


### Run dddappp Project Creation Tool

Use Docker to run the project creation tool:

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

The command parameters above are straightforward:

* Note that `/PATH/TO/test` should be replaced with the path of the local directory where you actually place the application code. This line indicates mounting the local directory into the `/myapp` directory inside the container.

* `dddmlDirectoryPath` is the directory where the DDDML model files are located. It should be a directory path that can be read in the container.

* Understand the value of the `boundedContextName` parameter as the name of the application you want to develop. When the name has multiple parts, separate them with dots and use the PascalCase naming convention for each part. Bounded-context is a term in Domain-driven design (DDD) that refers to a specific problem domain scope that contains specific business boundaries, constraints, and language. If you cannot understand this concept for the time being, it is not a big deal.

* `boundedContextJavaPackageName` is the Java package name of the off-chain service. According to Java naming conventions, it should be all lowercase and the parts should be separated by dots.

* `boundedContextRoochPackageName` is the package name of the on-chain Rooch contract. It is recommended to use PascalCase naming style.

* `boundedContextRoochNamedAddress` is the default named address of the on-chain Rooch contracts. It is recommended to use snake_case naming style.

* `javaProjectsDirectoryPath` is the directory path where the off-chain service code is placed. The off-chain service consists of multiple modules (projects). It should be a readable and writable directory path in the container.

* `javaProjectNamePrefix` is the name prefix of each module of the off-chain service. It is recommended to use an all-lowercase name.

* `pomGroupId` is the GroupId of the off-chain service. We use Maven as the project management tool for off-chain service. It should be all lowercase and the parts should be separated by dots.

* `roochMoveProjectDirectoryPath` is the directory path where the on-chain Rooch contract code is placed. It should be a readable and writable directory path in the container.

After the above command is successfully executed, two directories `rooch-java-service` and `rooch-contracts` should be added to the local directory `/PATH/TO/test`.

Now you can try to compile the off-chain service. Go to the directory `rooch-java-service` and run:

```shell
mvn compile
```

If there is no unexpected failure, the compilation should be successful.

At this point, the on-chain contracts cannot be compiled because the "business logic" has not been implemented yet. Now we will implement it.


### Implementing Business Logic

The tool has generated some files with the suffix `_logic.move` in the directory `rooch-contracts/sources`. These files contain skeleton code of functions that implement business logic, namely the signature part of the functions. Now you just need to fill in the implementation part of the functions.

You can consider copying the implementation code of the business logic that has been written here: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/rooch-contracts/sources

You can also clone the code repository of this Demo application and then execute a shell script like the following to complete the copy work (note that replace `_PATH_TO_/Dapp-LCDP-Demo` and `_PATH_TO_/test` with the actual paths on your local machine):

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

#### Compile Rooch Move Contracts

Compile the Move contract code in the directory `rooch-contracts`, and it should compile successfully now (note to replace the placeholder `{YOUR_ACCOUNT_ADDRESS}` with one of your account addresses):

```shell
rooch move build --named-addresses rooch_demo={YOUR_ACCOUNT_ADDRESS}
```

So far, the coding phase of application development is complete! Isn't it very simple?

---

Next, let's deploy and test the Demo application.

### Deploy Rooch Contract

First, run a local Rooch development server:

```shell
rooch server start
```

After completing the writing of the business logic, execute the following command in the directory `rooch-contracts` to publish the contracts to the local development network (note to replace the placeholder `{YOUR_ACCOUNT_ADDRESS}` with one of your account addresses):

```shell
rooch move publish --named-addresses rooch_demo={YOUR_ACCOUNT_ADDRESS}
```

Then, initialize the contracts:

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::rooch_demo_init::initialize --sender-account {YOUR_ACCOUNT_ADDRESS}
```

Next, we can use Rooch CLI to submit some test transactions.

Test creating a `DaySummary` object:

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::day_summary_aggregate::create --sender-account {YOUR_ACCOUNT_ADDRESS} --args u16:2023 string:"ChineseLunar" u8:6 bool:false u8:18 string:"Beijing" string:"bar" string:"foo" vector\<string\>:"item1","item2" vector\<string\>:"optional_1" vector\<u16\>:1,6 vector\<u32\>:3,2 vector\<u64\>:6,4 vector\<u128\>:1,2,8 vector\<u256\>:2,5,6
```

Test creating a `Product` object:

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::product_aggregate::create --sender-account {YOUR_ACCOUNT_ADDRESS} --args String:"product_1" u128:10000
```

You can query events through JSON RPC and get the ObjectID of the newly created Product:

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

Record the output Product ObjectID and use it to replace the placeholder `{PRODUCT_OBJECT_ID}` in the following commands.

Test creating an `Order` (you need to use the ObjectID of the Product obtained above):

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::order_aggregate::create --sender-account {YOUR_ACCOUNT_ADDRESS} --args string:"ord_001" object_id:{PRODUCT_OBJECT_ID} u64:1
```

Query events through JSON RPC and get the ObjectID of the newly created Order object:

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

Record the output order ObjectID and use it to replace the placeholder `{ORDER_OBJECT_ID}` in the following commands.

Test creating an `OrderShipGroup` object within the Order aggregate:

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::order_aggregate::add_order_ship_group --sender-account {YOUR_ACCOUNT_ADDRESS} --args object_id:{ORDER_OBJECT_ID} u8:1 string:"ship_method_1" object_id:{PRODUCT_OBJECT_ID} u64:1 
```

Test creating an `OrderItemShipGroupAssocSubitem` object within the order aggregate:

```shell
rooch move run --function {YOUR_ACCOUNT_ADDRESS}::order_aggregate::add_order_item_ship_group_assoc_subitem --sender-account {YOUR_ACCOUNT_ADDRESS} --args object_id:"{ORDER_OBJECT_ID}" u8:1 object_id:"{PRODUCT_OBJECT_ID}" u16:2023 string:"ChineseLunar" u8:6 bool:false u8:18 string:"Beijing" string:"desc"
```


### Configure Off-chain Service

Open the file application-test.yml in the directory `rooch-java-service/roochtestproj1-service-rest/src/main/resources`, find the following lines, and replace the placeholder `{YOUR_ACCOUNT_ADDRESS}` with your account address:

```yaml
rooch:
  contract:
    address: "{YOUR_ACCOUNT_ADDRESS}"
    jsonrpc:
      url: "http://127.0.0.1:50051"
```

This is the only place where the off-chain service needs to be configured, and it's that simple.

### Creating a Database for Off-Chain Service

Use a MySQL client to connect to the local MySQL server and execute the following script to create an empty database (assuming the name is `test2`):

```sql
CREATE SCHEMA `test2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
```

Go to the `rooch-java-service` directory and package the Java project:

```shell
mvn package
```

Then, run a command-line tool to initialize the database:

```shell
java -jar ./roochtestproj1-service-cli/target/roochtestproj1-service-cli-0.0.1-SNAPSHOT.jar ddl -d "./scripts" -c "jdbc:mysql://127.0.0.1:3306/test2?enabledTLSProtocols=TLSv1.2&characterEncoding=utf8&serverTimezone=GMT%2b0&useLegacyDatetimeCode=false" -u root -p 123456
```

### Starting Off-Chain Service

In the `rooch-java-service` directory, run the following command to start the off-chain service:

```shell
mvn -pl roochtestproj1-service-rest -am spring-boot:run
```

Now, you can access the off-chain service's RESTful API to get the orders that has been created: http://localhost:1023/api/Orders

You can use arguments to filter order information, such as: http://localhost:1023/api/Orders?totalAmount=10000

Through this interface, you can get a list of Product objects that have been created: http://localhost:1023/api/Products

Through this interface, you can get a list of DaySummary objects that have been created: http://localhost:1023/api/DaySummaries


### Source Code

You may have noticed that the source code reproduced based on the above process has been placed in this repository: https://github.com/dddappp/A-Rooch-Demo

## Ignore Generating Files

In the code files generated by the project creation tool, a large part is template code generated based on the model. When the model is modified and the project creation tool is run again, these code files will be regenerated and overwritten by default. Most of these files have a comment with the word "autogenerated" at the beginning.

If you want to modify these files and not have them overwritten when the code is regenerated, you can place a `.dddmlignore` file in a specific directory:

* The directory specified by the `javaProjectsDirectoryPath` parameter.
* The directory specified by the `roochMoveProjectDirectoryPath` parameter.

The `.dddmlignore` file is similar to a `.gitignore` file, with each line representing an ignore rule. For example, the following rule means that all files starting with "Order" or "order" in all directory levels need to be ignored when regenerated:

```text
**/[Oo]rder*
```


## Some Tips

### Use this Rooch Move CLI Cheatsheet

After the off-chain service is started, you can access this URL and get a cheatsheet on how to use Rooch Move CLI to call on-chain contracts: http://localhost:1023/api/rooch.contract/RoochMoveCLICheatsheet.md

The address of the Move contract you just deployed has been filled in for you in the Cheatsheet. The parameters you need to fill in are some "named" placeholders.

You can copy these commands, modify them as needed, and execute them directly in the command line terminal.

### How to Write DDDML Domain Model

#### Use JSON Schema

You may find it a bit troublesome to write DSL models by hand. Don't worry, we have already written a JSON Schema for DDDML. Here is a Schema file that still needs to be improved: https://raw.githubusercontent.com/wubuku/dddml-spec/master/schemas/dddml-schema.json

DDDML is a YAML-based DSL, and YAML is a superset of JSON, so JSON Schema can work.

If your IDE supports it, you can configure it and then have autocomplete and other support when writing models with DDDML.

For example, in VS Code's `.vscode/settings.json` file you can set it like this:

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

### Clean Up Exited Docker Containers

Run the command:

```shell
docker rm $(docker ps -aq --filter "ancestor=wubuku/dddappp-rooch:0.0.1")
```

