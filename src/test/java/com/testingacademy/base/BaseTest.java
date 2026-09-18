package com.testingacademy.base;

import com.testingacademy.factory.DriverFactory;
import com.testingacademy.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        ConfigReader.loadProperties();

        DriverFactory.initDriver();

        DriverFactory.getDriver().get(
                ConfigReader.get("url")
        );
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
