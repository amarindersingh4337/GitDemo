package rahulshettyacademy.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponent.BaseTests;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class StepDefinitionImpl extends BaseTests{

	public LandingPage landingPage;
	public ProductCatalogue prodcat;
	public ConfirmationPage confirmPage;
	public CartPage cartPage;
	
	@Given("I landed on the Ecommerce Page")
	public void I_Landed_on_Ecommerce_Page() throws IOException {
		//code
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$") // reg ex
	public void Logged_in_with_username_and_password(String username, String password) {
		
		prodcat = landingPage.loginApplication(username,password);
	}
	
	@When("^I add (.+) to cart$")
	public void I_add_to_cart(String productName) throws InterruptedException {
		prodcat.addProductToCart(productName);
	}
	 
	@When("^Checkout ().+ and submit the order$")
	public void Checkout_and_submit(String productName) {
		cartPage = prodcat.goToCartPage();
		Boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOut=cartPage.goTocheckOut();
		checkOut.selectCountry("India");
		confirmPage = checkOut.goToConfirmationPage();
		
	}
	
	@Then("{string} is displayed on confirmation page")
	public void confirmation_message(String string) {
		String confirmMessage = confirmPage.returnConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		driver.close();
	}
}
