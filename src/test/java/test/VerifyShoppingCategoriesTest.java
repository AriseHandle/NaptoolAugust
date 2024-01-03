package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.NaptoolHomePage;

@Listeners (test.Listeners.class)

public class VerifyShoppingCategoriesTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		driver = LaunchBrowser.chrome();
	}
	
	@Test
	public void verifyIfUserIsAbleToAccessShoppingCategories() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.clickOnShoppingCategories();
		naptoolHomePage.selectShoppingCategories(driver, 3);
		String currentTitle =driver.getTitle();
		Assert.assertTrue(currentTitle.contains("Mobile Handsets"));
		Assert.assertEquals(naptoolHomePage.getCategoryHeading(), "Mobiles : Mobile Handsets");	
	}
	
	@AfterMethod
	public void postTest() {
		driver.close();
	}
	
}
