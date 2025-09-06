package com.stepDefinition;

import com.setup.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class Hooks extends Base {
	
	
	
	
	@BeforeAll
	public static void beforeAll() {
		
		
	}
	
	@AfterAll
	public static void afterAll() {
		
	}
	
	@Before
	public void before(Scenario scenario) {
		launchBrowser();
		
		
	}
	
	@After
	public void after() {
		Base.sleep();
		
	}
	
	@BeforeStep
	public void beforeStem() {
		
		
	}
	
	@AfterStep
	public void afterStep() {
		
	}

}
