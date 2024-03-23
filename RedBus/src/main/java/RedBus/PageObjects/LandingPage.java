package RedBus.PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RedBus.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "src")
	WebElement from;

	@FindBy(id = "dest")
	WebElement to;

	@FindBy(css = "[class='placeHolderMainText']")
	List<WebElement> fromOptions;

	@FindBy(css = "[class*='sc-gZMcBi'] [class='placeHolderMainText']")
	List<WebElement> toOptions;
	
	@FindBy(css="[class*='iZpveD']:nth-child(2)")
	WebElement calendarMonth;
	
	@FindBy(css="[class*='DayNavigator__IconBlock']:nth-of-type(3)")
	WebElement calendarNext;
	
	@FindBy(css="[class*='DayTiles__CalendarDaysSpan']")
	List<WebElement> calendarDay;
	
	@FindBy(id="search_button")
	WebElement search;
	
	@FindBy(xpath="//span[contains(text(),'Help')]")
	 WebElement help;
	
	@FindBy(className="footer_links")
	WebElement footerLinks;
	
	

	public void goTo() {
		driver.get("https://www.redbus.in/");
	}

	public void from(String From, String boardingFrom) {
		from.sendKeys(From);
		waitForElementToAppear(fromOptions);
		WebElement fromOption = fromOptions.stream().filter(s -> s.getText().equalsIgnoreCase(boardingFrom)).findFirst()
				.orElse(null);
		fromOption.click();
	}

	public void to(String To, String destination) {
		to.sendKeys(To);
		waitForElementToAppear(toOptions);
		WebElement toOption = toOptions.stream().filter(s -> s.getText().equalsIgnoreCase(destination)).findFirst()
				.orElse(null);
		toOption.click();

	}
	
	public void calendarMonth(String month) {
		
		do {
			
			calendarNext.click();
		}while(!calendarMonth.getText().contains(month));
	}
	
	public void calendarDay(String e) {
		WebElement day = calendarDay.stream().filter(s->s.getText().equalsIgnoreCase(e)).findFirst().orElse(null);
		day.click();
		}
	
	public void searchBuses() {
		search.click();
	}
	
	public  HelpPage gotToHelpPage() {
		help.click();
		HelpPage helpPage = new HelpPage(driver);
		return helpPage;
	}
	
	public FooterLinksPage goToFooter() {
		Actions a = new Actions(driver);
		a.moveToElement(footerLinks);
		FooterLinksPage flp = new FooterLinksPage(driver);
		return flp;
	}
	
	
}
