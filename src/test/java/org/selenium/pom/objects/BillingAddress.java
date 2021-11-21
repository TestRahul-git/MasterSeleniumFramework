package org.selenium.pom.objects;

public class BillingAddress {
    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String city;
    private String postalCode;
    private String email;

   public BillingAddress()
   {

   }
    public BillingAddress(String firstName, String lastName, String addressLineOne, String city, String postalCode, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.addressLineOne=addressLineOne;
        this.city=city;
        this.postalCode=postalCode;
        this.email=email;
    }

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        return this;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public BillingAddress setAddressLineOne(String addressLineOne) {
        return this;
    }

    public String getCity() {
        return city;
    }

    public BillingAddress setCity(String city) {
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public BillingAddress setPostalCode(String postalCode) {
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        return this;
    }


}
