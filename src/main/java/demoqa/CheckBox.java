package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static WebDriver driver;
	
	@BeforeTest
	public void launchBroswer() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cr = new ChromeOptions();
		cr.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(cr);
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void checkbox() {
		WebElement checkbox = driver.findElement(By.cssSelector(".check-box-tree-wrapper ol li li:nth-child(1) ol li:nth-child(1) .rct-checkbox"));
		Actions ac = new Actions(driver);
		ac.moveToElement(checkbox).click().build().perform();
	}
}
