package stepDefinition;

import Utilities.TestContextSetup;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.UUID;

public class CheckoutStepDefinition {
    TestContextSetup testContextSetup;

    CheckoutStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    SoftAssert a = new SoftAssert();
    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();
    String email = "jptest" + uuidAsString + "@gmail.com";
    String firstName = "Jubril";
    String lastName = "Pampam";
    String address = "24 Test Road";
    String city = "London";
    String postCode = "SE1 4NY";
    String phoneNumber = "02039485567";
    String orderComments = "E2X Assessment";

    @When("I complete the checkout process")
    public void i_complete_the_checkout_process() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(this.testContextSetup.driver, Duration.ofSeconds(5, 0));

//      Locating element by link text and store in variable "Element"
        WebElement Checkout = this.testContextSetup.driver.findElement(By.linkText("Check out"));

//      Scrolling down the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) this.testContextSetup.driver;
        js.executeScript("arguments[0].scrollIntoView();", Checkout);
        this.testContextSetup.driver.findElement(By.xpath("//a[@class='button button--primary']")).click();
        this.testContextSetup.driver.findElement(By.id("email")).sendKeys(email);

//      Traversed from parent to child to find and click checkbox element
        this.testContextSetup.driver.findElement(By.id("privacyPolicy"))
                .findElement(By.xpath(".."))
                .findElement(By.cssSelector("span")).click();

//      Verify Privacy policy radio button is selected or not
        a.assertTrue(this.testContextSetup.driver.findElement(By.id("privacyPolicy")).isSelected());
        this.testContextSetup.driver.findElement(By.id("checkout-customer-continue")).click();

//      Waiting for page to load with fields
        this.testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.testContextSetup.driver.findElement(By.id("firstNameInput")).sendKeys(firstName);
        this.testContextSetup.driver.findElement(By.id("lastNameInput")).sendKeys(lastName);
        this.testContextSetup.driver.findElement(By.id("addressLine1Input")).sendKeys(address);
        this.testContextSetup.driver.findElement(By.id("cityInput")).sendKeys(city);
        this.testContextSetup.driver.findElement(By.id("postCodeInput")).sendKeys(postCode);
        this.testContextSetup.driver.findElement(By.id("phoneInput")).sendKeys(phoneNumber);

//      Verify element is already selected by default
        a.assertTrue(this.testContextSetup.driver.findElement(By.id("sameAsBilling")).isSelected());
        this.testContextSetup.driver.findElement(By.name("orderComment")).sendKeys(orderComments);

//      Scroll to bottom of page to find Checkout button
        WebElement Continue = this.testContextSetup.driver.findElement(By.xpath("//button[@class='button button--primary optimizedCheckout-buttonPrimary']"));
        JavascriptExecutor js1 = (JavascriptExecutor) this.testContextSetup.driver;
        js1.executeScript("arguments[0].scrollIntoView();", Continue);

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout-shipping-continue")));
        btn.click();

//      Verify element is already selected by default
        a.assertTrue(this.testContextSetup.driver.findElement(By.id("radio-testgateway")).isSelected());

        this.testContextSetup.driver.findElement(By.id("ccNumber")).sendKeys("4111 1111 1111 1111");
        this.testContextSetup.driver.findElement(By.xpath("//input[@name='ccExpiry']")).sendKeys("0923");
        this.testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.testContextSetup.driver.findElement(By.xpath("//input[@name='ccName']")).sendKeys("E2X Test ApplyDigital");
        this.testContextSetup.driver.findElement(By.id("ccCvv")).sendKeys("123");
//      driver.findElement(By.id("ccCvv")).sendKeys(Keys.TAB);

//      Scroll to bottom of page to find Place Order button
        WebElement placeOrder = this.testContextSetup.driver.findElement(By.id("checkout-payment-continue"));
        JavascriptExecutor js2 = (JavascriptExecutor) this.testContextSetup.driver;
        js2.executeScript("arguments[0].scrollIntoView();", placeOrder);

//      Waiting for button to be located
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-payment-continue")));

        this.testContextSetup.driver.findElement(By.xpath("//html")).click();
        JavascriptExecutor js3 = (JavascriptExecutor) this.testContextSetup.driver;
        js3.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("waiting.........");

//      For some reason, implicit and explicit wait not working
//      TODO: check why sleep is needed
        Thread.sleep(2000);
        this.testContextSetup.driver.findElement(By.id("checkout-payment-continue")).click();

        a.assertAll();
    }

}
