package stepdefinitions;

import com.browserConfig.BeanConfig;
import com.pages.LandingPage;
import cucumber.api.java.en.Given;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@Log4j
@ContextConfiguration(classes = {BeanConfig.class})
public class LandingPageStepDefinitions extends Step{

    @Autowired
    LandingPage landingPage;

    @Given("user goes to register from landing page")
    public void userGoesToRegisterFromLandingPage() {
        log.info("[Step] user goes to register from landing page");
        browser.openUrl(url);
        landingPage.acceptCookiesBanner();
        landingPage.clickChooseCountry();
        landingPage.checkCountryListDisplayed();
        landingPage.selectLocation("Germany");
        landingPage.clickRegisterButton();
    }
}
