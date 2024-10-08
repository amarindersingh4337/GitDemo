import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterviewRound3 {

	
	
	@Test(priority = 4)
public void testNo1() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	WebElement searchBox = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search Amazon.in']"));
	Actions action = new Actions(driver);
	action.moveToElement(searchBox).click().keyUp(Keys.SHIFT).sendKeys("books").build().perform();
	
	Thread.sleep(5000L);
	
}
	
//	@Test(priority = 2)
//public void testNo2() {
//	System.out.println("test2");
//}
//	
//	@Test(priority = 3)
//public void testNo3() {
//	System.out.println("test3");
//}
//	
//	@Test(priority = 1)
//public void testNo4() {
//	System.out.println("test4");
//}
}
