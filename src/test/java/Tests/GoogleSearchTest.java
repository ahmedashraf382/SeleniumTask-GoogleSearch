package Tests;




import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import Pages.GoogleHomePage;


public class GoogleSearchTest extends TestBase {
	GoogleHomePage googlehomepageobj ;
	List<String> resultList = new ArrayList();
@Test	
public void testgooglesearch() throws InterruptedException, UnsupportedEncodingException {
	googlehomepageobj = new GoogleHomePage(driver);

	googlehomepageobj.enterkeyword("food");
	googlehomepageobj.enteranotherkeyword("drink");
	//Assert.assertTrue(googlehomepageobj.getSearchResults().contains("حوالى"));
	Assertions.assertThat((googlehomepageobj.getSearchResults().split("حوالى ")[1].split(" ")[0])).matches("\\d.*").isNotBlank().isNotNull();
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	googlehomepageobj.nextpage();
	
	 String searchResultsPage2 = googlehomepageobj.getSearchResults();
     googlehomepageobj.nextpage();
     String searchResultsPage3 = googlehomepageobj.getSearchResults();
     Assert.assertEquals(getPeProcessingResultSearch(searchResultsPage2), getPeProcessingResultSearch(searchResultsPage3));
	for(int i=0;i<googlehomepageobj.getSuggestionsResult().size();i++) {
		resultList.add(googlehomepageobj.getSuggestionsResult().get(i).getText());
		}
     
	boolean isRepeatedFlag = false;
	for(int i=0;i< resultList.size();i++) {
		String currentResult = resultList.get(i);
			for(int j = i+1; j < resultList.size();j++) {
				if (currentResult.equals(resultList.get(j))) {
					isRepeatedFlag = true;
					break;
				}
				
			}
	}
	
Assert.assertFalse(isRepeatedFlag);
	
}

public String getPeProcessingResultSearch(String result) {
	return result.split("حوالي ")[1].split(" ")[0];
}

}
