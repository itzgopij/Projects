package RedBus.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import RedBus.AbstractComponents.AbstractComponents;
import RedBus.PageObjects.HelpPage;
import RedBus.PageObjects.LandingPage;
import RedBus.TestComponents.BaseTest;
import junit.framework.Assert;

public class SearchBusTest extends BaseTest {

	@Test(groups="searchBus")
	public void BusSearch() throws IOException {
		
		landingPage.from("chennai", "guindy");
		landingPage.to("bangalore", "electronic city");
		landingPage.calendarMonth("Dec");
		landingPage.calendarDay("12");
		landingPage.searchBuses();

	}

	@Test
	public void isLogoResent() throws IOException {
		
		HelpPage helpPage = landingPage.gotToHelpPage();
		iterateWindow();
		Assert.assertTrue(helpPage.isLogoPresent()); 
		
  }

 }
