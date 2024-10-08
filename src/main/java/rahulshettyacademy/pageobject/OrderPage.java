package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> orderProducts;
	
	@FindBy(xpath="//button[@type='button' and text()='Checkout']")
	WebElement checkoutBtn;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = orderProducts.stream().anyMatch(product -> product.getText().equals(productName));
		return match;
	}
	
}
