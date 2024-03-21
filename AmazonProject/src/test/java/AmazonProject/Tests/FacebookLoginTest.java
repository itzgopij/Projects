package AmazonProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AmazonProject.PageObjects.FaceBookLogin;
import AmazonProject.TestComponents.BaseTest;

public class FacebookLoginTest extends BaseTest{

	@Test(groups={"facebook"})
	public void facebookLogin() {
		FaceBookLogin faceBook =  landingPage.goToFooter();
		faceBook.goTofacebookLoginPage();
		iterateWindow();
		faceBook.closeLogin();
		Assert.assertEquals("Amazon India123",faceBook.verifyTitle().trim()); //wantedly failing this test to capture screenshot upon test failure
		
	}
	
}
