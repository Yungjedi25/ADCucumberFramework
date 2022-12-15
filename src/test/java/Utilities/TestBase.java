package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public WebDriver driver;
    TestContextSetup testContextSetup;
    public WebDriver WebdriverManager()
    {
        if (driver==null)
        {
            System.setProperty("webdriver.chrome.driver", "/Users/jubrilpampam/Downloads/chromedriver");
            testContextSetup.driver = new ChromeDriver();
            testContextSetup.driver.manage().window().maximize();
            testContextSetup.driver.get("https://cornerstone-light-demo.mybigcommerce.com/");
        }

        return driver;
    }
}
