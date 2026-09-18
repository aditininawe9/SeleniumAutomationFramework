# Selenium Automation Framework

## Overview

This project is a Selenium WebDriver automation framework built using Java, TestNG, Maven, and Page Object Model (POM).

The framework is currently being developed as part of my QA Automation learning and portfolio project.

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Git & GitHub

## Framework Structure

```text
src
├── test
│   ├── java
│   │   └── com.testingacademy
│   │       ├── base
│   │       │   └── BaseTest.java
│   │       ├── factory
│   │       │   └── DriverFactory.java
│   │       ├── pages
│   │       │   └── LoginPage.java
│   │       ├── tests
│   │       │   └── LoginTest.java
│   │       └── utils
│   │           └── ConfigReader.java
│   │
│   └── resources
│       └── config.properties
```

## Current Features

* WebDriver initialization and management
* Browser setup and teardown using TestNG
* Configuration using properties file
* Page Object Model implementation
* Login automation
* TestNG assertions
* Maven project setup

## Test Application

The framework currently uses SauceDemo for UI automation testing.

## Test Scenario

### Valid Login

**Test Data**

* Username: `standard_user`
* Password: `secret_sauce`

**Expected Result**

User should be successfully logged in and redirected to the inventory page.

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Make sure Java and Maven are configured.
4. Run the TestNG test from `LoginTest.java`.

## Project Status

🚧 This framework is actively being developed.

Planned additions include:

* Inventory Page Object
* Explicit waits
* Negative test scenarios
* Additional test cases
* Reporting
* Cross-browser execution
* CI/CD integration
