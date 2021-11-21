package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {
    private final By firstNameFld=By.id("billing_first_name");
    private final By lastNameFld=By.id("billing_last_name");
    private final By addressLineOneFld=By.id("billing_address_1");
    private final By billingCityFld=By.id("billing_city");
    private final By billingPostCodeFld=By.id("billing_postcode");
    private final By billingEmailFld=By.id("billing_email");
    private final By placeOrderBtn=By.id("place_order");
    private final By successNotice= By.cssSelector(".woocommerce-notice");
    private final By loginLink= By.className("showlogin");
    private final By usernameFld=By.id("username");
    private final By passwordFld=By.id("password");
    private final By loginBtn=By.name("login");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName){
        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOneFld (String addressLineOne){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterCity(String city){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
    return this;
    }


    public CheckoutPage enterPostCode(String postCode){
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLineOneFld(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());
    }

    public CheckoutPage enterEmail(String email){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
       return driver.findElement(successNotice).getText();

    }
    public CheckoutPage clickHereForLogin(){
        driver.findElement(loginLink).click();
        return this;
    }

    public CheckoutPage login(String username, String password){
        driver.findElement(usernameFld).sendKeys(username);
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginBtn).click();
        return this;
    }

}
