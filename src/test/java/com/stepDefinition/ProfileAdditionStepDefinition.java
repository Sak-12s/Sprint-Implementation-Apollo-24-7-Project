package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.pages.ProfilePage;
import com.parameters.ExcelReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileAdditionStepDefinition {
	ProfilePage profilepage;
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	static String[][] excelData;	
	WebDriverWait wait;
	@When("the user clicks on the manage family members")
	public void the_user_clicks_on_the_manage_family_members() {
		profilepage = new ProfilePage(driver,extTest);
		profilepage.click_on_manage_family_member();
		  if (excelData == null) {
	            excelData = ExcelReader.readData(); // load Excel data once
	        }  
	    
	}
	@When("the user clicks on add new profile")
	public void the_user_clicks_on_add_new_profile() {
	    profilepage.click_on_add_new_profile();
	}
	@When("the user enters the first name as {string}")
	public void the_user_enters_the_first_name_as(String firstname) {
		int row = Hooks.currentRow;
		firstname = excelData[row][1]; 
		System.out.println(firstname);
		if (firstname != null && !firstname.isEmpty()) {
		profilepage.entervalidfirstname(firstname);
		}
	    
	}
	@When("the user enters the last name as {string}")
	public void the_user_enters_the_last_name_as(String lastname) {
		int row = Hooks.currentRow;
		if (lastname != null && !lastname.isEmpty()) {
		lastname = excelData[row][2]; 
		}
		profilepage.entervalidlastname(lastname);
	    
	}
	@When("the user enters the dob as {string}")
	public void the_user_enters_the_dob_as(String dob) {
		int row = Hooks.currentRow;
		dob = excelData[row][3];
		profilepage.entervaliddob(dob);
	    
	}
	@When("the user choose the gender as {string}")
	public void the_user_choose_the_gender_as(String gender) {
		int row = Hooks.currentRow;
		gender = excelData[row][4];
		profilepage.selectgender(gender);
	}
	@When("the user choose the relation as {string}")
	public void the_user_choose_the_relation_as(String relation) {
		int row = Hooks.currentRow;
		relation = excelData[row][5];
		profilepage.selectrelation(relation);
	    
	}
	@When("the user clicks on save and ok button")
	public void the_user_clicks_on_save_and_ok_button() {
		profilepage.clicksaveandok();
	    
	}
	@Then("the new profile is added successfully")
	public void the_new_profile_is_added_successfully() {
		profilepage.verifynewprofile();
	    
	}


}
