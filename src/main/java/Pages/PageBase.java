package Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
public PageBase(WebDriver driver ) {
	
	PageFactory.initElements(driver, this);
}
protected static void ClickEnter(WebElement ClickEnter) {
	
	ClickEnter.sendKeys(Keys.ENTER);
}

protected static void ClearButton(WebElement ClearButton) {
	
	ClearButton.clear();
}
protected static void SetText(WebElement TextElement, String Value) {
	
	TextElement.sendKeys(Value);
}

protected static void ClickButton(WebElement Clickbutton) {
	
	Clickbutton.click();
}

}
