package AmazonProject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import AmazonProject.PageObjects.LandingPage;
import AmazonProject.PageObjects.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	Iterator<String> it;
	Set<String> window ;
	
	
	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AmazonProject\\Resources\\GlobalData.properties"); 
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
				//String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")){
				options.addArguments("headless");
			}
			WebDriverManager.chromedriver().setup();
			 driver  = new ChromeDriver(options);
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//FirefoxProfile profile = new FirefoxProfile();
			//profile.setPreference("dom.disable_beforeunload", true);
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gopi\\Downloads\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public ProductPage iterateWindow() {
		 window =  driver.getWindowHandles();
		 it = window.iterator();
		
		String parentwindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		return new ProductPage(driver);
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png"));
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		 landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
