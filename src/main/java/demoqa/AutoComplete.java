package demoqa;

import java.time.Duration;
import java.util.List;

import javax.management.StringValueExp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoComplete {
	
public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions ();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/auto-complete");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void autoCompleteMultiple () {
		WebElement autoCompleteInput =driver.findElement(By.id("autoCompleteMultipleInput"));
		List<String> valueToSelect = List.of("Red", "Yellow", "Green");
		
		for (String value : valueToSelect) {
		autoCompleteInput.sendKeys(value);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-select-2-option-0\"")));
		dropdownOption.click();
		autoCompleteInput.clear();
		}
			
		
	}

}
