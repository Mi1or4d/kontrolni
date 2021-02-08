package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.Inventory;

public class Tests {
	
public static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Driver\\ChromeDriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void goToUrl () {
		driver.navigate().to(HomePage.URL);
		String actual = driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test
	public void alogIn(){
		driver.navigate().to(HomePage.URL);
		HomePage.clickUsername(driver, "Pera");
		HomePage.clickPassword(driver, "Peric");
		HomePage.clickButton(driver);
	}
	@Test
	public void bLogIn(){
		driver.navigate().to(HomePage.URL);
		HomePage.clickUsername(driver, "standard_user");
		HomePage.clickPassword(driver, "secret_sauce");
		HomePage.clickButton(driver);
	}
	
	@Test (priority=2)
	public void sort(){
		driver.navigate().to(Inventory.URL2);
		Inventory.clickList(driver);
	}
	
	@Test
	public void cLogInExcel(){
		File f = new File("data.xlsx"); // Ucitavanje fajla
		try {
			InputStream inp = new FileInputStream(f); // Citanje iz fajla
			XSSFWorkbook wb = new XSSFWorkbook(inp); // Pretvaranje fajla u odgovarajuci format
			Sheet sheet = wb.getSheetAt(0); // Dohvata sheet prvi tj NULTI
		
	SoftAssert as = new SoftAssert();
			
			for (int i=0; i<3; i++){
				
				Row row = sheet.getRow(i);
				Cell c1 =row.getCell(0);
				Cell c2 = row.getCell(1);
				String ime = c1.toString();
				String pass = c2.toString();
			driver.navigate().to(HomePage.URL);
			HomePage.clickUsername (driver, ime);	
			HomePage.clickPassword(driver, pass);
			HomePage.clickButton (driver);
				as.assertAll();
			wb.close();
		} 
		}
			catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		} 
	}
	

}
