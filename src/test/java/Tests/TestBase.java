package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void startdriver()
	{
		ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("prefs", 
		            new ImmutableMap.Builder<String, Object>()
		                .put("intl.accept_languages", "en-US,en")
		                .build());
		driver = new ChromeDriver(options);
		
		 driver.manage().window().maximize();
		 
		

	        
	        driver.get("https://www.google.com");
	}
	@AfterSuite
	public void stopdriver()
	{
		
		driver.quit();
	}
	
}
