package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pages.BodyMassIndexPage;
import com.parameters.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BodyMassIndexStepDefinition {
	BodyMassIndexPage bodymassindexpage;
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	static String[][] excelData;	
	WebDriverWait wait;
	 public BodyMassIndexStepDefinition() {
	     
	        this.bodymassindexpage = new BodyMassIndexPage(driver,extTest);
	    }
	@Given("the user selects on weight management in home page")
	public void the_user_selects_on_weight_management_in_home_page() {
	    
	    bodymassindexpage.clickweightmanagement();
	    
	    if (excelData == null) {
            excelData = ExcelReader.readData(); // load Excel data once
        }  
	}
	@When("the user clicks on BMI meter")
	public void the_user_clicks_on_bmi_meter() {
	    
	}
	@When("the user clicks on submit without any input")
	public void the_user_clicks_on_submit_without_any_input() {
		bodymassindexpage.clickcalculatenowbtn();
	    
	}
	@When("the user enters negative height as {string} and weight as {string}")
	public void the_user_enters_negative_height_as_and_weight_as(String negativeheight, String weight) {
		int row=Hooks.firstRow;
		negativeheight=excelData[row][7];
		weight = excelData[row][8];
		bodymassindexpage.invalidinputs(negativeheight, weight);
	    
	}
	@When("the user enters height as {string} and zero weight as {string}")
	public void the_user_enters_height_as_and_zero_weight_as(String height, String zeroweight) {
		int row=Hooks.secondRow;
		height=excelData[row][7];
		zeroweight = excelData[row][8];
		bodymassindexpage.invalidinputs(height, zeroweight);
	    
	}
	@When("the user enters excessively large height as {string} and excessively large weight as {string}")
	public void the_user_enters_excessively_large_height_as_and_excessively_large_weight_as(String largeheight, String largeweight) {
		int row=Hooks.thirdRow;
		largeheight=excelData[row][7];
		largeweight = excelData[row][8];
		bodymassindexpage.invalidinputs(largeheight, largeweight);
	    
	}
	@When("the user enters valid height as {string} and valid weight as {string}")
	public void the_user_enters_valid_height_as_and_valid_weight_as(String height, String weight) {
		int row=Hooks.fourthRow;
		height=excelData[row][7];
		weight = excelData[row][8];
		bodymassindexpage.validinputs(height, weight);
	}

	@When("the user enters decimal height as {string} and decimal weight as {string}")
	public void the_user_enters_decimal_height_as_and_decimal_weight_as(String decimalheight, String decimalweight) {
		int row=Hooks.fifthRow;
		decimalheight=excelData[row][7];
		decimalweight = excelData[row][8];
		bodymassindexpage.validinputs(decimalheight, decimalweight);
		bodymassindexpage.backtohomepage();
	}

}
