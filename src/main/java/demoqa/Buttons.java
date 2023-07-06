package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {
	
public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
			
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		
	}
	
	@Test (priority = 1)
	public void doubleClickBtn () throws InterruptedException {
		WebElement ele = driver.findElement(By.id("doubleClickBtn"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).doubleClick().build().perform();
		Thread.sleep(1000);
	}
	
	@Test (priority = 2)
	public void RightClickBtn () throws InterruptedException {
		WebElement ele = driver.findElement(By.id("rightClickBtn"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).contextClick().build().perform();
		Thread.sleep(1000);
	}
	
	@Test (priority = 3)
	public void ClickBtn () throws InterruptedException {
		WebElement ele = driver.findElement(By.cssSelector(".col-12.mt-4.col-md-6 div:nth-child(2) .mt-4:nth-child(3) .btn.btn-primary"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void closeBroswer() {
		driver.quit();
	}

}
