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

public class ProfilePage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	
	public static By managefamilymembersbtn = By.xpath("//a[@href='/my-account']");
	public static By addnewbtn = By.xpath("//span[text()='Add New Profile']");
	public static By firstnameinput = By.xpath("//input[@placeholder='First Name']");
	public static By lastnameinput = By.xpath("//input[@placeholder='Last name']");
	public static By dobinput = By.xpath("//input[@placeholder='dd/mm/yyyy']");
	public static By relationdropdown = By.xpath("/html/body/main/div/div/div/div[2]/div/div[4]/div/div[2]/div[1]/div/div[3]/div/div");
	public static By emailinput = By.xpath("//input[@placeholder='name@email.com']");
	public static By savebtn = By.xpath("//span[text()='Save']");
	public static By confirmbtn = By.xpath("//span[text()='CONFIRM']");
	public static By okbtn = By.xpath("//span[text()='OK']");
	public static By profileclosebtn = By.xpath("//button[@title='Close']");
	public static By loginicon = By.xpath("//*[@id=\"loginPopup\"]/img");
	
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
		
		driver.findElement(loginicon).click();
		driver.findElement(managefamilymembersbtn).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Manage Family Member is clicked");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Manage Family Member is not clicked");
		}
	}
	public void click_on_add_new_profile() {
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addnewbtn)).click();
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
		WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameinput));
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
		driver.findElement(lastnameinput).sendKeys(lastname);
		 this.lastName = lastname; 
		 Reporter.generateReport(driver,extTest,Status.PASS,"Valid last name is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid last name is not accepted");
		}
	}
	public void entervaliddob(String dob) {
		try {
		driver.findElement(dobinput).sendKeys(dob);
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
		driver.findElement(relationdropdown).click();
		driver.findElement(By.xpath("//li[text()='"+relation+"']")).click();
		Reporter.generateReport(driver,extTest,Status.PASS,"Valid relation is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid relation is not accepted");
		}
	}
	public void entervalidemail(String email) {
		try {
			driver.findElement(emailinput).sendKeys(email);
			Reporter.generateReport(driver,extTest,Status.PASS,"Valid email is accepted");
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Valid email is not accepted");
		}
	}
	public void clicksaveandok() {
		try {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(savebtn)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmbtn)).click();
			wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(okbtn)).click();
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
			WebElement invalidfirstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameinput));
			invalidfirstNameInput.sendKeys(invalidfirstname);
			driver.findElement(lastnameinput).click();
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid first name is not accepted");
			driver.findElement(profileclosebtn).click();
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.PASS,"Invalid first name is accepted");
			}
		}
	public void enterinvalidlastname(String invalidlastname) {
		try {
			driver.findElement(lastnameinput).sendKeys(invalidlastname);
			driver.findElement(dobinput).click();
			 Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid last name is not accepted");
			 driver.findElement(profileclosebtn).click();
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.PASS,"Valid last name is accepted");
			}
	}
	public void enterinvaliddob(String invaliddob) {
		try {
			driver.findElement(dobinput).sendKeys(invaliddob);
			driver.findElement(emailinput).click();
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid dob is not accepted");
			
			driver.findElement(profileclosebtn).click();
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid dob is accepted");
			}
	}
	public void enterinvalidemail(String invalidemail) {
		try {
			driver.findElement(emailinput).sendKeys(invalidemail);
			driver.findElement(firstnameinput).click();
			Reporter.generateReport(driver,extTest,Status.FAIL,"Invalid email is not accepted");
			driver.findElement(profileclosebtn).click();
		}catch(TimeoutException te) {
			//fail the extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Invalid email is accepted");
		}
	}
	}

