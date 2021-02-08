package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inventory {
	
	public static final String URL2="https://www.saucedemo.com/inventory.html";
	public static final String LIST ="select.product_sort_container";
	public static final String PRICE_LOW_HIGH="/html/body/div/div[2]/div[2]/div/div[1]/div[3]/select/option[3]";

	
	public static void clickList (WebDriver driver ){
		WebDriverWait we = new WebDriverWait(driver, 5);
		we.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LIST)));
		driver.findElement(By.cssSelector(LIST)).click();
		driver.findElement(By.xpath(PRICE_LOW_HIGH)).click();
	}
}
