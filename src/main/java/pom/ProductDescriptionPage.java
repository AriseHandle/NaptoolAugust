package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage extends BasePage {

	
	@FindBy (xpath = "//a[@title='Buy online']")private WebElement buy;
	
	public ProductDescriptionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBuy() {
		buy.click();
	}
	
	
}
