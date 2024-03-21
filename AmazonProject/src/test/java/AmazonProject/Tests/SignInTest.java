package AmazonProject.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AmazonProject.PageObjects.SignInPage;
import AmazonProject.TestComponents.BaseTest;

public class SignInTest extends BaseTest {
	
	
	@Test(dataProvider="getData",retryAnalyzer=AmazonProject.TestComponents.Retry.class)
	public void signIn(HashMap<String,String> input) throws IOException {
	SignInPage signInPage	= landingPage.clickSigIn();
	signInPage.userEmail(input.get("email")); 
	signInPage.submit();
	signInPage.userPassword(input.get("password"));
	signInPage.signIn();
	String msg = signInPage.errorMessage();
	Assert.assertEquals("Your password is incorrect", msg);
	
	}
	
	@DataProvider
	public Object[][] getData() {
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email","amazon@gmail.com");
		map.put("password","amazon123");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email","amazon5012@gmail.com");
		map1.put("password","amazon5012"); 
		
		return new Object[][] {{map},{map1}};
		
  }

}
