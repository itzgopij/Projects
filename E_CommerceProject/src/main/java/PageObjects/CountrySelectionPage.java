package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import E_commerce.AbstractComponents.AbstractComponents;

public class CountrySelectionPage extends AbstractComponents {
	WebDriver driver;
	
	public CountrySelectionPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
       }
	@FindBy(tagName="select")
	WebElement dropDown;
	
	@FindBy(css="input[type='checkbox']")
	WebElement TnC;
	
	@FindBy(xpath="//button[contains(text(),'Proceed')]")
	WebElement proceed;
	
	public void selectCountry(String countryName) {
		WebElement options =  dropDown;
		Select staticDropDown = new Select(options);
		staticDropDown.selectByVisibleText(countryName);
	}
	
	public ConfirmationPage goToConfirmationPage() {
		TnC.click();
		proceed.click();
		ConfirmationPage cnfrmPage = new ConfirmationPage(driver);
			return  cnfrmPage;
	}

}
