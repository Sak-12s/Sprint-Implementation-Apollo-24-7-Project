package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchBrowserStepDefinition {
	HomePage homepage;
	WebDriver driver;
	
	
	@Given("the user launches the browser")
	public void the_user_launches_the_browser() {
		homepage = new HomePage(driver); 
	    homepage.launchbrowser();
	}
	@When("the user opens the apollo website")
	public void the_user_opens_the_apollo_website() {
		
		homepage.openwebsite();
	    
	}
	@Then("the apollo website is launched successfully")
	public void the_apollo_website_is_launched_successfully() {
		
		homepage.validatewebsite();
	    
	}


}
