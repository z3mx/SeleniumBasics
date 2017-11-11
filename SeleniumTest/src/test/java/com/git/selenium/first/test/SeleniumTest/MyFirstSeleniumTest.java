package com.git.selenium.first.test.SeleniumTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class MyFirstSeleniumTest {

	private final static String prefixUrl="http://";
	
	 private WebDriver driver;
	 private WebDriverWait wait;

	  @BeforeClass
	  public static void setupClass() {
	    FirefoxDriverManager.getInstance().setup();
	  }

	  @BeforeMethod
	public void setupTest() {
	    driver = new FirefoxDriver();
	    wait = new WebDriverWait(driver, 30);
	  }

	  @AfterMethod
	public void teardown() {
	    if (driver != null) {
	      driver.quit();
	    }
	  }
	@Test
	public void openFaceBookPage() {
		String url = prefixUrl+"localhost/jphp";
		
		//open browser
		driver.get(url);
		
		//load form login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login")));
		
		//
		WebElement email = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
//		WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement btnSubmit = driver.findElement(By.id("btnstart"));
		
		email.sendKeys("luis");
		password.sendKeys("3141516");
		btnSubmit.click();
		
		//
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contentMenu")));
//		WebElement btnMnuUno = driver.findElement(By.cssSelector("dropbtn"));
//		btnMnuUno.click();
		WebElement MnuUsuario = driver.findElement(By.xpath("//*[contains(text(), 'usuarios')]"));
		MnuUsuario.click();
		System.out.println("Terminando Ejcucion de Test");
	}
}
