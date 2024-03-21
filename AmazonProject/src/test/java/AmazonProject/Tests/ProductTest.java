package AmazonProject.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import AmazonProject.PageObjects.ProductCatalogues;
import AmazonProject.PageObjects.ProductPage;
import AmazonProject.TestComponents.BaseTest;

public class ProductTest extends BaseTest {

	@Test(groups= {"product"})
	public void verifyProductName() {
		ProductCatalogues catalogue = landingPage.searchByProduct("samsung");
		catalogue.selectProductContains("M14 4G (Arctic Blue,4GB,64GB)");
		ProductPage productPage = iterateWindow();
		
		Assert.assertEquals(productPage.getPageTitle().split(":")[0].trim(), productPage.getProductName());
		
		}
	
	}
