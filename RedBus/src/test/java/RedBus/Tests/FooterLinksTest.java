package RedBus.Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import RedBus.PageObjects.FooterLinksPage;
import RedBus.TestComponents.BaseTest;
import junit.framework.Assert;

public class FooterLinksTest extends BaseTest {
	
	@Test(groups="footer")
	public void footerLinksChecking() throws IOException {
		SoftAssert a = new SoftAssert();
		FooterLinksPage flp =  landingPage.goToFooter();
		scrollDown();
		a.assertEquals(20, flp.footerLinkscount()); // wantedly failing this test to capture screenshot upon test failure
		flp.socailNetworksLinksStatus();
		a.assertAll();
	}

	
 }
