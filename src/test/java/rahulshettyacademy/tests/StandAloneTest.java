package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponent.BaseTests;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class StandAloneTest extends BaseTests{
	
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		
		ProductCatalogue prodcat = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		prodcat.addProductToCart(productName);
		CartPage cartPage = prodcat.goToCartPage();
		
		Boolean match = cartPage.verifyCartProducts(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOut=cartPage.goTocheckOut();
		checkOut.selectCountry("India");
		driver.close();
//		ConfirmationPage confirmPage = checkOut.goToConfirmationPage();
//		
//		String confirmMessage = confirmPage.returnConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
//		driver.close();
	}
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void orderHistoryTest() {
		
		//"ZARA COAT 3"
		ProductCatalogue prodcat = landingPage.loginApplication("amarinder.singh@gmail.com", "Amar1234");
		OrderPage orderPage = prodcat.goToOrderPage();
		orderPage.verifyOrderDisplay(productName);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "amarinder.singh@gmail.com");
		map.put("password", "Amar1234");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "amarinder.singh@gmail.com");
		map1.put("password", "Amar1234");
		map1.put("product", "ZARA COAT 3");
		//return map;
		
		List<HashMap<String,String>> data = getJsonDataToMap("D:\\eclipse-workspace\\SeleniumFrameWorkDesign\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(0)} };
	}
}
