package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.uiAutomation.excelReader.Excel_Reader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = System.getProperty("browser"); // getting the browser through jenkins @ run time
	Excel_Reader excelReader;

	public void init() {
		selectBrowser(browser);
		getUrl(url);
		String log4jConf = "log4j.properties";
		PropertyConfigurator.configure(log4jConf);
	}

	public void selectBrowser(String browser) {
		log.info("creating the object of " + browser);
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver();
		}
	}

	public void getUrl(String url) {
		log.info("navigating to " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiAutomation/data/"
				+ excelName;
		excelReader = new Excel_Reader(path);
		String[][] data = excelReader.getDataFromSheet(sheetName, excelName);
		return data;
	}
	
	public void waitForElement(int timeOutInSeconds, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void getScreenShot(String name) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		// taking the screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			// storing the screenshot into appropriate directory
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshot/";
			File destFile = new File(reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			
			// copying the source file into destination file after taking the screenshot to store it permanently
			FileUtils.copyFile(srcFile, destFile);
			
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeBrowser(){
		driver.quit();
		log.info("browser closed");
	}
	
}
