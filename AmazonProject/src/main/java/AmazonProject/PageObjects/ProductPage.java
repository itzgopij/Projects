package AmazonProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonProject.AbstractComponents.AbstractComponents;

public class ProductPage extends AbstractComponents{
	WebDriver driver;
  public ProductPage(WebDriver driver) {
	  super(driver);
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	 }
  @FindBy(id="productTitle")
  WebElement productTitle;
  
  public String getProductName() {
	  
	  return productTitle.getText();
  }
  
  public String getPageTitle() {
	  
	  return driver.getTitle();
  }
}
