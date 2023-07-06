package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicProperties {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver (cr);
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test (priority = 1)
	public void enableAfter5Sec () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
		ele.click();
		System.out.println("ELEMENT CLICKED");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

	@Test (priority = 2)
	public void visibleAfter5Sec () {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("visibleAfter")));
		ele.click();
		System.out.println("ELEMENT VISIBLE");
	}
	
	@Test (priority = 3)
	public void colorChange () {
		WebElement e = driver.findElement(By.id("colorChange"));
		// OBTAIN COLOR IN RGBA
		String s = e.getCssValue("color");
		// CONVERT RGBA TO HEX
		String c = Color.fromString(s).asHex();
		System.out.println("Color is "+s);
		System.out.println("Hexa color is "+c);
	}
}
