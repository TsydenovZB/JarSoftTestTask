## BannerManager

Spring Boot application for managing advertising banners.
Each banner has a category.
Categories and banners can be added/removed.

### Requirements

JRE: 8 or higher

MAVEN: preferably latest version

MySQL-server: preferably latest version

### Installation

1. download project source
2. in root directory of project execute command **mvn package**
3. in folder **target** you can find compiled program **JarSoftTestTask.jar**

### Usage

- For configuring database connection, program need a configuration file named **dbconfig.properties** in same folder, with next content:
```
db-user=<db user name>
db-port=<db port>
db-address=<db address (localhost, for example)>
db-name=<db name>
db-password=<db user password>
```
If file **dbconfig.properties** does not exist, program will try to create it automatically with default configuration.

- To run the program execute command **java -jar JarSoftTestTask.jar** in program folder. Program works on port 8080.
