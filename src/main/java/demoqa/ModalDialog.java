package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ModalDialog {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions ();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/modal-dialogs");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test (priority = 1)
	public void smallModal () throws InterruptedException {
		WebElement ele = driver.findElement(By.id("showSmallModal"));
		ele.click();
		
		Thread.sleep(1000);
		
		WebElement frameClose = driver.findElement(By.id("closeSmallModal"));
		frameClose.click(); 
	}
	
	@Test (priority = 2)
	public void largeModel () throws InterruptedException {
		WebElement ele = driver.findElement(By.id("showLargeModal"));
		ele.click();
		Thread.sleep(1000);
		
		WebElement frameClose = driver.findElement(By.id("closeLargeModal"));
		frameClose.click();
	}
	
	@AfterTest
	public void closeBroswer () {
		driver.quit();
	}

}
