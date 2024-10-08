package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Page Factoring
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryBox;
	
	@FindBy(css =".action__submit")
	WebElement actionBtn;
	
	@FindBy(xpath ="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountryName;
	
	By results = By.xpath("//section[contains(@class,'ta-results')]");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(countryBox, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountryName.click();
	}
	
	public ConfirmationPage goToConfirmationPage() {
		actionBtn.click();
		ConfirmationPage confirmPage =new ConfirmationPage(driver);
		return confirmPage;
	}
	
	
	
}
