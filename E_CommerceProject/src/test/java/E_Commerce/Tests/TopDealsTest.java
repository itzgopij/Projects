package E_Commerce.Tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import E_Commerce.TestComponents.BaseTest;
import PageObjects.TopDeals;

public class TopDealsTest extends BaseTest{

	
	@Test (groups="TopDeals")
	public void calendar() {
		TopDeals topDeals = landingPage.goToTopDealsPage();
		iterateWindow();
		topDeals.clickOnCalendar();
		String year = "2025";
		String month="08";
		String date = "12";
		String wantedDate= year+"-"+month+"-"+date;
		topDeals.year(year);
		topDeals.month(month);
		topDeals.date(date);
		//2025-08-12
		String selectedDate = topDeals.getSelectedDate();
		Assert.assertEquals(wantedDate, selectedDate);
		
	}
	
	@Test(groups="TopDeals")
	public void pagination() {
		TopDeals topDeals = landingPage.goToTopDealsPage();
		iterateWindow();
		String text = topDeals.productIsPresent("Almond");
		Assert.assertEquals("644", text); //wantedly failing this test to take screenshot
		
	}
}
