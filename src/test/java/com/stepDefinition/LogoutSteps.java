package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	
	HomePage homepage;
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	static String[][] excelData;	
	WebDriverWait wait;
	@When("the user clicks on the profile icon")
	public void the_user_clicks_on_the_profile_icon() {
		homepage = new HomePage(driver, extTest); 
	    homepage.clickprofileicon();
	}
	@When("the user clicks on logout")
	public void the_user_clicks_on_logout() {
		homepage.clicklogout();
	    
	}
	@Then("the user is logged out")
	public void the_user_is_logged_out() {
	    
	}

}
