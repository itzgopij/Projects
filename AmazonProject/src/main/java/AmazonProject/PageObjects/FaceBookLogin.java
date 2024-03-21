package AmazonProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonProject.AbstractComponents.AbstractComponents;

public class FaceBookLogin extends AbstractComponents{
	WebDriver driver;
	
	 public FaceBookLogin(WebDriver driver) {
		 super(driver);
		 this.driver = driver;	
		 PageFactory.initElements(driver, this);
		 }
	 
	 @FindBy(css="#navFooter")
	 WebElement footerSection;
	 
	@FindBy(css="div[aria-label='Close']")
	WebElement close;
	 
	@FindBy(tagName="h1")
	WebElement title;
	 
	 By facebook = By.xpath("//a[contains(text(),'Facebook')]");
	 
	 public void goTofacebookLoginPage() {
		 String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
		 footerSection.findElement(facebook).sendKeys(clickOnLink);
	 }
	 
	 public void closeLogin() {
		close.click();
	 }
	 
	 public String verifyTitle() {
		 scrollDown();
		return title.getText();
	 }
	 

}
