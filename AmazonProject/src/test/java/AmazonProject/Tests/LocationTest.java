package AmazonProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AmazonProject.TestComponents.BaseTest;

public class LocationTest extends BaseTest{
	
	@Test 
	public void locationTest() throws InterruptedException {
		
		landingPage.setLocation("637408");
		 boolean flag = landingPage.verifyCity("Rasipuram");
		 Assert.assertTrue(flag);
		 
	}
	
	

}
