package base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.logging.LogType.BROWSER;
import static util.ProjectConstants.*;

@Slf4j
public class WebDriverFactory {
    private WebDriverFactory() {}

    public static WebDriver driver;
    public static WebDriverWait wait;

    private static void getDriver(String browser) {
        if (driver == null) {
            createDriver(browser);
            driver.manage().window().maximize();
        }
    }

    private static void createDriver(String browser) {
        if (browser.equalsIgnoreCase(BROWSER_CHROME)) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase(BROWSER_FIREFOX)) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException(LOG_UNSUPPORTED_BROWSER + browser);
        }
    }

    public static void browserSetUp() {
        getDriver(ConfigReader.getProperty(BROWSER));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty(IMPLICIT_WAIT_IN_SEC))));
        synchronize(Duration.ofSeconds(8));
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void synchronize(Duration timeout) {
        if (null != driver) {
            wait = new WebDriverWait(driver, timeout);
        }
    }

    public static void openBrowserUrlAndStoreSession() {
        driver.get(ConfigReader.getProperty(BASE_URL));
    }
}
