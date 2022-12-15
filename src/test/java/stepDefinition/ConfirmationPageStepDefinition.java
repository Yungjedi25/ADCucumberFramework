package stepDefinition;

import Utilities.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.AddProductPage;
import pageObjects.ConfirmationPage;

public class ConfirmationPageStepDefinition
{
    TestContextSetup testContextSetup;

    ConfirmationPageStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
    }

    @Then("I am presented with a purchase confirmation page for my order")
    public void i_am_presented_with_a_purchase_confirmation_page_for_my_order()
    {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        AddProductPage addProduct = new AddProductPage(testContextSetup.driver);
        addProduct.searchItem();

        ConfirmationPage confirmationPage = new ConfirmationPage(testContextSetup.driver);
        confirmationPage.orderStatus();
        //System.out.println(this.testContextSetup.driver.findElement(By.xpath("//p[@data-test='order-confirmation-order-status-text']")).getText());

    }
}
