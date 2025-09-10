package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import objectrepository.Locators;

public class HealthToolsPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	public HealthToolsPage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	public void clickviewall() {
		driver.navigate().back();
		driver.navigate().back();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.homebtn)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.blogviewall));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -150);", element);
		element.click();

	}
	public void clickhealthTools() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.healthtoolsbtn)).click();
	}
	public void clickbmicalculate() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // --- Switch to the new tab opened after Health Tools click ---
	    String currentWindow = driver.getWindowHandle();
	    for (String windowHandle : driver.getWindowHandles()) {
	        if (!windowHandle.equals(currentWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // --- Wait for the page to reload completely ---
	    wait.until(webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete"));

	    // --- Locate the Calculate button ---
	    WebElement calculateBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(Locators.bmicalculatebtn)
	    );

	    // --- Scroll into view ---
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calculateBtn);

	    // --- Click (with fallback to JS click) ---
	    try {
	        calculateBtn.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calculateBtn);
	    }
	}

}
		   
		
		



