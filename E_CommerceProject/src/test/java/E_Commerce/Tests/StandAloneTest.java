package E_Commerce.Tests;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import E_Commerce.TestComponents.BaseTest;
import PageObjects.CheckOutPage;
import PageObjects.ConfirmationPage;
import PageObjects.CountrySelectionPage;


public class StandAloneTest extends BaseTest {
	
	@Test
	public void productBuying() {
		  landingPage.Products();
		String Wantedproducts[] = {"Potato","Pumpkin","Almonds"};
		landingPage.selectProducts(Wantedproducts);
		CheckOutPage	checkOutPage = landingPage.goToCheckOutPage();
		boolean flag = checkOutPage.verifyProducts(Wantedproducts);
		Assert.assertTrue(flag);
		checkOutPage.applyPromoCode("rahulshettyacademy");
		Assert.assertTrue(checkOutPage.promoMsg().isDisplayed());
		boolean flag1 = checkOutPage.verifyTotal();
		Assert.assertTrue(flag1);
		CountrySelectionPage countrySelectionPage =  checkOutPage.goToCountrySelectionPage();
		countrySelectionPage.selectCountry("India");
		ConfirmationPage cnfrmPage = countrySelectionPage.goToConfirmationPage();
		boolean flag2 = cnfrmPage.verifyConfirmationMessage();
		Assert.assertTrue(flag2);
	}
	

}
