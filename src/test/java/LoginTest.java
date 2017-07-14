import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
	
	ChromeDriver webDriver;
	
	@BeforeClass
	public void setUp(){
		webDriver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}
	
	@Test	
	public void testLoginFunctionality(){
		webDriver.get("https://www.facebook.com/");
		Assert.assertEquals("Facebook - Log In or Sign Up", webDriver.getTitle(), "FAILED TO LOAD LOGIN PAGE");

		webDriver.findElement(By.id("username")).sendKeys("username");
		webDriver.findElement(By.name("password")).sendKeys("password");
		webDriver.findElement(By.xpath("//div[@id='loginForm]/input[@name=submitButton]")).click();

		webDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		Assert.assertEquals("Facebook - Welcome Page", webDriver.getTitle(), "FAILED TO LOAD WELCOME PAGE");
	}
	
	@AfterClass
	public void tearDown(){
		webDriver.quit();
	}

}
