package AmazonProject.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import AmazonProject.PageObjects.FaceBookLogin;
import AmazonProject.PageObjects.LandingPage;
import AmazonProject.PageObjects.ProductCatalogues;
import AmazonProject.PageObjects.ProductPage;
import AmazonProject.PageObjects.SignInPage;
import AmazonProject.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogues catalogue;
	public  ProductPage productPage;
	public SignInPage signInPage;
	public FaceBookLogin faceBook;
	
	
	@Given("I landed on landing page")
	public void i_landed_on_landing_page() throws IOException {
		 landingPage = launchApplication();
	    
	}

	@And("Searching desired product")
	public void searching_desired_product() {
		catalogue = landingPage.searchByProduct("samsung");
	}

	@When("Selecting the product")
	public void Selecting_the_product() {
		catalogue.selectProductContains("M14 4G (Arctic Blue,4GB,64GB)");
	
	}

	@When("Iterating the window")
	public void Iterating_the_window() {
        productPage = iterateWindow();
		
	}

	@Then("I validate the pageTitle with productName")
	public void I_validate_the_pageTitle_with_productName() {
		Assert.assertEquals(productPage.getPageTitle().split(":")[0].trim(), productPage.getProductName());
	driver.close();
	}
	
	
	@Given("Click on signIn button")
	public void click_on_sign_in_button() {
		 signInPage	= landingPage.clickSigIn();
	}
	
	@When("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String username,String password) {
		signInPage.userEmail(username); 
		signInPage.submit();
		signInPage.userPassword(password);
		signInPage.signIn();
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
		String msg = signInPage.errorMessage();
		Assert.assertEquals("Your password is incorrect", msg);
		driver.close();
	}
	
	@Given("Going to facebook login page")
	public void going_to_facebook_login_page() {
		 faceBook =  landingPage.goToFooter();
		faceBook.goTofacebookLoginPage();
		
		
	}

	@When("Iterating window")
	public void iterating_window() {
		iterateWindow();
	}

	@Then("{string} is correct")
	public void is_correct(String string) {
		faceBook.closeLogin();
		Assert.assertEquals(string,faceBook.verifyTitle().trim());
		driver.close();
	}



}
