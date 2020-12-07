package stepdefinitions;

import com.pages.RegistrationPaymentPage;
import com.pages.RegistrationPersonalDataPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationStepsDefinitions extends Step {

    @Autowired
    RegistrationPersonalDataPage registrationPersonalDataPage;
    @Autowired
    RegistrationPaymentPage registrationPaymentPage;

    @And("user is on registration personal data page")
    public void checkUserIsOnRegistrationPersonalDataPage() {
        registrationPersonalDataPage.verifyPageUrl();
    }

    @When("user provides email, password and pin")
    public void provideEmailPasswordAndPin() {
        registrationPersonalDataPage.enterEmail();
        registrationPersonalDataPage.enterPassword();
        registrationPersonalDataPage.enterMagicPin();
    }

    @And("user provides personal details information")
    public void providePersonalDetailsInformation() {
        registrationPersonalDataPage.selectTitle("HERR");
        registrationPersonalDataPage.enterFirstName();
        registrationPersonalDataPage.enterLastName();
        registrationPersonalDataPage.selectDateOfBirth();
        registrationPersonalDataPage.enterPlaceOfBirth();
        registrationPersonalDataPage.enterStreetAndNumber();
        registrationPersonalDataPage.enterPostalCode();
        registrationPersonalDataPage.enterTown();
        registrationPersonalDataPage.enterMobilePhoneNumber();
    }

    @And("user accepts Terms & conditions")
    public void acceptTermsConditions() {
        registrationPersonalDataPage.acceptTermsAndConditions();
    }

    @And("user saves personal data and proceed to next page")
    public void savePersonalDataAndProceed() {
        registrationPersonalDataPage.savePersonalDataAndProceed();
    }

    @And("user saves personal data")
    public void savePersonalData() {
        registrationPersonalDataPage.savePersonalData();
    }

    @And("{int} empty required fields are highlighted")
    public void checkEmptyRequiredFieldsHighlighted(int numberOfFields) {
        registrationPersonalDataPage.checkErrorForRequiredFields(numberOfFields);
    }

    @Then("user is on registration payment page")
    public void checkUserIsOnRegistrationPaymentPage() {
        registrationPaymentPage.verifyPageUrl();
    }
}
