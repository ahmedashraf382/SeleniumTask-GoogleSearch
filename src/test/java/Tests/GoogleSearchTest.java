package Tests;




import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;

import org.testng.Assert;
import Pages.GoogleHomePage;


public class GoogleSearchTest extends TestBase {
	GoogleHomePage googlehomepageobj ;
	List<String> resultList ;
	boolean isArabicLanguage = false ;
@Test	
public void testgooglesearch() throws InterruptedException, UnsupportedEncodingException {
	googlehomepageobj = new GoogleHomePage(driver);
	if(googlehomepageobj.isGoogleArabicLanguage(driver)) {
		isArabicLanguage = true;
	}
	
	googlehomepageobj.enterkeyword("food");
	googlehomepageobj.enteranotherkeyword("drink");
	
	if(isArabicLanguage == true) {
	Assertions.assertThat((googlehomepageobj.getSearchResults().split("حوالى ")[1].split(" ")[0])).matches("\\d.*").isNotBlank().isNotNull();
	}
	else {
		Assertions.assertThat((googlehomepageobj.getSearchResults().split("About ")[1].split(" ")[0])).matches("\\d.*").isNotBlank().isNotNull();

	}
	googlehomepageobj.scrollDown(driver);
	
	googlehomepageobj.nextpage();
	
	 String searchResultsPage2 = googlehomepageobj.getSearchResults();
     googlehomepageobj.nextpage();
     String searchResultsPage3 = googlehomepageobj.getSearchResults();
     Assert.assertEquals(googlehomepageobj.getPeProcessingResultSearch(searchResultsPage2,isArabicLanguage),
    		 googlehomepageobj.getPeProcessingResultSearch(searchResultsPage3,isArabicLanguage));
	for(int i=0;i<googlehomepageobj.getSuggestionsResult().size();i++) {
		resultList = new ArrayList<>();
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


	
}


