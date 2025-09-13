package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class BodyMassIndexPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	String originalWindow;
	
	public static By homebtn = By.xpath("//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[1]/div/a/img");
	public static By weightmanagement = By.xpath("//a[text()='Weight Management']");
	public static By bmimeter = By.xpath("//li[@class='nav-item'][4]");
	public static By heightinput = By.xpath("//input[@id='height']");
	public static By weightinput = By.xpath("//input[@id='weight']");
	public static By calculatebtn = By.id("calculateBMI");
	public static By invaliderrmsg = By.xpath("//p[text()='Please enter valid height and weight']");
	public static By bmivalue = By.id("bmiValue");
	
	public BodyMassIndexPage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public void clickweightmanagement() {
		
		    driver.navigate().back();
		    driver.navigate().back();
		    
	
		driver.findElement(homebtn).click();

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean elementFound = false;
	    originalWindow = driver.getWindowHandle();
	    

	    while (!elementFound) {
	        try {
	            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(weightmanagement));
	            js.executeScript("arguments[0].scrollIntoView(true);", element);
	            element.click(); // click Weight Management
	            elementFound = true;

	            // ✅ Switch to new tab after click
	            for (String windowHandle : driver.getWindowHandles()) {
	                if (!windowHandle.equals(originalWindow)) {
	                    driver.switchTo().window(windowHandle);
	                    break;
	                }
	            }

	            Reporter.generateReport(driver, extTest, Status.PASS, "Weight management option found, clicked and switched to new tab");
	        } catch (TimeoutException e) {
	            js.executeScript("window.scrollBy(0, 400);"); // scroll step by step
	        }
	    }
	}	
	public void clickcalculatenowbtn() {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean isVisible = false;

	    while (!isVisible) {
	        try {
	            WebElement calculateBtn = driver.findElement(calculatebtn);

	            // Check if element is displayed in viewport
	            boolean inViewport = (boolean) js.executeScript(
	                "var rect = arguments[0].getBoundingClientRect();" +
	                "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",
	                calculateBtn
	            );

	            if (calculateBtn.isDisplayed() && inViewport) {
	                // Scroll so button is visible with extra space for error message
	                js.executeScript("arguments[0].scrollIntoView(true);", calculateBtn);
	                js.executeScript("window.scrollBy(0, 150);"); // leave room below for error message
	                isVisible = true;
	                driver.findElement(calculatebtn).click();
	    	        String expt_errmsg = "Please enter valid height and weight";
	    			String act_errmsg = driver.findElement(invaliderrmsg).getText();
	    			if(expt_errmsg.equals(act_errmsg)) {
	    	        Reporter.generateReport(driver,extTest,Status.PASS,"Empty inputs are not accepted");
	    			}
	                
	            }else {
	                // Scroll down step by step until found
	                js.executeScript("window.scrollBy(0, 300);");
	                Thread.sleep(500);
	            }
	        } catch (Exception e) {
	            // Keep scrolling if element not found yet
	            js.executeScript("window.scrollBy(0, 300);");
	            try { Thread.sleep(500); } catch (InterruptedException ex) {}
	            Reporter.generateReport(driver,extTest,Status.FAIL,"Empty inputs are accepted");
	        }
	       
			}
	    
		}
	public void invalidinputs(String height,String weight) {
		try {
			
			driver.findElement(heightinput).sendKeys(Keys.CONTROL + "a");
			driver.findElement(heightinput).sendKeys(Keys.BACK_SPACE);
		driver.findElement(heightinput).sendKeys(height);
		driver.findElement(weightinput).sendKeys(Keys.CONTROL + "a");
		driver.findElement(weightinput).sendKeys(Keys.BACK_SPACE);
		driver.findElement(weightinput).sendKeys(weight);
		driver.findElement(calculatebtn).click();
		String expt_errmsg = "Please enter valid height and weight";
		String act_errmsg = driver.findElement(invaliderrmsg).getText();
		if (expt_errmsg.equals(act_errmsg)) {
            Reporter.generateReport(driver, extTest, Status.PASS, "Invalid inputs are not accepted");
        } else {
            String act_bmi = driver.findElement(bmivalue).getText();
            double bmi_no = Double.parseDouble(act_bmi);

            if (bmi_no == 0.0) {
                Reporter.generateReport(driver, extTest, Status.PASS, "Invalid inputs are accepted and wrong BMI is calculated (0.0)");
            }
		}
		}
		catch(TimeoutException te) {
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid inputs are accepted");
		}
	}
	public void validinputs(String height,String weight) {
		try {
			driver.findElement(heightinput).sendKeys(Keys.CONTROL + "a");
			driver.findElement(heightinput).sendKeys(Keys.BACK_SPACE);
			driver.findElement(heightinput).sendKeys(height);
			driver.findElement(weightinput).sendKeys(Keys.CONTROL + "a");
			driver.findElement(weightinput).sendKeys(Keys.BACK_SPACE);
			driver.findElement(weightinput).sendKeys(weight);
			driver.findElement(calculatebtn).click();
			String act_bmi = driver.findElement(bmivalue).getText();
			double bmi_no = Double.parseDouble(act_bmi);
			if(bmi_no>0.0) {
			Reporter.generateReport(driver,extTest,Status.PASS,"Valid inputs are accepted");
			}
			}
			catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Valid inputs are not accepted");
			}
		
	}
	public void backtohomepage() {
		driver.close();
		
	}

}
