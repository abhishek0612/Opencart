import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class colorOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		WebElement  logincolor=driver.findElement(By.id("login"));
		String rgbaColor = logincolor.getCssValue("background-color");

		System.out.println("RGBA: " + rgbaColor);

		String hexColor = Color.fromString(rgbaColor).asHex();

		System.out.println("HEX: " + hexColor);
	}

}
