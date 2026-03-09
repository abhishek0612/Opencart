package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']")
    WebElement register;
	
	public void clickMyAccount() {
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 myAccount.click();
	}
	
	public void clickRegister() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		register.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
