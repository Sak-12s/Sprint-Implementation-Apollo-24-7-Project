package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pages.InsurancePage;
import com.parameters.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewingPremiumInsuranceSteps {
	InsurancePage insurancepage;
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	static String[][] excelData;	
	WebDriverWait wait;
	 public ViewingPremiumInsuranceSteps() {
	     
	        this.insurancepage = new InsurancePage(driver,extTest);
	        if (excelData == null) {
	            excelData = ExcelReader.readData(); // load Excel data once
	        }  
	    }
	@Given("the user clicks on Buy Insurance")
	public void the_user_clicks_on_buy_insurance() {
	   insurancepage.clickbuyinsurance();
	}
	@When("the user clicks on location")
	public void the_user_clicks_on_location() {
		insurancepage.clicklocation();
	    
	}
	@When("the user enters invalid pincode as {string} in the location")
	public void the_user_enters_invalid_pincode_as_in_the_location(String invalidpincode) {
		int row=Hooks.firstRow;
		invalidpincode = excelData[row][9];
	    insurancepage.enterinvalidpincode(invalidpincode);
	}
	@When("the user enters negative value as {string} for pincode in the location")
	public void the_user_enters_negative_value_as_for_pincode_in_the_location(String negativepincode) {
		int row=Hooks.secondRow;
		negativepincode = excelData[row][9];
		insurancepage.clicklocation();
		insurancepage.enternegativepincode(negativepincode);
	    
	}
	@When("the user enters zero value as {string} for pincode in the location")
	public void the_user_enters_zero_value_as_for_pincode_in_the_location(String zeropincode) {
		int row=Hooks.thirdRow;
		zeropincode = excelData[row][9];
		insurancepage.clicklocation();
		insurancepage.enterzeropincode(zeropincode);
	}
	@When("the user enters valid value as {string} for the pincode in the location")
	public void the_user_enters_valid_value_as_for_the_pincode_in_the_location(String validpincode) {
		int row=Hooks.fourthRow;
		validpincode = excelData[row][9];
		insurancepage.clicklocation();
		insurancepage.entervalidpincode(validpincode);
	}
	@Then("the user view the plans")
	public void the_user_view_the_plans() {
	    insurancepage.clickviewplans();
	}


}
