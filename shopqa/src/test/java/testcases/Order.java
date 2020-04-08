package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class Order extends BaseTest{
	
	@Test
	void addItemsToCart() {
		//Adding first item
		
		driver.findElement(By.className(ORFile.getProperty("logo"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("pinktshirt"))).click();
		Select drpColor = new Select(driver.findElement(By.id("pa_color")));
		drpColor.selectByVisibleText("Pink");
		Select drpSize = new Select(driver.findElement(By.id("pa_size")));
		drpSize.selectByVisibleText("36");
		driver.findElement(By.xpath(ORFile.getProperty("increaseqty"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("addtocartbutton"))).click();
		
		//Adding another item
		
		driver.findElement(By.className(ORFile.getProperty("logo"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("tokyotalkies"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("addtocartbutton"))).click();
		
		//Time to verify items added to cart
		
		driver.findElement(By.xpath(ORFile.getProperty("cartlink"))).click();
		
		String pinkItem = driver.findElement(By.xpath("//td[@class='product-name']//a[contains(text(),'pink drop')]")).getText();
		Assert.assertEquals(pinkItem, "PINK DROP SHOULDER OVERSIZED T SHIRT - PINK");
		
		String tokyoItem = driver.findElement(By.xpath("//td[@class='product-name']//a[contains(text(),'Tokyo Talkies')]")).getText();
		Assert.assertEquals(tokyoItem, "TOKYO TALKIES");
	}
	
	@Test
	void emptyCart() {
		driver.findElement(By.xpath(ORFile.getProperty("emptrycart"))).click();
		
		String emptryCartMessage = driver.findElement(By.xpath("//p[contains(@class,'cart-empty woocommerce-info')]")).getText();
		Assert.assertEquals(emptryCartMessage, "Your cart is currently empty.");
	}

}
