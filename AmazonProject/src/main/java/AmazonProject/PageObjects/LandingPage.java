package AmazonProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonProject.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class*='nav-line-1']")
	WebElement signIn;
	
	@FindBy(css="a[id*=location]")
	WebElement location;
	
	@FindBy(id="GLUXZipUpdateInput")
	WebElement pinCode;
	
	@FindBy(css="input[aria-labelledby='GLUXZipUpdate-announce']")
	WebElement applyPincode;
	
	@FindBy(id="glow-ingress-line2")
	WebElement city;
	
	@FindBy(css="#twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement search;
	
	@FindBy(id="#navFooter")
	 WebElement footerSection;
	
	
	public void setLocation(String code) {
		location.click();
		webElementToBeAppear(pinCode);
		pinCode.sendKeys(code);
		applyPincode.click();
		
	}
	
	public void goTo() {
		driver.get("https://www.amazon.in/");
	}
	
	public SignInPage clickSigIn() {
		signIn.click();
		return new SignInPage(driver); 
	}
	
	public boolean verifyCity(String e) throws InterruptedException {
		Thread.sleep(2000);
		  String cityName = city.getText();
		  boolean flag = cityName.contains(e)?true:false;
		  return flag;
	}
	
	public ProductCatalogues searchByProduct(String productName) {
		searchBox.sendKeys(productName);
		search.click();
		return new ProductCatalogues(driver);
		
	}
	
	public FaceBookLogin goToFooter() {
		Actions a = new Actions(driver);
		a.moveToElement(footerSection);
		return new FaceBookLogin(driver);
		
	}

 }
