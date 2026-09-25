package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.factory.DriverFactory;
import com.testingacademy.pages.CartPage;
import com.testingacademy.pages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void verifyProductsInCart() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(DriverFactory.getDriver());
        DriverFactory.getDriver().findElement(By.className("shopping_cart_link")).click();

        Assert.assertEquals(
                cartPage.getCartItemName(),
                "Sauce Labs Backpack",
                "Added product should appear in cart"
        );

        Assert.assertEquals(
                cartPage.getCartItemPrice(),
                "$29.99",
                "Product price should be displayed correctly in cart"
        );

        Assert.assertEquals(
                cartPage.getCartItemQuantity(),
                "1",
                "Product quantity should be 1"
        );

        cartPage.removeProductFromCart("Sauce Labs Backpack");
        Assert.assertFalse(
                cartPage.isProductPresent("Sauce Labs Backpack"),
                "Product should be removed from cart"
        );
    }
}
