package com.testingacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartItem = By.cssSelector("[data-test='inventory-item-name']");
    private By cartItemPrice = By.cssSelector("[data-test='inventory-item-price']");
    private By cartItemQuantity = By.cssSelector("[data-test='item-quantity']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

        public String getCartItemName() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItem)
        ).getText();
    }

    public String getCartItemPrice() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItemPrice)
        ).getText();
    }

    public String getCartItemQuantity() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartItemQuantity)
        ).getText();
    }

    public void removeProductFromCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement removeProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-test='remove-" + productName.toLowerCase().replace(" ", "-") + "']"))
        );
        removeProduct.click();
    }

    public boolean isProductPresent(String productName) {

        By product = By.xpath(
                "//div[@data-test='inventory-item-name' and text()='"
                        + productName + "']"
        );

        return !driver.findElements(product).isEmpty();
    }
}
