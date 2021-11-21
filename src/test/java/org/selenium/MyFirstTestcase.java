package org.selenium;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestcase extends BaseTest {

    @Test
     public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
     //   BillingAddress billingAddress=new BillingAddress("test","user","San Francisco","San Francisco","94188","task@gmail.com");


        BillingAddress billingAddress=new BillingAddress().setFirstName("test").
                setLastName("user").
                setAddressLineOne("San Francisco").
                setCity("San Francisco").
                setPostalCode("94188").setEmail("task@gmail.com");

        StorePage storePage=new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search("Blue");
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage= storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");

        CheckoutPage checkoutPage= cartPage.
                checkout().
                setBillingAddress(billingAddress).
                placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }


    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        StorePage storePage=new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                search("Blue");
        Assert.assertEquals(storePage.getTitle(),"Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage= storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        CheckoutPage checkoutPage= cartPage.checkout();

        checkoutPage.clickHereForLogin();
        Thread.sleep(5000);
        checkoutPage.login("testuser","test@123").
                enterFirstName("test").
                enterLastName("user").
                enterAddressLineOneFld("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("task@gmail.com").
                placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(),"Thank you. Your order has been received.");
    }


}
