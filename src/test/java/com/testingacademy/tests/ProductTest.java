package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.factory.DriverFactory;
import com.testingacademy.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductTest extends BaseTest {
    @Test
    public void validProductPage() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        List<String> products =  productPage.getProductNames();
        List<String> productPrices = productPage.getProductPrices();

        Assert.assertFalse(products.isEmpty(), "Product list should not be empty");
        Assert.assertFalse(productPrices.isEmpty(),"Product list should not be empty");
    }
    @Test
    public void verifyProductsSortedAZ() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        productPage.sortProducts("Name (A to Z)");

        List<String> actualProducts = productPage.getProductNames();

        List<String> expectedProducts = new ArrayList<>(actualProducts);
        Collections.sort(expectedProducts);

        Assert.assertEquals(actualProducts, expectedProducts);
    }

    @Test
    public void verifyProductsSortedZA() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());

        productPage.sortProducts("Name (Z to A)");

        List<String> actualProducts = productPage.getProductNames();

        List<String> expectedProducts = new ArrayList<>(actualProducts);
        Collections.sort(expectedProducts, Collections.reverseOrder());

        Assert.assertEquals(actualProducts, expectedProducts);
    }

    @Test
    public void verifyProductsSortedLowToHigh() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.sortProducts("Price (low to high)");

        List<String> actualPrices = productPage.getProductPrices();
        List<Double> actualNumericPrices = new ArrayList<>();

        for (String price : actualPrices) {
            actualNumericPrices.add(
                    Double.parseDouble(price.replace("$", ""))
            );
        }

        List<Double> expectedPrices = new ArrayList<>(actualNumericPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals(actualNumericPrices, expectedPrices);
    }

    @Test
    public void verifyProductsSortedHighToLow() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.sortProducts("Price (high to low)");

        List<String> actualPrices = productPage.getProductPrices();
        List<Double> actualNumericPrices = new ArrayList<>();

        for (String price : actualPrices) {
            actualNumericPrices.add(
                    Double.parseDouble(price.replace("$", ""))
            );
        }

        List<Double> expectedPrices = new ArrayList<>(actualNumericPrices);
        Collections.sort(expectedPrices, Collections.reverseOrder());

        Assert.assertEquals(actualNumericPrices, expectedPrices);
    }

    @Test
    public void addSelectedProducts() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(
                productPage.getCartCount(),
                "1",
                "Cart count should be 1 after adding a product"
        );
    }

    @Test
    public void addSelectedDetailProducts() {
        ProductPage productPage = new ProductPage(DriverFactory.getDriver());
        productPage.selectProduct("Sauce Labs Backpack");
        productPage.addProductToCartFromDetails();
        Assert.assertEquals(
                productPage.getCartCount(),
                "1",
                "Cart count should be 1 after adding a product"
        );
    }
}
