package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test
	public void verify_account_registration() {
		logger.info("*****Starting TC001_AccountRegistrationTest*****" );
		try{driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
	    
		hp.clickRegister();
		logger.info("Clicked on Register Link");

		RegistrationPage regpage= new RegistrationPage(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		regpage.pagetitle();
		
		logger.info("Providing customer details");
		regpage.enterFirstname(randomeString().toUpperCase());
		regpage.enterLastName(randomeString());
		regpage.inputEmail(randomeString()+"@yopmail.com");
		regpage.enterPassword("Test@123");
		regpage.scrollDown();
		regpage.checkPrivaypolicy();
		regpage.continueButton();
		
		logger.info("Validating expected message");
		regpage.confirmMessage();
		Assert.assertEquals(regpage.confirmMessage(), "Your Account Has Been Created!");
	}
	catch(Exception e){
		
		logger.error("Test Failed");
		logger.debug("Debug logs....");
		Assert.fail();
	}
  
		logger.info("*****Finished TC001_AccountRegistrationTest*****");

}}
