package com.browserConfig;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class Browser {

    @Autowired
    private DriverManager driverManager;

    public void openUrl(String url) {
        windowMaximize();
        driverManager.getDriver().navigate().to(url);
        setWebDriver(driverManager.getDriver());
        open(url);
    }

    public void windowMaximize() {
        driverManager.getDriver().manage().window().maximize();
    }

    public void back() {
        log.info("[Browser] Go one page back.");
        driverManager.getDriver().navigate().back();
    }
}
