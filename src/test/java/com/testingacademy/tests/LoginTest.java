package com.testingacademy.tests;

import com.testingacademy.base.BaseTest;
import com.testingacademy.factory.DriverFactory;
import com.testingacademy.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"),"User should be redirected to inventory page after login");
    }
}