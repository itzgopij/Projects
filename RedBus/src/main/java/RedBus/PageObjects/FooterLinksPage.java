package RedBus.PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RedBus.AbstractComponents.AbstractComponents;

public class FooterLinksPage extends AbstractComponents {
        WebDriver driver;
	public FooterLinksPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(className="footer_links")
	WebElement footerLinks;
	
	@FindBy(css=".social_section")
	WebElement socialNetworks;
	
	By links = By.tagName("a");
	
	public int footerLinkscount() {
		List<WebElement> footers = footerLinks.findElements(links);
		return  footers.size();
	}
	
	 public void socailNetworksLinksStatus() throws MalformedURLException, IOException  {
		 List<WebElement> socialLinks = socialNetworks.findElements(links);
		 for(WebElement links:socialLinks) {
			String name = links.getAttribute("id").split("_")[1];
			String url = links.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(name+" = "+responseCode);
		 }
	 }
	
	
               
}
