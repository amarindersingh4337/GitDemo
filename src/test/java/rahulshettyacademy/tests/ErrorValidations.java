package rahulshettyacademy.tests;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponent.BaseTests;
import rahulshettyacademy.TestComponent.Retry;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.ProductCatalogue;


@Test
public class ErrorValidations extends BaseTests {
	
	@Test(groups="ErrorHandling",retryAnalyzer=Retry.class)
	public void errorValidation() {
		landingPage.loginApplication("amarinder.singh@gmail.com", "Amar12345");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue prodcat = landingPage.loginApplication("amarinder.singh@gmail.com", "Amar1234");
		
		prodcat.addProductToCart(productName);
		CartPage cartPage = prodcat.goToCartPage();
		
		Boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);
	}
	

}
