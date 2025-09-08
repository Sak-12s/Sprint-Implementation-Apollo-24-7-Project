package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;
import com.parameters.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	HomePage homepage;
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	static String[][] excelData;	
	WebDriverWait wait;
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		homepage = new HomePage(driver, extTest); 
	    //homepage.openwebsite();
	    homepage.validatewebsite();
	    
	    if (excelData == null) {
            excelData = ExcelReader.readData(); // load Excel data once
        }  
	}
	@When("the user clicks on login icon")
	public void the_user_clicks_on_login_icon() {
		homepage.clicklogin();   
	}
	@When("the user enters valid mobile number as {string}")
	public void the_user_enters_valid_mobile_number_as(String validmobile_no) {
		int row = Hooks.firstRow;
		validmobile_no = excelData[row][0]; 
	    homepage.entervalidmobilenumber(validmobile_no);
	}
	@When("the user enters valid otp")
	public void the_user_enters_valid_otp() {
		homepage.entervalidotp(); 
	}
	@Then("the user is logged in")
	public void the_user_is_logged_in() {
		homepage.loggedin(); 
	}
	@When("the user enters invalid mobile number as {string}")
	public void the_user_enters_invalid_mobile_number_as(String invalidmobile_no ) {
		int row = Hooks.secondRow;
		invalidmobile_no = excelData[row][0]; 
		homepage.enterinvalidmobile_no(invalidmobile_no);
		
	    
	}
	@Then("an error message is displayed {string}")
	public void an_error_message_is_displayed(String string) {
	    
	}
	@When("the user enters invalid otp")
	public void the_user_enters_invalid_otp() {
	    homepage.enterinvalidotp();
	   
	}


}
