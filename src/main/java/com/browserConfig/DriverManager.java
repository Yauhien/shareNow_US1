package com.browserConfig;

import com.enums.DriverType;
import cucumber.api.java.hu.De;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Log4j
@Component
@PropertySource("classpath:application.properties")
public class DriverManager {

    private WebDriver driver;

    @Value("${browser.type}")
    private DriverType driverType;

    public WebDriver getDriver() {
        if(driver == null){
            createDriver();
        }
        return driver;
    }

    @After
    public void closeDriver() {
        driver.quit();
        driver = null;
    }

    public void createDriver() {
        switch (driverType){
            case CHROME:
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
                driver = new SafariDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case OPERA:
                WebDriverManager.getInstance(DriverManagerType.OPERA);
                driver = new OperaDriver();
            default:
                log.error("no driver is found with type " + driverType);
        }
    }
}
