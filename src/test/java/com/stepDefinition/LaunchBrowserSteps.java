package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchBrowserSteps {
	HomePage homepage;

	public static WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	
	
	@Given("the user launches the browser")
	public void the_user_launches_the_browser() {
		homepage = new HomePage(driver, extTest); 
	    System.out.println("Browser launched using Hooks initialization");
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
