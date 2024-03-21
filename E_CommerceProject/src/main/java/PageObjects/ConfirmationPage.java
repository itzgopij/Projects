package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E_commerce.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	    WebDriver driver;
	    public ConfirmationPage(WebDriver driver) {
	    	super(driver);
	    	this.driver = driver;
	    	PageFactory.initElements(driver, this);
	    	
	    }
	    
	    @FindBy(css=".wrapperTwo span:nth-child(1)")
	   WebElement confirmationMsg;
	    
	    public boolean verifyConfirmationMessage() {
	    	//Thank you, your order has been placed successfully
	    	//You'll be redirected to Home page shortly!!
	    	String text = confirmationMsg.getText();
	    	//System.out.println(text);
	    	if(text.equalsIgnoreCase("Thank you, your order has been placed successfully\n"
	    			+"You'll be redirected to Home page shortly!!")) { 
	    		return true;
	    	}
	    	else	 
	   return false; }
}
