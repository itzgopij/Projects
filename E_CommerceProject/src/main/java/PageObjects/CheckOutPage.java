package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import E_commerce.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
          WebDriver driver;
          
          public CheckOutPage(WebDriver driver) {
        	  super(driver);
        	  this.driver=driver;
        	  PageFactory.initElements(driver, this);
          }
          
          @FindBy(xpath="//tbody/tr/td[2]/p")
          List<WebElement> products;
          
          @FindBy(className="promoCode")
          WebElement promoCode;
          
          @FindBy(css=".promoBtn")
          WebElement applyPromo;
          
          @FindBy(css=".promoInfo")
          WebElement promoMsg;
          
          @FindBy(xpath="//button[contains(text(),'Place Order')]")
          WebElement placeOrder;
          
          @FindBy(xpath="//tr/td[5]/p")
          List <WebElement> prices;
          
          @FindBy(className="totAmt")
          WebElement total;
         
		public boolean verifyProducts(String[] selectedProducts) {
        	  List<String> wantedProducts = Arrays.asList(selectedProducts);
        	  List<String> displayedProducts = new ArrayList<String>()  ;
        	  for(int i=0;i<products.size();i++) {
        		  displayedProducts.add(products.get(i).getText().split("-")[0].trim());
        		  }
        	 // System.out.println(displayedProducts);
        	  if(displayedProducts.equals(wantedProducts)) {
        		  return true;
        	  }
        	  return false;
        	  }
			
		public void applyPromoCode(String code) {
			promoCode.sendKeys(code);
			applyPromo.click();
		}
		
		public WebElement promoMsg() {
			waitForWebElementToAppear(promoMsg);
			return promoMsg;
		}
		
		public CountrySelectionPage goToCountrySelectionPage() {
			placeOrder.click();
			CountrySelectionPage countrySelectionPage = new CountrySelectionPage(driver);
			return countrySelectionPage;
		}
		public boolean verifyTotal() {
			int sum=0;
			for(int i=0;i<prices.size();i++) {
				sum+= Integer.parseInt(prices.get(i).getText());
			}
			if(sum==Integer.parseInt(total.getText())) {
				return true;
			}
		return false;}
          }

