package com.testingacademy.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.testingacademy.utils.ConfigReader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver() {
        String browser = ConfigReader.get("browser");

        if("firefox".equals(browser)) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
