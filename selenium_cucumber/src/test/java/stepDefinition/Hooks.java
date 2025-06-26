package stepDefinition;

import base.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        WebDriverFactory.browserSetUp();
        WebDriverFactory.openBrowserUrlAndStoreSession();
    }

    @After
    public void tearDown() {
        WebDriverFactory.closeBrowser();
    }
}
