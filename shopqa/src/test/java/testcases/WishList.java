package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class WishList extends BaseTest{
	
	@Test
	void addItemToWishList(){
		//Adding item to the wishlist
		
		driver.findElement(By.className(ORFile.getProperty("logo"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("pinktshirt"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("pinktshirtaddwishlist"))).click();
		
		//Verifying item added to the Wishlist
		
		driver.findElement(By.className(ORFile.getProperty("logo"))).click();
		driver.findElement(By.xpath(ORFile.getProperty("mywishlist"))).click();
		String wishListItem = driver.findElement(By.xpath(ORFile.getProperty("pinktshirt"))).getText();
		Assert.assertEquals(wishListItem, "PINK DROP SHOULDER OVERSIZED T SHIRT");
	}
	
	@Test
	void removeItemFromWishList() {
		driver.findElement(By.xpath(ORFile.getProperty("removeitemwishlist"))).click();
		
		//Verify product removed
		
		String productRemovedWishList = driver.findElement(By.xpath(ORFile.getProperty("removeitemwishlistmesssage"))).getText();
		Assert.assertEquals(productRemovedWishList, "Product successfully removed.");
	}

}
