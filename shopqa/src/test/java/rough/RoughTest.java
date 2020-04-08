package rough;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoughTest {
	
WebDriver driver;
	
	@Test (priority=1)
	void lauchBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/browsers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://shop.demoqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (priority = 2)
	void login() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Dismiss')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("gyho@getnada.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("gyho@getnada");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
		
		String invalidLoginErrorMessage = driver.findElement(By.xpath("//div[@id='primary']//li[1]")).getText();		
		AssertJUnit.assertEquals(invalidLoginErrorMessage, "ERROR: The username or password you entered is incorrect. Lost your password?");
	}
	
	@Test (priority = 3)
	void quitBrowser() {
		driver.quit();
	}

}
