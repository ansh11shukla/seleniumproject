package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
		
		public static WebDriver driver;
		
		@BeforeTest
		public void launchBroswer() {
		
			WebDriverManager.chromedriver().setup();
			ChromeOptions cr = new ChromeOptions();
			cr.addArguments("--remote-allow-origins=*");
			
			driver = new ChromeDriver (cr);
			driver.get("https://demoqa.com/frames");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
	}
		@Test
		public void frame1 () {
			driver.switchTo().frame(driver.findElement(By.id("frame1")));
			
			String frameText = driver.findElement(By.id("sampleHeading")).getText();
			
			System.out.println("frameText");
		}
		
		@AfterTest
		public void closeBroswer() {
			
		driver.quit();
		
		}
}