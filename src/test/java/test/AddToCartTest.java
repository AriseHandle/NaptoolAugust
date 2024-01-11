package test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.ProductDescriptionPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;

public class AddToCartTest extends BaseTest {
	
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;
	ProductResultPage productResultPage;
	ProductDescriptionPage productDescriptionPage;
	
	//@Parameters ({"browser"})
	@BeforeMethod
	public void openApplication() {
		driver = LaunchBrowser.browser("Chrome");
	}
	
	@Test
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnClickHereToBuy();
		
		CartPage cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver), 1);
		
	}
	
	@Test
	public void verifyIfUserIsAbleToAddMultipleProductToCart() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage =new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnClickHereToBuy();
		
		cartPage =new CartPage(driver);
		cartPage.clickOnContinueShopping(driver);
		
	    productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		productQuickViewPage =new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnClickHereToBuy();
		
		cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver), 2);
		
	}
	
	@Test
	public void verifyIfUserIsAbleToAddProductToCartFromProductDescriptionPage() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		productResultPage =new ProductResultPage(driver);
		String productTitle =productResultPage.getProductTitle(0);
		productResultPage.clickOnProduct(0);
		productResultPage.switchToPage(driver, productTitle);
		
		productDescriptionPage= new ProductDescriptionPage(driver);
		productDescriptionPage.clickOnBuy();	
	}
	
	@Test
	public void VerifyIfProductDetailsOnShoppingCartAreSimilarToProductAddedFromQuickViewTab() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage =new ProductQuickViewPage(driver);
		String expectedProductName=productQuickViewPage.getProductName();
		double expectedPrice =productQuickViewPage.getProductPrice();
		double expectedShipping =productQuickViewPage.getShippingCharges();
		productQuickViewPage.clickOnClickHereToBuy();
		
		cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getProductName(0, driver),expectedProductName);
		Assert.assertEquals(cartPage.getUnitPrice(1), expectedPrice);
		Assert.assertEquals(cartPage.getShippingPrice(1),expectedShipping);
		
		
		

	}

	
	@AfterMethod
	public void close() {
		//driver.close();
	}
}
