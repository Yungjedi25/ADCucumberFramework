package stepDefinition;

import Utilities.TestContextSetup;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddProductPage;

import java.time.Duration;
import java.util.List;


public class AddProductStepDefinition {
    TestContextSetup testContextSetup;

    AddProductStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("I have a product in my cart")
    public void i_have_a_product_in_my_cart() {
        // System.setProperty("webdriver.chrome.driver", "/Users/jubrilpampam/Downloads/chromedriver");
        // testContextSetup.driver = new ChromeDriver();
        // testContextSetup.driver.manage().window().maximize();
        // testContextSetup.driver.get("https://cornerstone-light-demo.mybigcommerce.com/");

        AddProductPage addProduct = new AddProductPage(testContextSetup.driver);
        addProduct.searchItem();
        //testContextSetup.driver.findElement(By.xpath("//button[@id='quick-search-expand']")).click();

        addProduct.getSearchItem();
        //testContextSetup.driver.findElement(By.id("nav-quick-search")).sendKeys("set");

//      Wait for page to load after searching
        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//      Find a list of products within certain section of page and iterate through each one to find correct product to select
        List<WebElement> products = testContextSetup.driver.findElements(By.xpath("//ul[@class='productGrid']"));

        WebElement prod = products.stream().filter(product ->
                        product.findElement(By.cssSelector("h3")).getText()
                                .trim().equals("Ceramic Measuring Spoon Set"))
                .findFirst().orElse(null);

//        Possible failure point if product is not found
        if (prod == null) {
            System.out.println("Product not found");
            return;
        }

        //Add product to cart
        addProduct.addItem();
        //prod.findElement(By.xpath("//a[@data-button-type='add-cart']")).click();
    }

}
