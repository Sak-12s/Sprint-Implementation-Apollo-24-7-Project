package com.pages;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.PropertyReader;
import com.setup.Reporter;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	
	public static By loginbtn = By.xpath("//*[@id=\"loginPopup\"]/div");
	public static By mobileinput = By.xpath("//input[@title='Please enter mobile number']");
	public static By continuebtn = By.xpath("//button[text()='Continue']");
	public static By otpinput = By.xpath("//input[@title='Please enter the otp']");
	public static By resendbtn = By.xpath("//span[text()='Resend OTP']");
	
	public static By verifybtn = By.xpath("//button[text()='Verify']");
	public static By loginicon = By.xpath("//*[@id=\"loginPopup\"]/img");
	public static By mobilefield = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/ul/li/div/div/div[2]/div[2]/div[2]/div/p[2]");
	public static By logoutbtn = By.xpath("//span[text()='Logout']");
	public static By invalidmobileerrormsg = By.xpath("//div[text()='This seems like a wrong number']");
	public static By closebtn = By.xpath("//span[@class='Rb']");
	public static By profileicon = By.xpath("//div[@title='Login/SignUp']");
	
	
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
		driver.findElement(loginbtn).click();
	}
	public void entervalidmobilenumber(String validmobile_no) {
		try {
		WebElement mobile = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileinput));
		mobile.click();
		validmobile_number=validmobile_no;
		mobile.sendKeys(validmobile_no);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();	
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
		            WebElement resendBtn = wait.until(ExpectedConditions.elementToBeClickable(resendbtn));
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
		        WebElement otp_input = wait.until(ExpectedConditions.visibilityOfElementLocated(otpinput));
		        otp_input.click();
		        otp_input.sendKeys(validotp);
		        driver.findElement(verifybtn).click();

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
		 wait.until(ExpectedConditions.visibilityOfElementLocated(loginicon)).click();
		 WebElement mobiledisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(mobilefield));

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
		WebElement invalidmobile = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileinput));
		invalidmobile.click();
		invalidmobile_number=invalidmobile_no;
		invalidmobile.sendKeys(invalidmobile_no);
		String errmsg = driver.findElement(invalidmobileerrormsg).getText();
		Reporter.generateReport(driver,extTest,Status.PASS,errmsg);
		driver.findElement(closebtn).click();
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid mobile number accepted");
		}
		
	}
	public void enterinvalidotp() {
		try {
		System.out.println("Enter the otp received: ");
		invalidotp = sc.next();
		WebElement invalidotp_input = wait.until(ExpectedConditions.visibilityOfElementLocated(otpinput));
		invalidotp_input.click();
        invalidotp_input.sendKeys(invalidotp);
		driver.findElement(verifybtn).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Invalid otp number is not accepted");
		driver.findElement(closebtn).click();
		}
		catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid otp number is acccepted");
			driver.findElement(closebtn).click();
		}
	}
	public void clickprofileicon() {
		try {
		
		    String mainWindow = driver.getWindowHandles().iterator().next(); // first opened window
		    driver.switchTo().window(mainWindow);
		

		 driver.findElement(profileicon).click();
		 Reporter.generateReport(driver,extTest,Status.PASS,"Profile icon is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Profile icon is not clicked");
		}
	}
	public void clicklogout() {
		try {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(logoutbtn)).click();
		 Reporter.generateReport(driver,extTest,Status.PASS,"Logout is clicked");
		}
	catch(TimeoutException te) {
		//fail the extent report
		Reporter.generateReport(driver,extTest,Status.FAIL,"Logout is not clicked");
	}
	}
	public void checklogout() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn));
		Reporter.generateReport(driver,extTest,Status.PASS,"User is logged out");
		}
	catch(TimeoutException te) {
		//fail the extent report
		Reporter.generateReport(driver,extTest,Status.FAIL,"User is not logged out");
	}
	}
	
	
	

}
