package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.factory.DriverFactory;
import com.testingacademy.pages.CartPage;
import com.testingacademy.pages.CheckoutOverviewPage;
import com.testingacademy.pages.CheckoutPage;
import com.testingacademy.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void verifyCheckoutInformation() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(DriverFactory.getDriver());
        cartPage.clickCart();
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.checkoutOverview("Aditi", "Soni", "560092");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverFactory.getDriver());
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("checkout-complete")
        );
    }
}
