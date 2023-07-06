package demoqa;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobject.PracticeFormOR;

public class PracticeForm {
	
	public static WebDriver driver;
	
	final static Logger logger = LogManager.getLogger(PracticeForm.class);
	
	public static void launchBroswer(WebDriver driver) {
		try {
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	} catch (TimeoutException e) {
		logger.info("NOt able to load the URL within 20 sec ", e);
	}
		logger.info("URL is loaded successfully ");
	}
	
	public static void enterData (WebDriver driver, String fname, String lname, String email) {
		try {
		driver.findElement(PracticeFormOR.TXT_FIRST).sendKeys(fname);
		driver.findElement(PracticeFormOR.TXT_LAST).sendKeys(lname);
		driver.findElement(PracticeFormOR.TXT_EMAIL).sendKeys(email);
		
		} catch (NoSuchElementException e) {
			logger.info("UNABLE TO LOCATE ELEMENT", e);
		} 
			logger.info("ABLE TO ENTER FIRSTNAME, LASTNAME AND EMAIL");
		}
		
	
	
	public static void selectGender(WebDriver driver) {
		try {
		WebElement selectgender = driver.findElement(PracticeFormOR.GENDER);
		Actions action = new Actions(driver);
		action.moveToElement(selectgender).click().build().perform();
		} catch (NoSuchElementException e) {
			logger.info("GENDER IS NOT SELECTED", e);
		} catch (TimeoutException e) {
			logger.info("TIMEOUT", e);
		}
		logger.info("GENDER IS SELECTED");
	}
	
	public static void enterMobile (WebDriver driver, String pnum) {
		try {
			driver.findElement(PracticeFormOR.TXT_MOBILE).sendKeys(pnum);
		} catch (Exception e) {
			logger.info("NOT ABLE TO ENTER MOBILE", e);
		}
			logger.info("ABLE TO ENTER MOBILE NUMBER");
	}
	
	public static void enterAddress (WebDriver driver, String adr) {
		try {
			driver.findElement(PracticeFormOR.TXT_ADDRESS).sendKeys(adr);
		} catch (Exception e) {
			logger.info("NOT ABLE TO ENTER ADDRESS", e);
		}
			logger.info("ABLE TO ENTER ADDRESS");
		
	}
	
	public static void selectDate(WebDriver driver) {
		try {
		WebElement element = driver.findElement(PracticeFormOR.DOB);
		Actions action = new Actions (driver);
		action.moveToElement(element).click().build().perform();
		
		Select month = new Select (driver.findElement(PracticeFormOR.MONTH));
		month.selectByIndex(0);
		
		Select year = new Select (driver.findElement(PracticeFormOR.YEAR));
		year.selectByValue("1994");
		
		List<WebElement> day = driver.findElements(PracticeFormOR.DAY);
		for (WebElement myday: day) {
			myday.click();
			break;
		} 
		} catch (NoSuchElementException e) {
			logger.info("NOT ABLE TO SELECT DARE", e);
		}
			logger.info("DATE IS SELECTED");
	}
	
	public static void selectSubject(WebDriver driver, String sub) throws InterruptedException {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(PracticeFormOR.SUBJECT));
		ele.sendKeys(sub);
		Thread.sleep(2000);
		driver.findElement(PracticeFormOR.TXT_SUB).click();
		
	} 	catch (NoSuchElementException e) {
		logger.info("NOT ABLE TO SELECT SUBJECT", e);
	}	catch (TimeoutException e) {
		logger.info("TIMEOUT", e);
	}	
		logger.info("SUBJECT IS SELECTED");
	}
	
	public static void selectHobbies(WebDriver driver, String hobbies) {
		try {
		WebElement element = driver.findElement(PracticeFormOR.HOBBIES);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	} catch (NoSuchElementException e) {
		logger.info("NOT ABLE TO SELECT SUBJECT", e);
	} catch (TimeoutException e) {
		logger.info("TIMEOUT", e);
	}	logger.info("HOBBIES IS SELECTED");
	}
		
	public static void uploadImage(WebDriver driver) throws InterruptedException {
		try {
			WebElement file = driver.findElement(PracticeFormOR.IMG);
			Thread.sleep(2000);
			file.sendKeys(new java.io.File("F:\\WP\\5685997.jpg").getAbsolutePath());
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			logger.info("NOT ABLE TO UPLOAD IMAGE", e);
		} catch (TimeoutException e) {
			logger.info("TIMEOUT", e);
		}	logger.info("IMAGE IS UPLOADED");
	}
	
	public static void selectState(WebDriver driver, String state) {
		try {
			WebElement element = driver.findElement(PracticeFormOR.STATE);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();

			WebElement se = driver.findElement(PracticeFormOR.TXT_STATE);
			se.click();

		} catch (NoSuchElementException e) {
			logger.info("NOT ABLE TO SELECT STATE", e);
		} catch (TimeoutException e) {
			logger.info("TIMEOUT", e);
		} logger.info("STATE IS SELECTED");
	}

	public static void selectCity(WebDriver driver, String city) {
		try {
			driver.findElement(PracticeFormOR.City).click();
			WebElement se = driver.findElement(PracticeFormOR.TXT_CITY);
			se.click();
		} catch (NoSuchElementException e) {
			logger.info("NOT ABLE TO SELECT CITY", e);
		} catch (TimeoutException e) {
			logger.info("TIMEOUT", e);
		} logger.info("CITY IS SELECTED");

	}
	
	public static void clickSubmit(WebDriver driver) {
		try {
			WebElement element = driver.findElement(PracticeFormOR.SUBMIT);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();

		} catch (NoSuchElementException e) {
			logger.info("NOT ABLE TO SELECT SUBMIT BUTTON", e);
		} catch (TimeoutException e) {
			logger.info("TIMEOUT", e);
		} logger.info("SUBMIT IS CLICKED");
	}
	
	
}
