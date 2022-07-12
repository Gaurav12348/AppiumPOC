package tech.walkingtree.Appium.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/tech/walkingtree/Appium/feature/" }, glue = {
		"src.test.java.tech.walkingtree.Appium.stepdef", "src.test.java.tech.walkingtree.Appium.util" })

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- BeforeSuite");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- AfterSuite");
	}

	@BeforeTest
	public void BeforeTest() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- BeforeTest");
	}

	@BeforeClass
	public void BeforeClass() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- BeforeClass");
	}

	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- BeforeMethod");
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- AfterMethod");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- AfterClass");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%--- AfterTest");
	}

}