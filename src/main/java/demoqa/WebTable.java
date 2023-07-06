package demoqa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
			
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		
		driver.findElement(By.id("addNewRecordButton")).click();
		
	}
	
	@Test
	public void addNewRecord() {
		
		List<String> Record = new ArrayList<>();
		Record.add(0, "ANSHUL");
		Record.add(1, "SHUKLA");
		Record.add(2, "anshul@mailinator.com");
		Record.add(3, "28");
		Record.add(4, "100000");
		Record.add(5, "I.T");
		
		driver.findElement(By.id("firstName")).sendKeys(Record.get(0));
		driver.findElement(By.id("lastName")).sendKeys(Record.get(1));
		driver.findElement(By.id("userEmail")).sendKeys(Record.get(2));
		driver.findElement(By.id("age")).sendKeys(Record.get(3));
		driver.findElement(By.id("salary")).sendKeys(Record.get(4));
		driver.findElement(By.id("department")).sendKeys(Record.get(5));
		driver.findElement(By.id("submit")).click();

		String Tabletext = driver.findElement(By.className("rt-tbody")).getText();
		if (Tabletext.contains("Anshul")) {
			System.out.println("VERIFIED");
		}
		
	}
	
	@Test
	public void editRecord () {
		List<WebElement> editBtn = driver.findElements(By.cssSelector(".action-buttons .mr-2"));
		editBtn.get(3).click();
		
		List<String> updateRecord = new ArrayList<>();
		updateRecord.add(0, "ANSHUL");
		updateRecord.add(1, "SHUKLA");
		updateRecord.add(2, "anshul@mailinator.com");
		updateRecord.add(3, "29");
		updateRecord.add(4, "100000");
		updateRecord.add(5, "QA");
		
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(updateRecord.get(0));
		
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(updateRecord.get(1));
		
		driver.findElement(By.id("userEmail")).clear();
		driver.findElement(By.id("userEmail")).sendKeys(updateRecord.get(2));
		
		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys(updateRecord.get(3));
		
		driver.findElement(By.id("salary")).clear();
		driver.findElement(By.id("salary")).sendKeys(updateRecord.get(4));
		
		driver.findElement(By.id("department")).clear();
		driver.findElement(By.id("department")).sendKeys(updateRecord.get(5));
		
		driver.findElement(By.id("submit")).click();

		String Tabletext = driver.findElement(By.className("rt-tbody")).getText();
		if (Tabletext.contains("QA")) {
			System.out.println("VERIFIED");
		}
		
		
	}
	
	@AfterTest
	public void closeBroswer() {
		
		driver.quit();
	}
	
		

}
