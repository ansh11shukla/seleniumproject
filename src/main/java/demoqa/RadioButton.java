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

public class RadioButton {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
	}
	
	@Test (priority = 1)
	public void Radiobutton1 () throws InterruptedException {
		WebElement Btn = driver.findElement(By.id("impressiveRadio"));
		Actions ac = new Actions(driver);
		ac.moveToElement(Btn).click().build().perform();
		Thread.sleep(2000);
	}
	
	@Test (priority = 2)
	public void Radiobutton2 () throws InterruptedException {
		WebElement Btn = driver.findElement(By.id("yesRadio"));
		Actions ac = new Actions(driver);
		ac.moveToElement(Btn).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 3)
	public void Radiobutton3 () {
		WebElement Btn = driver.findElement(By.id("noRadio"));
		Actions ac = new Actions(driver);
		ac.moveToElement(Btn).click().build().perform();
	}
	
	@AfterTest
	public void closeBroswer() {
		
		driver.quit();
		
	}

}
