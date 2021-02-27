package com.test.automation.uiAutomation.addToCart;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.ProductDetails;

public class TC001_VerifyAddToCart extends TestBase {
	
	HomePage homepage;
	ProductDetails productDetailsPage;
	
	@BeforeClass
	public void setUp(){
		init();
	}

	@Test
	public void verifyAddToCart(){
		log.info("====== Starting TC001_VerifyAddToCart ======");
		homepage = new HomePage(driver);
		homepage.clickOnNavigationMenu(homepage.women);
		homepage.clickOnCategory(homepage.dresses);
		productDetailsPage = new ProductDetails(driver);
		productDetailsPage.selectProduct(productDetailsPage.printed_chiffon_dress);
		log.info("====== Finished TC001_VerifyAddToCart ======");
	}
	
	
	@AfterTest
	public void end() {
		closeBrowser();
	}
}
