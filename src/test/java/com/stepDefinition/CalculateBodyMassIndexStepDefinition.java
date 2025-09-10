package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HealthToolsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculateBodyMassIndexStepDefinition {
	public static WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	HealthToolsPage healthtoolspage;
	
	@When("the user click on View ALL in the Blogs and Articles section")
	public void the_user_click_on_view_all_in_the_blogs_and_articles_section() {
	   healthtoolspage = new HealthToolsPage(driver, extTest);
	   healthtoolspage.clickviewall();
	}
	@When("the user clicks on Health Tools")
	public void the_user_clicks_on_health_tools() {
		healthtoolspage.clickhealthTools();
	    
	}
	@When("the user clicks on Calculate under Body Mass Index")
	public void the_user_clicks_on_calculate_under_body_mass_index() {
		healthtoolspage.clickbmicalculate();
	    
	}
	@When("the user selects the gender as {string} and height as {string} and weight as {string}")
	public void the_user_selects_the_gender_as_and_height_as_and_weight_as(String string, String string2, String string3) {
	    
	}
	@When("the user selects the next icon without selecting a gender")
	public void the_user_selects_the_next_icon_without_selecting_a_gender() {
	    
	}
	@Then("verify Underweight is displayed")
	public void verify_underweight_is_displayed() {
	    
	}
	@Then("verify Normal is displayed")
	public void verify_normal_is_displayed() {
	   
	}
	@Then("verify Overweight is displayed")
	public void verify_overweight_is_displayed() {
	    
	}
	@Then("verify Obese is displayed")
	public void verify_obese_is_displayed() {
	    
	}
	@Then("verify BMI is displayed accurately")
	public void verify_bmi_is_displayed_accurately() {
	    
	}
	
	@Then("no BMI calculated")
	public void no_bmi_calculated() {
	    
	}
	@Then("Invalid height error message is shown")
	public void invalid_height_error_message_is_shown() {
	    
	}
	@Then("error message prompting user to enter values is shown")
	public void error_message_prompting_user_to_enter_values_is_shown() {
	    
	}

}
