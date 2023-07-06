package demoqa;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_Download {
		
	public static WebDriver driver;
		
		@BeforeTest
		public void launchBroswer() {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions cr = new ChromeOptions();
			cr.addArguments("--remote-allow-origins=*");
				
			driver = new ChromeDriver(cr);
			driver.get("https://demoqa.com/upload-download");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	
			
		}
		
		@Test
		public void downloadButton() {
			
			WebElement btn = driver.findElement(By.id("downloadButton"));
			Actions ac = new Actions(driver);
			ac.moveToElement(btn).click().build().perform();
		}
		
		@Test
		public void uploadButton() throws InterruptedException {
			try {
			WebElement btn = driver.findElement(By.id("uploadFile"));
			Thread.sleep(2000);
			btn.sendKeys(new java.io.File("F:\\WP\\5685997.jpgs").getAbsolutePath());
			Thread.sleep(2000);
			} catch (NoSuchElementException e) {
				System.out.println("UNABLE TO UPLOAD A FILE");
			} catch (TimeoutException e) {
				e.printStackTrace();
			}
			
		}
		
		@AfterTest
		public void closeBroswer() {
			
			driver.quit();;
		}

}
