package com.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

import com.enums.ApplicationPages;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LandingPage extends Page {

    private static String cookieBanner = "#uc-central-banner-modal #uc-banner-centered";

    public void acceptCookiesBanner() {
        waitForPageToLoad();
        if ($(cookieBanner).isDisplayed()) {
            $(cookieBanner).$("#uc-btn-accept-banner").click();
            $(cookieBanner).should(disappear);
        }
    }

    public void clickChooseCountry() {
        $("#link-country-selector-page").click();
    }

    public void checkCountryListDisplayed() {
        assertThat(url()).contains(ApplicationPages.COUNTRY_LIST.getField());
    }

    public void selectLocation(String name) {
        $(By.xpath(String.format("//*[contains(text(),'%s')]", name)))
                .shouldBe(visible)
                .click();
    }

    public void clickRegisterButton() {
        $(".hero-section #button-register-now")
                .shouldBe(visible)
                .click();
        waitForElementToBeVisible($(" .personal-data #registration-step-1"));
    }
}
