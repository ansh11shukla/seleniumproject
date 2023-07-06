package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
	}
	
	@Test (priority = 1)
	public void alertButton () {
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test (priority = 2)
	public void timerAlertButton () throws InterruptedException {
		WebElement ele = driver.findElement(By.id("timerAlertButton"));
		Actions action = new Actions (driver);
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
	
	@Test (priority = 3)
	public void confirmButton () throws InterruptedException {
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
	}
	
	@Test (priority = 4)
	public void promptButton() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		String name = "Anshul";
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		
		String matchText = driver.findElement(By.id("promptResult")).getText();
		if (matchText.contains(name)) {
			System.out.println("TEST PASS");
		}
		else {
			System.out.println("TEST FAIL");
		}
	}

}
