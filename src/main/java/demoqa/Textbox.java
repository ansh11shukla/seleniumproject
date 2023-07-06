package demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Elements;

public class Textbox {
	
	public static WebDriver driver;
			
	@BeforeTest
		public void launchBroswer() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(cr);
		
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,100)", "");
		
		driver.findElement(By.cssSelector(".category-cards .card.mt-4:nth-child(1)")).click();
		
			}
	@Test
		public void handleTextBox() throws InterruptedException {
		// LOCATE TEXTBOX OPTION IN MENU
		driver.findElement(By.cssSelector(".left-pannel .element-group:nth-child(1) ul li:nth-child(1)")).click();
		Thread.sleep(1000);
		
		// ADDING A INPUT IN TEXTBOX
		driver.findElement(Elements.Txt_FULLNAME).sendKeys("ANSHUL");
		driver.findElement(Elements.Txt_EMAIL).sendKeys("ANSHUL@MAIL.COM");
		driver.findElement(Elements.Txt_C_ADDRESS).sendKeys("CHANDIGARH");
		driver.findElement(Elements.Txt_P_ADDRESS).sendKeys("CHANDIGARH");
		
		//SCROLL SCREEN
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
		 
		Thread.sleep(1000);
		driver.findElement(Elements.SUBMIT).click();
		
		System.out.println("DONE");
		driver.quit();

	
	}
	

}
