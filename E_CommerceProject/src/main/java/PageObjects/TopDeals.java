package PageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E_commerce.AbstractComponents.AbstractComponents;

public class TopDeals extends AbstractComponents {
       WebDriver driver;
       public TopDeals(WebDriver driver) {
    	   super(driver);
    	   this.driver = driver;
    	   PageFactory.initElements(driver, this);
       }
       
       By priceOfVeggie = By.xpath("following-sibling::td[1]");
       
       @FindBy(css="button[class*='react-date-picker__button']:nth-child(3)")
       WebElement datePicker;
       
       @FindBy(css="button[class='react-calendar__navigation__label']")
       WebElement monthAndYearPicker;
       
       //By month = By.xpath("//abbr[contains(text(),'August')]");
       @FindBy(css=".react-date-picker__inputGroup input")
       WebElement selectedDate;
       
       @FindBy(xpath="//tbody/tr/td[1]")
       List<WebElement> products;
       
       @FindBy(css="a[aria-label='Next']")
       WebElement nextButton;
       
       public void clickOnCalendar() {
    	   datePicker.click();
    	   monthAndYearPicker.click();
    	   monthAndYearPicker.click();
       }
       
       public void month(String month) {
    	   driver.findElements(By.tagName("abbr")).get(Integer.parseInt(month)-1).click();
       }
       
       public void year(String year) {
    	   driver.findElement(By.xpath("//button[contains(text(),'"+year+"')]")).click();
       }
       public void date(String day) {
    	   driver.findElement(By.xpath("//abbr[contains(text(),'"+day+"')]")).click();
       }
       public String getSelectedDate() {
    	  // waitForWebElementToAppear(selectedDate);
    	   return selectedDate.getAttribute("value");
    	 
       }
       public String productIsPresent(String veggie) {
    	   List<WebElement>product;
    	   String price = null;
    	 do {
    		 product =  products.stream().filter(s->s.getText().equalsIgnoreCase(veggie)).collect(Collectors.toList());
    		 if(product.size()<1) {
    			 nextButton.click();
    		 }
    		 else if(product.size()==1) {
    			 price= product.get(0).findElement(priceOfVeggie).getText();
    		 }
    		 
    	 }while(product.size()<1);
    	
      return price; }
       
}
