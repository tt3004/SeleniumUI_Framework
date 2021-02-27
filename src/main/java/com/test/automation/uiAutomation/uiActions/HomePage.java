package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	public final String women = "Women";
	public final String tops = "Tops";
	public final String dresses = "Dresses";
	public final String printed_dress = "Printed Dress";
	public final String printed_summer_dress = "Printed Summer Dress";
	public final String blouse = "Blouse";

	@FindBy(className = "login")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement loginEmail;

	@FindBy(id = "passwd")
	WebElement loginPassword;

	@FindBy(css = "#SubmitLogin")
	WebElement submitButton;

	@FindBy(css = ".alert.alert-danger>ol>li")
	WebElement authenticationFailure;

	@FindBy(css = "#email_create")
	WebElement createEmail;

	@FindBy(id = "SubmitCreate")
	WebElement submitCreate;

	@FindBy(css = "#id_gender1")
	WebElement mrRadioBtn;

	@FindBy(css = "#id_gender2")
	WebElement mrsRadioBtn;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(css = "#passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement dobDays;

	@FindBy(id = "months")
	WebElement dobMonth;

	@FindBy(id = "years")
	WebElement dobYear;

	@FindBy(id = "newsletter")
	WebElement newsletter;

	@FindBy(id = "optin")
	WebElement offers;

	@FindBy(id = "firstname")
	WebElement addrFirstName;

	@FindBy(id = "lastname")
	WebElement addrLastName;

	@FindBy(id = "company")
	WebElement addrCompany;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "postcode")
	WebElement zip;

	@FindBy(id = "id_country")
	WebElement country;

	@FindBy(id = "other")
	WebElement additionalInfo;

	@FindBy(id = "phone")
	WebElement homePhone;

	@FindBy(id = "phone_mobile")
	WebElement mobilePhone;

	@FindBy(id = "alias")
	WebElement addrAlias;

	@FindBy(id = "submitAccount")
	WebElement registerUser;

	@FindBy(css = ".logout")
	WebElement logout;

	/**
	 * @param driver
	 *            This method is required to initialize the web elements else
	 *            we'll get the NullPointerException
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String email, String password) {
		signIn.click();
		log.info("clicked on sign in and object is :- " + signIn.toString());
		loginEmail.sendKeys(email);
		log.info("entered email address is :- " + email + " and object is :-" + loginEmail.toString());
		loginPassword.sendKeys(password);
		log.info("entered password is :- " + password + " and object is :- " + loginPassword.toString());
		submitButton.click();
		log.info("clicked on submit button and object is :-" + submitButton.toString());
	}

	public String getInvalidLoginText() {
		log.info("error message is :- " + authenticationFailure.getText());
		return authenticationFailure.getText();
	}

	public void registerUser() {
		signIn.click();
		log.info("clicking on sign in button and object is:- " + signIn.toString());

		createEmail.sendKeys(System.currentTimeMillis()+"@gmail.com");
		log.info("providing signup email and object is:- " + createEmail.toString());

		submitCreate.click();
		log.info("clicking on create account button and object is:- " + submitCreate.toString());

		mrRadioBtn.click();
		log.info("selecting the Mr. title and object is:- " + mrRadioBtn.toString());

		firstName.clear();
		firstName.sendKeys("Ram");
		log.info("providing first name and object is:- " + firstName.toString());

		lastName.clear();
		lastName.sendKeys("Sharma");
		log.info("providing last name and object is:- " + lastName.toString());

		password.sendKeys("password");
		log.info("providing the password and object is:- " + password.toString());

		Select days = new Select(dobDays);
		days.selectByValue("2");
		log.info("selecting the days of dob and object is:- " + dobDays.toString());

		Select month = new Select(dobMonth);
		month.selectByValue("8");
		log.info("selecting the month of dob and object is:- " + dobMonth.toString());

		Select year = new Select(dobYear);
		year.selectByValue("1988");
		log.info("selecting the year of dob and object is:- " + dobYear.toString());

		// addrFirstName.sendKeys("trupti");
		// addrLastName.sendKeys("Nande");

		addrCompany.clear();
		addrCompany.sendKeys("TCS");
		log.info("providing company name and object is:- " + addrCompany.toString());

		address1.clear();
		address1.sendKeys("9547 D UT Drive");
		log.info("providing the address and object is:- " + address1.toString());

		city.clear();
		city.sendKeys("Charlotte");
		log.info("providing the city and object is:- " + city.toString());

		Select stateAddr = new Select(state);
		stateAddr.selectByVisibleText("North Carolina");
		log.info("selecting the state and object is:- " + state.toString());

		zip.clear();
		zip.sendKeys("28262");
		log.info("providing the zip code and object is:- " + zip.toString());

		Select countryAddr = new Select(country);
		countryAddr.selectByVisibleText("United States");
		log.info("selecting the country and object is:- " + country.toString());

		mobilePhone.clear();
		mobilePhone.sendKeys("9803650362");
		log.info("providing the mobile number and object is:- " + mobilePhone.toString());

		addrAlias.clear();
		addrAlias.sendKeys("Home Address");
		log.info("providing the address alias and object is:- " + addrAlias);

		registerUser.click();
		log.info("clicking on register user button and object is: " + registerUser.toString());
	}

	public boolean assertSuccessfulLogin() {
		try {
			//waitForElement(300, logout);
			logout.isDisplayed();
			log.info("logout is displayed and object is:- " + logout.toString());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void clickOnLogout() {
		logout.click();
		log.info("clicked on logout and object is:- " + logout.toString());
	}
	
	public void clickOnNavigationMenu(String menuName){
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[contains(text(), '"+menuName+"') and @title='"+menuName+"']")).click();;
		log.info("clicked on " + menuName + " navigation menu.");
	}
	
	public void clickOnCategory(String category){
		driver.findElement(By.xpath("//ul[@class='tree dynamized']/li/a[contains(text(), '"+category+"')]")).click();
		log.info("clicked on " + category + " category submenu.");
	}
	
	public void clickOnSubCategory(String subCategory){
		driver.findElement(By.xpath("//ul[@style='display: block;']/li/a[contains(text(),'"+subCategory+"')]")).click();
		log.info("clicked on " + subCategory + " subcategory submenu.");
	}
}
