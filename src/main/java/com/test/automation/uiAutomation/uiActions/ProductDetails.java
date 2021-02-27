package com.test.automation.uiAutomation.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class ProductDetails extends TestBase {
	
	public final static Logger log = Logger.getLogger(ProductDetails.class.getName());
	
	WebDriver driver;
	
	public final String printed_dress = "Printed Dress";
	public final String printed_summer_dress = "Printed Summer Dress";
	public final String blouse = "Blouse";
	public final String printed_chiffon_dress = "Printed Chiffon Dress";
	
	@FindBy(xpath="//a[@class='product_img_link']/img")
	List<WebElement> products; 
	
	public ProductDetails(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct(String product){
		driver.findElement(By.xpath("//a[@class='product_img_link']/img[@title='"+product+"']")).click();
		log.info("product "+ product +" has been selected");
	}
	
	public List<WebElement> selectProducts(){
		List<WebElement> elements = products;
		return elements;
	}

}
