package RedBus.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RedBus.AbstractComponents.AbstractComponents;

public class HelpPage extends AbstractComponents{
	WebDriver driver;
	public HelpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[contains(@src,'redbus-logo')]")
	WebElement logo;
	
	public boolean isLogoPresent() {
		waitForElementToAppear(logo);
		return  logo.isDisplayed();
	}

}
