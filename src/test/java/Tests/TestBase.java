package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void startdriver()
	{
		

		driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        
	        driver.get("https://www.google.com");
	}
	/*@AfterSuite
	public void stopdriver()
	{
		
		driver.quit();
	}
	*/
}
