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

- Page Object Model (POM)
- Selenium WebDriver
- Java
- TestNG
- Maven
- Explicit Waits
- Reusable DriverFactory
- ConfigReader for test configuration

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
│   │       │   └── ProductPage.java
│   │       ├── tests
│   │       │   └── LoginTest.java
│   │       │   └── ProductTest.java
│   │       └── utils
│   │           └── ConfigReader.java
│   │
│   └── resources
│       └── config.propertiesc

## Current Features

* Java + Selenium WebDriver
* TestNG
* Page Object Model (POM)
* BaseTest for setup and teardown
* DriverFactory for WebDriver management
* ConfigReader for configuration
* Chrome and Firefox browser support
* Browser selection through config.properties
* Explicit waits using WebDriverWait
* Valid login automation
* TestNG assertion for successful login

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

## Configuration

Browser and application URL are configured in:

browser=chrome
url=https://www.saucedemo.com/

The browser can be changed without modifying the test code


## Current Test

Valid Login

Open application
↓
Enter username
↓
Enter password
↓
Click Login
↓
Verify inventory page
↓
Add Product to Cart
↓
Close browser

## Automated Scenarios

### Login
- Valid login
- Invalid login

### Product
- Verify products are displayed
- Verify product names
- Select a product
- Add product to cart

### Dropdown
- Verify Name (A to Z)
- Verify Name (Z to A)
- Verify Price (low to high)
- Verify Price (high to low)
For the complete test case list, see [TEST_CASES.md](TEST_CASES.md).