package AmazonProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonProject.AbstractComponents.AbstractComponents;

public class SignInPage extends AbstractComponents {
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(css="#continue")
	WebElement submit;
	
	@FindBy(css="#ap_password")
	WebElement password;
	
	@FindBy(css="#signInSubmit")
	WebElement signIn;
	
	@FindBy(css="[class*='alert-content']")
	WebElement alertContent;
	
	public void userEmail(String userName) {
		email.sendKeys(userName);
	}
	
	public void submit() {
		submit.click();
	}
	
	public void userPassword(String e) {
		webElementToBeAppear(password);
		password.sendKeys(e);
		
	}
	
	public void signIn() {
		signIn.click();
	}
	
	public String errorMessage() {
		webElementToBeAppear(alertContent);
		return alertContent.getText();
	}

 }
