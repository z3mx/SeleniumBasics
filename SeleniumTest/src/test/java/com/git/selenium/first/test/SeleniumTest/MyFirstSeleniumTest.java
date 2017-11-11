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
		String url = prefixUrl+"localhost/projectName";
		
		//open browser
		driver.get(url);
		
		//ajax request
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".formulario")));
		
		//
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement btnSubmit = driver.findElement(By.id("btnstart"));
		
		email.sendKeys("ejemplo@dominio.com");
		password.sendKeys("123456");
		btnSubmit.click();
		
		System.out.println("Terminando Ejcucion de Test");
	}
}
