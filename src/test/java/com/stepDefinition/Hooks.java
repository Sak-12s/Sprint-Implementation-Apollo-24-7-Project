package com.stepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class Hooks extends Base {
	
	static ExtentSparkReporter spark;
	static ExtentReports extReports;
	static ExtentTest extTest;
	
	public static int firstRow = 0;
	public static int secondRow = 1;
	public static int thirdRow = 2;
	public static int fourthRow = 3;
	public static int fifthRow = 4;
	public static int sixthRow = 5;
	public static int seventhRow = 6;
	
	@BeforeAll
	public static void beforeAll() {
		spark = new ExtentSparkReporter("reports/ExtendReport.html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
		launchBrowser();
	}
	
	@AfterAll
	public static void afterAll() {
		
		extReports.flush();
		driver.quit();
	}
	
	@Before
	public void before(Scenario scenario) {
		extTest = extReports.createTest(scenario.getName());
			
	}
	
	@After
	public void after() {
		//currentRow++;
		
		
	}
	
	@BeforeStep
	public void beforeStem() {
		
		
	}
	
	@AfterStep
	public void afterStep() {
		
	}

}
