package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.pages.NotificationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetNotificationPreferencesSteps {
	NotificationPage notificationpage;

	public static WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	@Given("the user clicks on the Notification Preferences")
	public void the_user_clicks_on_the_notification_preferences() {
		notificationpage = new NotificationPage(driver, extTest);
	    notificationpage.clicknotificationprefereces();
	}
	@When("the user enables the Push Notification")
	public void the_user_enables_the_push_notification() {
		notificationpage.enablepushnotification();
	  
	}
	@Then("the push notification is enabled")
	public void the_push_notification_is_enabled() {
		notificationpage.verifypushenabled();
	   
	}
	
	@When("the user enables the SMS Notification")
	public void the_user_enables_the_sms_notification() {
		notificationpage.enablesmsnotification();
	   
	}
	@Then("the sms notification is enabled")
	public void the_sms_notification_is_enabled() {
		notificationpage.verifysmsenabled();
	    
	}

}
