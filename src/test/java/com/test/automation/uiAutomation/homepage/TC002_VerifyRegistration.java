package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC002_VerifyRegistration extends TestBase {

	public static final Logger log = Logger.getLogger(TC002_VerifyRegistration.class.getName());

	HomePage homepage;

	@BeforeTest
	public void setUp() {
		init();
	}

	@Test
	public void verifyRegistration() {
		log.info("====== Starting TC002_VerifyRegistration ======");
		homepage = new HomePage(driver);
		homepage.registerUser();
		Assert.assertTrue(homepage.assertSuccessfulLogin());
		log.info("asserting if logout is displayed after successful user registration");
		log.info("====== Finished TC002_VerifyRegistration ======");
	}

	@AfterTest
	public void end() {
		closeBrowser();
	}

}
