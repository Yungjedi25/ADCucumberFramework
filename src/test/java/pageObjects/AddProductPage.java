package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProductPage
{
    public WebDriver driver;
    public AddProductPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private By quickSearch1 = By.xpath("//button[@id='quick-search-expand']");
    private By quickSearch2 = By.id("nav-quick-search");
    private By addCart = By.xpath("//a[@data-button-type='add-cart']");

    public void searchItem()
    {
        driver.findElement(quickSearch1).click();
    }

    public void getSearchItem()
    {
        driver.findElement(quickSearch2).sendKeys("set");
    }

    public void addItem()
    {
        driver.findElement(addCart).click();
    }
}

