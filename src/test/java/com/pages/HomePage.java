package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.setup.PropertyReader;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	Properties prop = PropertyReader.readProperties();
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void launchbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	public void openwebsite() {
		driver.get(prop.getProperty("URL"));
	}
	public boolean validatewebsite() {
		String expURL = "https://www.apollo247.com/";
		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(expURL, actUrl);
		return true ;
	
		
		
	}

}
