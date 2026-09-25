package com.testingacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private By firstName = By.cssSelector("[data-test='firstName']");
    private By lastName = By.cssSelector("[data-test='lastName']");
    private By postalCode = By.cssSelector("[data-test='postalCode']");
    private By continueBtn = By.cssSelector("[data-test='continue']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(value);
    }

    public void enterLastName(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName))
                .sendKeys(value);
    }

    public void enterPostalCode(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode))
                .sendKeys(value);
    }

    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn))
                .click();
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void checkoutOverview(String fName, String lName, String pCode) {
        enterFirstName(fName);
        enterLastName(lName);
        enterPostalCode(pCode);
        clickContinue();
    }
}
