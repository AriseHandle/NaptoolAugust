package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	@FindBy (xpath = "//ul[@id='cartData']") private List<WebElement> products;
	@FindBy (xpath = "(//a[@onclick='cart.submitOrder()'])[1]") private WebElement proceedToCheckout;
	@FindBy (xpath = "(//a[@onclick='cart.continueShopping()'])[1]")private WebElement continueShopping;
	@FindBy (xpath = "//div[@id='cartItems']//h2//a")private List<WebElement> productName;
	@FindBy (xpath = "//li[@class='head_UPrice']")private List<WebElement> unitPrice;
	@FindBy (xpath = "//li[@class='head_ship']")private List<WebElement> shippingPrice;
	@FindBy (xpath = "//li[@class='head_Amount']")private List<WebElement> orderAmount;
	@FindBy (xpath = "//ul[@id='cartTotal']//label") private WebElement cartAmount;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfProdutsPresentInCart(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return products.size();
	}
	
	public void clickOnContinueShopping(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(continueShopping));
		continueShopping.click();
	}
	
	public String getProductName(int index, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		return productName.get(index).getText();
	}
	
	public double getUnitPrice(int index) {
		return Double.parseDouble(unitPrice.get(index).getText().substring(3));
	}
	
	public double getShippingPrice(int index) {
		return Double.parseDouble(shippingPrice.get(index).getText().substring(3));
	}
	
	public double getOrderAmount(int index) {
		return Double.parseDouble(orderAmount.get(index).getText().substring(3));
	}
	
	public double getCartAmount(int index) {
		return Double.parseDouble(cartAmount.getText().substring(3));
	}
	
}
