package com.testingacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    By sortDropdown = By.cssSelector("[data-test='product-sort-container']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductNames() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='inventory-item-name']")
                )
        );

        List<String> productNames = new ArrayList<>();

        List<WebElement> products = driver.findElements(
                By.cssSelector("[data-test='inventory-item-name']")
        );

        for (WebElement product : products) {
            productNames.add(product.getText());
        }

        return productNames;
    }

    public List<String> getProductPrices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='inventory-item-price']")
                )
        );

        List<String> productPrice = new ArrayList<>();

        List<WebElement> products = driver.findElements(
                By.cssSelector("[data-test='inventory-item-price']")
        );

        for (WebElement product : products) {
            productPrice.add(product.getText());
        }

        return productPrice;
    }

    public void sortProducts(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='product-sort-container']")
                )
        );

        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }
    public void selectProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@data-test='inventory-item-name' and text()='" + productName + "']")
        ));
        product.click();
    }

    public void addProductToCart(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@data-test='add-to-cart-" + productName.toLowerCase().replace(" ", "-") + "']"))
                );
        addProduct.click();
    }

    public String getCartCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartBadge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='shopping_cart_badge']"))
        );
        return cartBadge.getText();
    }

    public void addProductToCartFromDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@data-test='add-to-cart']"))
        );
        addProduct.click();
    }
}
