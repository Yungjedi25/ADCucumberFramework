package stepDefinition;

import Utilities.TestContextSetup;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks
{
    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }
    @After
    public void AfterScenario()
    {
        testContextSetup.driver.quit();
    }
}
