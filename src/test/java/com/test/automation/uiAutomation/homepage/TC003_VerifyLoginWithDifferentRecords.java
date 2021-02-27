package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase {

	public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());

	HomePage homepage;

	@BeforeTest
	public void setUp() {
		init();
	}

	@DataProvider(name = "loginData")
	public String[][] getTestData() {
		String[][] getRecords = getData("TestData.xlsx", "LoginTestData");
		return getRecords;
	}

	@Test(dataProvider = "loginData")
	public void testLoginWithDifferentRecords(String email, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run:- " + runMode);
		}
		log.info("====== Starting TC003_VerifyLoginWithDifferentRecords ======");
		homepage = new HomePage(driver);
		homepage.loginToApplication(email, password);
		boolean status = homepage.assertSuccessfulLogin();
		getScreenShot("testLoginWithDifferentRecords_"+email);
		if (status) {
			homepage.clickOnLogout();
		}
		Assert.assertEquals(status, true);
		log.info("====== Finished TC003_VerifyLoginWithDifferentRecords ======");
	}

	@AfterTest
	public void end() {
		driver.close();
	}

}
