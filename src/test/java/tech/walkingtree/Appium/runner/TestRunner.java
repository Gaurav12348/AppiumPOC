package tech.walkingtree.Appium.runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import tech.walkingtree.Appium.util.AppiumUtility;

@CucumberOptions(features = { "src/test/java/tech/walkingtree/Appium/feature/" }, glue = {
		"tech.walkingtree.Appium.stepdef" }, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	Logger log = Logger.getLogger(TestRunner.class);

	@BeforeSuite
	public void BeforeSuite() {
		AppiumUtility.startServer();
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%--- BeforeSuite ---%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

	@AfterSuite
	public void AfterSuite() {
		AppiumUtility.stopServer();
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%--- AfterSuite ---%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

}