package Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class GoogleHomePage extends PageBase {
	

	public GoogleHomePage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	 @FindBy(id="APjFqb")
	
	        WebElement searchBox;
	 @FindBy(className  = "gNO89b")
	     WebElement searchbtn;
	 
	 @FindBy(id="result-stats")
	 WebElement getresult;
	 @FindAll({
	 @FindBy(linkText = "التالية"),
	 @FindBy(linkText = "Next")})
	 WebElement nextpage;
	 @FindBy(className = "y6Uyqe")
	 WebElement suggestionsContainer;
	 
	 public void enterkeyword(String keyword) throws InterruptedException
	 {
		 SetText(searchBox, keyword);
		// Wait for the search button to be clickable
		 Thread.sleep(2000);
		 ClickEnter(searchbtn);
		 ClearButton(searchBox);
		 
		
	 }
	 public void enteranotherkeyword(String newkeyword) throws InterruptedException
	 {
		 SetText(searchBox, newkeyword);
		// Wait for the search button to be clickable
		 Thread.sleep(3000);
		 ClickEnter(searchBox);
		 
	 }
	 public void nextpage () {
	        
	        ClickButton(nextpage);
	    }
	 
	 public String getSearchResults() {
	        
	        return getresult.getText();
	    }

	 public List<WebElement> getSuggestionsResult() {
		 return suggestionsContainer.findElements(By.tagName("b"));
		 
	 }
}
