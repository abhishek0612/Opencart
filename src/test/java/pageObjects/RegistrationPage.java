package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{
	//WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[text()='Register Account']")
	WebElement pageTitle;
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(xpath="//label[@class='form-check-label']")
	WebElement scrolld;
	
	@FindBy(xpath="//input[@class='form-check-input']")
	WebElement privacyPolicy;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confirmMessage;
	
	public void pagetitle() {
		System.out.println(pageTitle.getText());
	}
	
	public void enterFirstname(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void inputEmail(String Eemail) {
		email.sendKeys(Eemail);
	}
	
	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrolld);
	}
	
	public void checkPrivaypolicy() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy));
		//privacyPolicy.click();
	}
	
	public void continueButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		continueButton.click();
		
	}
	public String confirmMessage() {
		//confirmMessage.getText();
		try {
			return (confirmMessage.getText());
		}
		catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
	

	
	
	

}
