# shareNow_US1

The solution with desktop registration tests

## Framework stack

* Java 11
* Selenium WebDriver/Selenide framework
* Maven (Build automation tool)
* Cucumber (BDD test tool)
* JUnit (Unit testing framework and runner)
* Spring (Application and IoC framework)
* Log4j (Logging tool)

## Prerequisites

You need to have following installed and env variables configured:

* Java 11
* Apache Maven 3

## Test configurations

Framework host properties can be found in application.properties. Please set browser.type variable to run tests in particular browser(in uppercase). CHROME is set by default. 

Configure

```
Import a project as maven project, build and import dependencies
Setup projectSDK
```
Run

```
From junit runner classes directly

Go to scr/test/java/runners/RunCucumberAllTests and hit rum on the class
```

```
From terminal with maven command

to run all the tests for the regression
mvn clean test -Dcucumber.options="--tags @all"

to run a separate test, please mark the scenario with @wip annotation
mvn clean test -Dcucumber.options="--tags @wip"
```

```
With junit runner

setup a junit configuration and run with IDE 
```


## Results

Test results report can be found here "target/cucumber-pretty/index.html" or in the console.
