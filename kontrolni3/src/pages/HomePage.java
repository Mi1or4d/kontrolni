package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public static final String URL ="https://www.saucedemo.com";
	public static final String USERNAME ="input#user-name";
	public static final String PASSWORD ="input#password";
	public static final String BUTTON_LOGIN= "/html/body/div[2]/div[1]/div/div/form/input[3]";
	public static final String LOGO ="div.login_logo";
	
	public static void clickUsername (WebDriver driver , String ime){
		WebDriverWait we = new WebDriverWait(driver, 5);
		we.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOGO)));
		driver.findElement(By.cssSelector(USERNAME)).sendKeys(ime);
	}
	
	public static void clickPassword (WebDriver driver , String pass){
		WebDriverWait we = new WebDriverWait(driver, 5);
		we.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOGO)));
		driver.findElement(By.cssSelector(PASSWORD)).sendKeys(pass);
	}
	
	public static void clickButton (WebDriver driver){
		driver.findElement(By.xpath(BUTTON_LOGIN)).click();
	}

}
