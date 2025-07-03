package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/cucumber",
        glue = "stepDefinition",
        plugin = {"html:target/cucumber-reports.html"},
        monochrome = true
)
@Test
public class TestNGRunner extends AbstractTestNGCucumberTests {}
