package stepdefinitions;

import com.browserConfig.Browser;
import com.browserConfig.TestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Step {
    @Value("${application.url}")
    protected String url;
    @Autowired
    protected Browser browser;
    @Autowired
    protected TestContext testContext;
}
