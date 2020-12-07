package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.enums.ApplicationPages;
import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class RegistrationPersonalDataPage extends Page {

    Random random = new Random();
    Faker deFaker = new Faker(new Locale("de-GB"));

    private static String inputField = "input[name='%s']";
    private static String dropDown = "select[name='%s']";

    public RegistrationPersonalDataPage() {
        urlPath = ApplicationPages.REGISTRATION_PERSONAL_DATA.getField();
    }

    public void enterEmail() {
        String randomEmail = deFaker.internet().safeEmailAddress();
        $(String.format(inputField, "email")).sendKeys(randomEmail);
        checkValueInField("Email address", randomEmail);
    }

    public void enterPassword() {
        String password = deFaker.internet().password(5, 25);
        $(String.format(inputField, "password")).sendKeys(password);
        checkValueInField("Password", password);
    }

    public void enterMagicPin() {
        String pin = String.valueOf(deFaker.random().nextInt(1000, 9999));
        $(String.format(inputField, "pin")).sendKeys(pin);
        checkValueInField("Magic PIN", pin);
    }

    public String getRandomNumberUsingInts(int min, int max) {
        return String.valueOf(random.ints(min, max)
                .findFirst()
                .getAsInt());
    }

    private void checkValueInField(String field, String expectedValue) {
        $(String.format("[label='%s']", field)).shouldHave(value(expectedValue));
    }

    public void selectTitle(String salutation) {
        SelenideElement salutationDropdown = $(String.format(dropDown, "salutation"));
        SelenideElement optionToSelect = salutationDropdown.$(String.format("option:not(:first-child)[value=%s]", salutation));
        salutationDropdown.scrollTo().click();
        optionToSelect.shouldBe(visible).click();
    }

    public void enterFirstName() {
        String firstName = deFaker.address().firstName();
        $(String.format(inputField, "firstName")).sendKeys(firstName);
        checkValueInField("First name on driver\\'s licence", firstName);
    }

    public void enterLastName() {
        String lastName = deFaker.address().lastName();
        $(String.format(inputField, "lastName")).sendKeys(lastName);
        checkValueInField("Last name on driver\\'s licence", lastName);
    }

    public void selectDateOfBirth() {
        selectDateOfBirthDropdown("Day", 1, 28);
        selectDateOfBirthDropdown("Month", 1, 12);
        selectDateOfBirthDropdown("Year", 1931, 2002);
    }

    private void selectDateOfBirthDropdown(String dropDownName, int optionNumberFrom, int optionNumberTo) {
        ElementsCollection dateOfBirthDropDowns = $$(String.format(dropDown, "birthDate"));
        for(SelenideElement dropdown : dateOfBirthDropDowns){
            if(dropdown.$("option").getText().contains(dropDownName)){
                dropdown.scrollTo().click();
                String randomOption = String.valueOf(deFaker.random().nextInt(optionNumberFrom, optionNumberTo));
                SelenideElement optionToSelect = dropdown.$(String.format("option:not(:first-child)[value='%s']", randomOption));
                optionToSelect.scrollTo().shouldBe(visible).click();
            }
        }
    }

    public void enterPlaceOfBirth() {
        String birthPlace = deFaker.address().country();
        $(String.format(inputField, "birthPlace")).sendKeys(birthPlace);
        checkValueInField("Place of birth", birthPlace);
    }

    public void enterStreetAndNumber() {
        String street = deFaker.address().streetAddressNumber();
        $(String.format(inputField, "addressStreet")).sendKeys(street);
        checkValueInField("Street and no.", street);
    }

    public void enterPostalCode() {
        String postalCode = deFaker.address().zipCode();
        $(String.format(inputField, "addressZipCode")).sendKeys(postalCode);
        checkValueInField("ZIP/postal code", postalCode);
    }

    public void enterTown() {
        String town = deFaker.address().city();
        $(String.format(inputField, "addressCity")).sendKeys(town);
        checkValueInField("Town", town);
    }

    public void enterMobilePhoneNumber() {
        String phone = deFaker.phoneNumber().subscriberNumber(11);
        $(String.format(inputField, "mobilePhone")).sendKeys(phone);
    }

    public void acceptTermsAndConditions() {
        WebElement checkbox = $(".checkbox input[id*='checkbox']").toWebElement();
        JavascriptExecutor ex = (JavascriptExecutor)getWebDriver();
        ex.executeScript("arguments[0].click();", checkbox);
    }

    public void savePersonalData() {
        $("#registration-save-button").scrollTo().click();
    }

    public void savePersonalDataAndProceed() {
        $("#registration-save-button").scrollTo().click();
        waitForElementToBeVisible($(".registration-payment__header .registration-payment__title"));
    }

    public void checkErrorForRequiredFields(int numberOfRequiredFields){
        assertThat($$("div .error_hint").size()).isEqualTo(numberOfRequiredFields);
    }
}
