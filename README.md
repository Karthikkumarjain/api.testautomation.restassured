# Test Automation with Rest Assured for rest apis

This is a sample test framework for api testing with RestAssured. The tests and other classes are written in Java.


## Prerequisite

Since this is based on Java language, so the pre-requisite is to have latest version of JDK installed on our system along with maven.

* Clone the repo
* Run "maven clean compile" or build the project in any IDE.
* See the Run Tests section on how to run the tests
## Structure

The primary directories are as follows


* main/java/com.* : Contains the class files as POJO.
* base : Contains a base test class file that initializes the basic setup with requestSpecification and responseSpecification.
* constants : Contains a class that has commonly used constants.
* endpoints : Contains endpoint for each of the interfaces/apis.
* reports: Contains a class file that helps in creation of extent report.
* utils: Contains some utils classes that can be useful in calling repetitive functions related to property file reader,database and encryption-decryption.
* apitests : Contain the tests for the rest apis.
* schemas: Lists the schemas of json and xml.

## System Under Test

The application  under test are under src/test/endpoints

## Libraries Used

* junit : For driving the tests.
* restassured : To add tests related to Android and iOS application.
* jasypt : To encrypt and decrypt sensitive information.
* assertj: To write tests with much effective assertions.
* jackson-databind: To serialize and deserialize JSON to and from POJO
* oracle jdbc: To connect to database.

## Run Tests

To run the tests in local use

```bash
  mvn clean test
```

## Reports

* Reports are generated as part of surefire plugin