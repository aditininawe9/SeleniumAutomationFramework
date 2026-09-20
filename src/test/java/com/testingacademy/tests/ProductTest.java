package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.factory.DriverFactory;
import com.testingacademy.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends BaseTest {
    @Test
    public void validProductPage() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        List<String> products =  productPage.getProductNames();
        Assert.assertFalse(products.isEmpty());
        productPage.selectProduct("Sauce Labs Backpack");
        productPage.addProductToCart("Sauce Labs Backpack");
    }

}
