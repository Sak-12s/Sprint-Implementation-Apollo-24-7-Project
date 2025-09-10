package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features/1_launchBrowser.feature",
		        "src/test/resources/Features/2_login.feature",
		        "src/test/resources/Features/3_profileAddition.feature",
		        "src/test/resources/Features/4_setNotificationPreferences.feature",
		        "src\\test\\resources\\Features\\5_weightMangement.feature"},
		glue = "com.stepDefinition",
		plugin = {"pretty", "html:reports/cucumber-html-report.html"},
		 tags = "not @Ignore"
		
		)


public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
