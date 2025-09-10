package com.pages;

import java.time.Duration;
import java.util.Properties;

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

import objectrepository.Locators;

public class ProfilePage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	String firstName;
	String lastName;
	Properties prop = PropertyReader.readProperties();
	public ProfilePage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	
	public void click_on_manage_family_member() {
		try {
		
		driver.findElement(Locators.loginicon).click();
		driver.findElement(Locators.managefamilymembersbtn).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Manage Family Member is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Manage Family Member is not clicked");
		}
	}
	public void click_on_add_new_profile() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.addnewbtn)).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Add New Profile is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Add New Profile is not clicked");
		}
		
	}
	public void entervalidfirstname(String firstname) {
		try {
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstnameinput));
		firstNameInput.sendKeys(firstname);
		this.firstName = firstname; 
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid first name is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid first name is not accepted");
		}
	}
	public void entervalidlastname(String lastname) {
		try {
		driver.findElement(Locators.lastnameinput).sendKeys(lastname);
		 this.lastName = lastname; 
		 Reporter.generateReport(driver,extTest,Status.PASS,"Valid last name is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid last name is not accepted");
		}
	}
	public void entervaliddob(String dob) {
		try {
		driver.findElement(Locators.dobinput).sendKeys(dob);
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid dob is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid dob is not accepted");
		}
	}
	public void selectgender(String gender) {
		try {
		driver.findElement(By.xpath("//span[text()='"+gender+"']")).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid gender is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid gender is not accepted");
		}
	}
	public void selectrelation(String relation) {
		try {
		driver.findElement(Locators.relationdropdown).click();
		driver.findElement(By.xpath("//li[text()='"+relation+"']")).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid relation is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid relation is not accepted");
		}
	}
	public void entervalidemail(String email) {
		try {
			driver.findElement(Locators.emailinput).sendKeys(email);
			Reporter.generateReport(driver,extTest,Status.PASS,"Valid email is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid email is not accepted");
		}
	}
	public void clicksaveandok() {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.savebtn)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.confirmbtn)).click();
			wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.okbtn)).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Save,Confirm and OK button is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Save,Confirm and OK button is not clicked");
		}
	}
	public void verifynewprofile() {
		try {
		System.out.println(firstName+ " "+lastName);
		String firstnamedisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '"+firstName+"')]"))).getText();
		Assert.assertEquals(firstnamedisplayed, firstName+" "+lastName);
		Reporter.generateReport(driver,extTest,Status.PASS,"New Profile is added");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"New Profile is not added");
		}
		
	}
	public void enterinvalidfirstname(String invalidfirstname) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement invalidfirstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstnameinput));
			invalidfirstNameInput.sendKeys(invalidfirstname);
			driver.findElement(Locators.lastnameinput).click();
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid first name is not accepted");
			driver.findElement(Locators.profileclosebtn).click();
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.PASS,"Invalid first name is accepted");
			}
		}
	public void enterinvalidlastname(String invalidlastname) {
		try {
			driver.findElement(Locators.lastnameinput).sendKeys(invalidlastname);
			driver.findElement(Locators.dobinput).click();
			 Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid last name is not accepted");
			 driver.findElement(Locators.profileclosebtn).click();
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.PASS,"Valid last name is accepted");
			}
	}
	public void enterinvaliddob(String invaliddob) {
		try {
			driver.findElement(Locators.dobinput).sendKeys(invaliddob);
			driver.findElement(Locators.emailinput).click();
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid dob is not accepted");
			
			driver.findElement(Locators.profileclosebtn).click();
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid dob is accepted");
			}
	}
	public void enterinvalidemail(String invalidemail) {
		try {
			driver.findElement(Locators.emailinput).sendKeys(invalidemail);
			driver.findElement(Locators.firstnameinput).click();
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid email is not accepted");
			driver.findElement(Locators.profileclosebtn).click();
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Invalid email is accepted");
		}
	}
	}

