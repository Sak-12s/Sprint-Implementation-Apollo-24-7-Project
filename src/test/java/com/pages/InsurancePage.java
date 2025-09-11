package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reporter;

import objectrepository.Locators;

public class InsurancePage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	public InsurancePage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public void clickbuyinsurance() {
		try {
		driver.findElement(Locators.buyinsurancebtn).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Buy insurance is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Buy insurance is not clicked");
		}
	}
	public void clicklocation() {
	
		driver.findElement(Locators.locationdropdown).click();
	}
	public void enterinvalidpincode(String invalidpincode) {
		try {
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.CONTROL + "a");
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.BACK_SPACE);
		driver.findElement(Locators.pincodeinput).sendKeys(invalidpincode);
		driver.findElement(Locators.submitpincodebtn).click();
		Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid pincode is accepted");
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Invalid pincode is not accepted");
		}
	}
	public void enternegativepincode(String negativepincode) {
		try {
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.CONTROL + "a");
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.BACK_SPACE);
		driver.findElement(Locators.pincodeinput).sendKeys(negativepincode);
		driver.findElement(Locators.submitpincodebtn).click();
		Reporter.generateReport(driver,extTest,Status.FAIL,"Negative pincode is accepted");
		
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Negative is not accepted");
		}
	}
	public void enterzeropincode(String zeropincode) {
		try {
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.CONTROL + "a");
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.BACK_SPACE);
		driver.findElement(Locators.pincodeinput).sendKeys(zeropincode);
		driver.findElement(Locators.submitpincodebtn).click();
		Reporter.generateReport(driver,extTest,Status.FAIL,"Zero pincode is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Zero pincode is not accepted");
		}
	}
	public void entervalidpincode(String validpincode) {
		try {
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.CONTROL + "a");
		driver.findElement(Locators.pincodeinput).sendKeys(Keys.BACK_SPACE);
		driver.findElement(Locators.pincodeinput).sendKeys(validpincode);
		driver.findElement(Locators.submitpincodebtn).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid pincode is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid pincode is not accepted");
		}
	}
	public void clickviewplans() {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement viewPlansBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.viewplansbtn)
        );

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", viewPlansBtn);

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        viewPlansBtn.click();
        Reporter.generateReport(driver,extTest,Status.PASS,"View Plans is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"View Plans is not clicked");
		}
        
       
	}
	public void checkplansdisplayed() {
		try {
		driver.findElement(Locators.checkviewplans);
		Reporter.generateReport(driver,extTest,Status.PASS,"Plans are displayed");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Plans are not displayed");
		}
	}
	
}

