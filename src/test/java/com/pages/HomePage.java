package com.pages;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.setup.PropertyReader;
import com.setup.Reporter;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.TimeoutException;

import objectrepository.Locators;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	String validmobile_number;
	String validotp;
	String invalidmobile_number;
	String invalidotp;
	Scanner sc = new Scanner(System.in);
	Properties prop = PropertyReader.readProperties();
	public HomePage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public void openwebsite() {
		try {
		driver.get(prop.getProperty("URL"));
		Reporter.generateReport(driver,extTest,Status.PASS," Apollo 24/7 Website Opened");
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Apollo 24/7 Website not opened");
		}
	}
	public boolean validatewebsite() {
		try {
		String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue(currentUrl.contains("apollo247"), 
	        "Expected Apollo URL but found: " + currentUrl);
	    Reporter.generateReport(driver,extTest,Status.PASS,"Correct Apollo 24/7 is Website Opened");
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Incorrect Website Opened");
		}
		return true ;
	}
	public void clicklogin() {
		driver.findElement(Locators.loginbtn).click();
	}
	public void entervalidmobilenumber(String validmobile_no) {
		try {
		WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobileinput));
		mobile.click();
		validmobile_number=validmobile_no;
		mobile.sendKeys(validmobile_no);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebtn)).click();	
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid mobile number is accepted");
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid mobile number is not acccepted");
		}
		
		
	}
	public void entervalidotp() {
		
		    try {
		        System.out.println("Enter the OTP received (you have 40 seconds): ");
		        String userInput = waitForConsoleInput(40);  // first 40s

		        if (userInput == null || userInput.isEmpty()) {
		            // No OTP typed in console → click resend
		            WebElement resendBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.resendbtn));
		            resendBtn.click();
		            Reporter.generateReport(driver, extTest, Status.INFO, "No OTP entered in 40s. Resend OTP clicked.");

		            // ✅ wait again for OTP after resend
		            System.out.println("Enter the OTP received after resend (you have 40 seconds): ");
		            userInput = waitForConsoleInput(40);
		        }

		        if (userInput == null || userInput.isEmpty()) {
		            Reporter.generateReport(driver, extTest, Status.FAIL, "No OTP entered even after resend.");
		            return;
		        }

		        // ✅ send OTP to webpage
		        validotp = userInput;
		        WebElement otp_input = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otpinput));
		        otp_input.click();
		        otp_input.sendKeys(validotp);
		        driver.findElement(Locators.verifybtn).click();

		        Reporter.generateReport(driver, extTest, Status.PASS, "Valid OTP entered and verified");

		    } catch (TimeoutException te) {
		        Reporter.generateReport(driver, extTest, Status.FAIL, "OTP input field not available");
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		/**
		 * Utility method: waits for console input for given seconds.
		 */
		private String waitForConsoleInput(int seconds) throws Exception {
		    long startTime = System.currentTimeMillis();
		    String input = null;

		    while ((System.currentTimeMillis() - startTime) < seconds * 1000L) {
		        if (System.in.available() > 0) {
		            input = sc.nextLine().trim();
		            if (!input.isEmpty()) {
		                break;
		            }
		        }
		        Thread.sleep(500); // check every 0.5s
		    }
		    return input;
		}
	public void loggedin() {
		try {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginicon)).click();;
		 WebElement mobiledisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilefield));

		 String actualMobile = mobiledisplayed.getText().replace("+91", "").trim();
		 Assert.assertEquals(actualMobile, validmobile_number, "Login verification failed!");
		 Reporter.generateReport(driver,extTest,Status.PASS,"User log in success");
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"User log in failed");
		}
	}
	public void enterinvalidmobile_no(String invalidmobile_no) {
		try {
		WebElement invalidmobile = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobileinput));
		invalidmobile.click();
		invalidmobile_number=invalidmobile_no;
		invalidmobile.sendKeys(invalidmobile_no);
		String errmsg = driver.findElement(Locators.invalidmobileerrormsg).getText();
		Reporter.generateReport(driver,extTest,Status.FAIL,errmsg);
		driver.findElement(Locators.closebtn).click();
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Invalid mobile number accepted");
		}
		
	}
	public void enterinvalidotp() {
		try {
		System.out.println("Enter the otp received: ");
		invalidotp = sc.next();
		WebElement invalidotp_input = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otpinput));
		invalidotp_input.click();
        invalidotp_input.sendKeys(invalidotp);
		driver.findElement(Locators.verifybtn).click();
		Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid otp number is not accepted");
		driver.findElement(Locators.closebtn).click();
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Invalid otp number is acccepted");
			driver.findElement(Locators.closebtn).click();
		}
	}
	
	
	

}
