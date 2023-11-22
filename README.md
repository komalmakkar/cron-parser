# CRON JOB SCHEDULER

## How to Get Started

### 1. Set Up Your Machine

This project requires Java, Maven, IntelliJ IDEA, and Git. Follow the installation guides below to set up your machine:

- [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

### 2. Learn the Technologies

Before you start, make sure you're familiar with the technologies used in this project. Here are some resources to help you get started:

- [Java Tutorial](https://docs.oracle.com/javase/tutorial/)
- [Maven Tutorial](https://maven.apache.org/guides/getting-started/index.html)
- [IntelliJ IDEA Tutorial](https://www.jetbrains.com/help/idea/getting-started.html)
- [Git Tutorial](https://git-scm.com/docs/gittutorial)

### 3. Learn Cron Job Scheduling

This project uses cron job scheduling. If you're not familiar with it, check out these resources:

- [Cron Job Basics](https://en.wikipedia.org/wiki/Cron)
- [Cron Job Tutorial](https://www.ostechnix.com/a-beginners-guide-to-cron-jobs/)

## 4. Directory Structure 

This Maven-based Java project follows a standard directory structure:

- **src**: Contains the main and test source code.
  - **src/main**: Contains the main source code.
    - **src/main/java**: Contains Java source code files.
    - **src/main/resources**: Contains non-Java resources like configuration files.
  - **src/test**: Contains the test code.
    - **src/test/java**: Contains test code files.
    - **src/test/resources**: Contains test-specific resources.
- **target**: Generated by Maven, contains compiled output and build artifacts. Your JAR Files live here. 
- **pom.xml**: The Project Object Model (POM) file, defines project configuration.
- **README.md**: Provides documentation and instructions for the project.

## What the Project Does

This project parses cron jobs. It follows these steps:

1. Validate: Ensure the cron job is valid.
2. Expand and Parse: Expand the cron job into its individual components and parse them.
3. Post Processing: Perform any necessary post-processing.



## How to Run the App


**Start the application using any of the commands mentioned below**

> **Note:** First two commands need to run inside the root folder of this project i.e inside the **spring-boot-hello-world** folder


- **Using maven** <br/>``` mvn spring-boot:run```


- **From jar file**
  Create a jar file using '**mvn clean install**' command and then execute
  <br/>```java -jar target/cron-job-1.0.2-SNAPSHOT.jar```


- **Directly from IDE**
  <br/>```Right click on CronParser.java and click on 'Run' option```
  <br/><br/>

> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.properties** file that is available inside the **src > main > resources** folder.

<br/>
## How to Test the Endpoints

You can use curl commands to test the endpoints of this project. Here are some examples:

- **GET Request**
  ```bash
  curl -X GET http://localhost:8080/health
  ```

  - **PUT Request**
  ```bash
  curl --location --request PUT 'http://localhost:8080/parse/' --header 'Content-Type: application/json' \--data '{ "CronExpression": "* * * * * /komakkar" }'
  ```





## How to Run the Tests

> **Note:** These commands need to run inside the root folder of this project i.e inside the **spring-boot-hello-world** folder

- **To run all the test cases**
  <br/>```mvn test```


- **To run a particular test class**
  <br/>```mvn -Dtest=HelloWorldControllerTest test```
  <br/>or
  <br/>```mvn -Dtest=HelloWorldApplicationTests test```

### Test Coverage and Reporting 

This project uses Jacoco, a code coverage library for Java. Here's how you can generate and access Jacoco reports:

1. Run the tests with Jacoco enabled. You can do this by running the following command:

  ```bash
  mvn clean test jacoco:report
```

  This command will execute the tests and generate the Jacoco coverage report.

2. After running the command, you can find the Jacoco reports in the `target/site/jacoco` directory. Open the `index.html` file in your web browser to view the detailed coverage report.

```bash
  open target/site/jacoco/index.html
```

  This will open the coverage report in your default web browser.


## Contribution Guidelines

 - Follow the coding style and conventions of the project. Use EditorConfig. 
 - Write clear and concise code with proper comments.
 - Test your changes thoroughly before submitting a pull request.
 - Document any new features or changes in the project's documentation.
 - Follow the project's version control and branching strategy.
 - Be respectful and considerate towards other contributors.
 - Follow the project's code review process.
 - Contribute to discussions and provide constructive feedback.
 - Help maintain the project's code quality and stability.





