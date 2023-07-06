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

public class NestedFrame {
	
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
	public void nestedFrame() throws InterruptedException {
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame("frame1");
		WebElement frame1Element = driver.findElement(By.tagName("body"));
		String frame1Text = frame1Element.getText();
		System.out.println("Frame1 is :" +frame1Text);
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		WebElement frame2Element = driver.findElement(By.tagName("body"));
		String frame2Text = frame2Element.getText();
		System.out.println("Frame2 is :" +frame2Text);
			
	}
	
	@AfterTest
	public void closeBroswer() {
		
		driver.quit();
	}

}
