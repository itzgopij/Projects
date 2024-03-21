package AmazonProject.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonProject.AbstractComponents.AbstractComponents;

public class ProductCatalogues extends AbstractComponents {
          WebDriver driver;
          
          public ProductCatalogues(WebDriver driver) {
        	  super(driver);
        	  this.driver = driver;
        	  PageFactory.initElements(driver, this);
          }
          
          @FindBy(xpath="//span[contains(@class,'a-size-medium')]")
          List<WebElement> products;
          
          public void selectProductContains(String text) {
        	  WebElement element = products.stream().filter(s->s.getText().contains(text)).findFirst().orElse(null);
        	  element.click();
          }
 }
