package testBase;

import java.time.Duration;
import org.testng.annotations.Parameters;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	public  WebDriver driver;
	public org.apache.logging.log4j.Logger logger;  //log4j 
	   
    @BeforeClass
    @Parameters({"os","browser"})
	public void setup(String os,String br) {
    logger =LogManager.getLogger(this.getClass());
    switch(br.toLowerCase()) {
    
    case "chrome" : driver = new ChromeDriver(); break;
    case "edge"    : driver = new EdgeDriver(); break;
    case "firefox" : driver = new FirefoxDriver(); break;
    default : System.out.println("Invalid browser name");return;
    
    }
   // driver= new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://demo.webocreation.com/");
    }
    
	
    @AfterClass
	public void tearDown() {
		driver.quit();
	}
  //For random String 
    public String randomeString() {
    	String genratedstring=RandomStringUtils.randomAlphabetic(5);
		return genratedstring;
    }
    
    //For random phone number 
    public String randomeNumber() {
    	String genratednumber=RandomStringUtils.randomNumeric(10);
		return genratednumber;
    	
    }

}
