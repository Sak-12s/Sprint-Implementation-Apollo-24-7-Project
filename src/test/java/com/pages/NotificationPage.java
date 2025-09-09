package com.pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

import objectrepository.Locators;

public class NotificationPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	
	
	
	public NotificationPage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public void clicknotificationprefereces() {
		try {
		driver.findElement(Locators.notificationpreferencesbtn).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Notification Preferences is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Notification Preferences is not clicked");
		}
	}
	public void enablepushnotification() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.pushnotification)).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Push notification is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Push notification is not clicked");
		}
	}
	public void verifypushenabled() {
	
		
		 WebElement pushToggle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.pushnotification));
	        boolean isEnabled = pushToggle.isSelected() || pushToggle.getAttribute("checked") != null;

	        if (isEnabled) {
	            extTest.pass("Push Notification is successfully enabled");
	            Reporter.generateReport(driver,extTest,Status.PASS,"Push notification is enabled");
	        } else {
	            extTest.fail("Push Notification is not enabled");
	            Reporter.generateReport(driver,extTest,Status.FAIL,"Push notification is not enabled");
	        }

	        Assert.assertTrue(isEnabled, "Push Notification should be enabled but it is not");
	        
	}
	public void enablesmsnotification() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.smsnotification)).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"SMS notification is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"SMS notification is not clicked");
		}
	}
	public void verifysmsenabled() {
	
		WebElement smsToggle = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.smsnotification));
        boolean isEnabled = smsToggle.isSelected() || smsToggle.getAttribute("checked") != null;

        if (isEnabled) {
            extTest.pass("SMS Notification is successfully enabled");
            Reporter.generateReport(driver,extTest,Status.PASS,"SMS notification is enabled");
        } else {
            extTest.fail("SMS Notification is not enabled");
            Reporter.generateReport(driver,extTest,Status.FAIL,"SMS notification is not enabled");
        }

        Assert.assertTrue(isEnabled, "SMS Notification should be enabled but it is not.");
        
		
	}
	}


