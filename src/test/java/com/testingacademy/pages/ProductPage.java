package com.testingacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

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

    public void selectProduct(String productName) {
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='" + productName + "']")).click();
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-" + productName.toLowerCase().replace(" ", "-") + "']")).click();
    }
}
