package com.pages;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.setup.PropertyReader;

import objectrepository.Locators;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	String mobile_no;
	String otp;
	Scanner sc = new Scanner(System.in);
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
	public void clicklogin() {
		driver.findElement(Locators.loginbtn).click();
	}
	public void entermobilenumber() {
		WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobileinput));
		mobile.click();
		//wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		
		System.out.println("Enter the mobile number: ");
		mobile_no = sc.next();
		mobile.sendKeys(mobile_no);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebtn)).click();
		
		//wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		
	}
	public void enterotp() {
		
		System.out.println("Enter the otp received: ");
		otp = sc.next();
		WebElement otp_input = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otpinput));
		otp_input.click();
        otp_input.sendKeys(otp);
		driver.findElement(Locators.verifybtn).click();
		sc.close();
	}
	public void loggedin() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginicon)).click();;
		 WebElement mobiledisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilefield));

		 String actualMobile = mobiledisplayed.getText().replace("+91", "").trim();
		 Assert.assertEquals(actualMobile, mobile_no, "Login verification failed!");
	}

}
