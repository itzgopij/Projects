package RedBus.AbstractComponents;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RedBus.PageObjects.HelpPage;

public class AbstractComponents {
	   WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void waitForElementToAppear(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void waitForElementToAppear(List<WebElement> e) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(e));
	}
	
	
	

 }
