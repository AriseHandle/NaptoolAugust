package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.NaptoolHomePage;
import pom.ProductResultPage;

public class ProductSearchTest extends BaseTest{

	@BeforeMethod
	public void openApplication() {
		driver = LaunchBrowser.chrome();
	}
	
	@Test
	public void verifyIfProdutsAreDisplayedOnValidSearch() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfProducts()>0);
		
	}
	
	@Test
	public void verifyIfProdutsAreNotDisplayedOnInvalidSearch() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("iphone");
		naptoolHomePage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfProducts()==0);
		
	}
	
}
