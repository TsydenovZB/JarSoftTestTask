## BannerManager

Spring Boot application for managing advertising banners.
Web application for managing advertising banners and categories.
Banners and categories can be created, edited and deleted.
The selection of the banner occurs through a standard HTTP request, with the category specified in the request parameters.

### Requirements

JRE: 8 or higher

MAVEN: preferably latest version

MySQL-server: preferably latest version

There should be at least 3 tables in total: category, banner, requests.

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
