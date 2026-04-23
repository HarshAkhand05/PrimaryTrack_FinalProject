package runners;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(listeners.TestListener.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {
          "pretty",
          "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
