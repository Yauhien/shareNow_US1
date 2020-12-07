package com.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

import com.browserConfig.Browser;
import java.time.Duration;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Page {

    @Autowired
    Browser browser;

    protected String urlPath;

    public void verifyPageUrl(){
        waitForPageToLoad();
        assertThat(url()).contains(urlPath);
    }

    public void waitForPageToLoad(){
        Wait fluentWait = new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(4));
        fluentWait.until(ExpectedConditions.visibilityOf($("#__layout")));
    }

    public void waitForElementToBeVisible(SelenideElement element){
        Wait fluentWait = new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(4));
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }
}
