package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
    public WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderStatus = By.xpath("//p[@data-test='order-confirmation-order-status-text']");

    public void orderStatus()
    {
        System.out.println(driver.findElement(orderStatus).getText());
    }

}
