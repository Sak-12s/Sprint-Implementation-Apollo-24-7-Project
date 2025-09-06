package com.setup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	static final int TIME = 2000;
	public static WebDriver driver;
	
	public void launchBrowser() {
		Properties prop = PropertyReader.readProperties();
		
		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			
			ChromeOptions options = new ChromeOptions();

	      
	        options.addArguments("--disable-notifications");   // disables popup
	       
	        options.setExperimentalOption("prefs", 
	            java.util.Map.of("profile.default_content_setting_values.notifications", 2) // 1 = Allow, 2 = Block
	        );

	       
	        driver = new ChromeDriver(options);
			 driver.manage().window().maximize();
		}
		else if((prop.getProperty("Browser").equalsIgnoreCase("Firefox"))){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		driver.get(prop.getProperty("URL"));
		
	}
	public static void sleep() {
		try {
			Thread.sleep(TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
