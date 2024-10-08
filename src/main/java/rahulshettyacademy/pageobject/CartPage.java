package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[@type='button' and text()='Checkout']")
	WebElement checkoutBtn;
	
	public Boolean verifyCartProducts(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equals(productName));
		return match;
	}
	
	public CheckOutPage goTocheckOut() {
		checkoutBtn.click();
		return new CheckOutPage(driver);
	}
	
	

}
