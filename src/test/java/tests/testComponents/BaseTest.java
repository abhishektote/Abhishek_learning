package tests.testComponents;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;

    public void initializeWebDriver(String url) throws IOException{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/config.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }
            driver.manage().window().setSize(new Dimension(1440, 900));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
        } catch (Exception e) {
            throw new RuntimeException("WebDriver initialization failed", e);
        }
        driver.get(url);
    }

    @Parameters("url")
    @BeforeClass
    public void LaunchApplication(String url) throws IOException {
        initializeWebDriver(url);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
