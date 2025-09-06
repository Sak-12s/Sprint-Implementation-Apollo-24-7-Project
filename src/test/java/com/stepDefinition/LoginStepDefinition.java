package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	HomePage homepage;
	WebDriver driver = Hooks.driver;
	
	WebDriverWait wait;
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
		homepage = new HomePage(driver); 
	    homepage.openwebsite();
	    homepage.validatewebsite();
	    
	}
	@When("the user clicks on login icon")
	public void the_user_clicks_on_login_icon() {
	
	homepage.clicklogin();
		
	    
	}
	@When("the user enters valid mobile number")
	public void the_user_enters_valid_mobile_number() {
		homepage.entermobilenumber();
	}
	@When("the user enters valid otp")
	public void the_user_enters_valid_otp() {
		
		homepage.enterotp();
	    
	}
	@Then("the user is logged in")
	public void the_user_is_logged_in() {
		
		homepage.loggedin();
	    
	}


}
