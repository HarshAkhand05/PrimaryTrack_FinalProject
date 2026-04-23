package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void afterTest(Scenario scenario) {
        System.out.println("Scenario: " + scenario.getName());
    }
}
