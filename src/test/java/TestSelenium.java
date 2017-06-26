import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 */

/**
 * @author urmilasrikanth
 *
 */
public class TestSelenium {
	
	ChromeDriver webDriver;
	
	@BeforeClass
	public void setUp(){
		webDriver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}
	
	@Test	
	public void testBrowser(){
		webDriver.get("https://www.facebook.com/");
		Assert.assertEquals("Facebook - Log In or Sign Up", webDriver.getTitle(), "FAILED TO LOGIN");
	}
	
	@AfterClass
	public void tearDown(){
		webDriver.quit();
	}

}
