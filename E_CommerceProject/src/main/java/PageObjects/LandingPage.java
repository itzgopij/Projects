package PageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E_commerce.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	By addToCart = By.xpath("//div[@class='product-action']/button");
	
	@FindBy(css=".product h4")
	List<WebElement> products;
	
	@FindBy(css="img[alt='Cart']")
	WebElement cart;
	
	@FindBy(xpath="//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement checkOut;
	
	@FindBy(xpath="//a[contains(text(),'Top Deals')]")
	WebElement topDeals;
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	public List<WebElement> Products() {
		return products;
	}
	
	public void selectProducts(String[] productNames) {
		List<String> productList = Arrays.asList(productNames);
		List<WebElement> products = Products();
		int j=0;
		for(int i=0;i<products.size();i++) {
			
			String name = products.get(i).getText().split("-")[0].trim();
		 if(productList.contains(name)) {
				driver.findElements(addToCart).get(i).click();
			j++;
			} 
			if(j==productNames.length)
			{
				break;
			}
		}
	}
	public CheckOutPage goToCheckOutPage() {
		cart.click();
		checkOut.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
	
	public TopDeals goToTopDealsPage() {
		topDeals.click();
		TopDeals topDeals = new TopDeals(driver);
		return topDeals;
	}

}
