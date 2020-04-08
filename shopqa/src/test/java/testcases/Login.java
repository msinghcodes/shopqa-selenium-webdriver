package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;


import base.BaseTest;

public class Login extends BaseTest{
	
	@Test
	public void invalidLogin() {
		
		
		driver.findElement(By.xpath(ORFile.getProperty("dismiss"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("myaccountlink"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("loginusername"))).sendKeys("gyho@getnada.com");
		driver.findElement(By.xpath(ORFile.getProperty("loginpassword"))).sendKeys("gyho@getnada");
		driver.findElement(By.xpath(ORFile.getProperty("loginbutton"))).click();
		
		
		
		String invalidLoginErrorMessage = driver.findElement(By.xpath(ORFile.getProperty("invalidloginmessage"))).getText();		
		Assert.assertEquals(invalidLoginErrorMessage, "ERROR: The username or password you entered is incorrect. Lost your password?");
		
	}
	
	@Test
	public void validLogin() {
		
		
		
		
		driver.findElement(By.xpath(ORFile.getProperty("myaccountlink"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("loginusername"))).sendKeys("gyho@getnada.com");
		driver.findElement(By.xpath(ORFile.getProperty("loginpassword"))).sendKeys("gyho@getnada.com");
		driver.findElement(By.xpath(ORFile.getProperty("loginbutton"))).click();
		
		
		
		String validLoginMessage = driver.findElement(By.xpath(ORFile.getProperty("loginmessage"))).getText();		
		Assert.assertEquals(validLoginMessage, "Hello gyho (not gyho? Log out)");
	}

}
