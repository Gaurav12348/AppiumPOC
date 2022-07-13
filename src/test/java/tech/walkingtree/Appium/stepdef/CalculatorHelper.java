package tech.walkingtree.Appium.stepdef;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tech.walkingtree.Appium.runner.TestRunner;
import tech.walkingtree.Appium.util.AppiumUtility;

public class CalculatorHelper {
	Logger log = Logger.getLogger(CalculatorHelper.class);

	String digit = "com.android.calculator2:id/digit_";
	String add = "com.android.calculator2:id/op_add";
	String equals = "com.android.calculator2:id/eq";
	String resultId = "com.android.calculator2:id/result";

	@Given("I have entered {string} into the calculator")
	public void i_have_entered_into_the_calculator1(String number) {
		for (int i = 0; i < number.length(); i++) {
			AppiumUtility.clickOnElement(AppiumUtility.findElementId(digit + number.charAt(i)));
		}
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%--- Type Number: " + number + " ---%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

	@And("I press add")
	public void i_press_add() {
		AppiumUtility.clickOnElement(AppiumUtility.findElementId(add));
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%--- Press Add Button ---%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

	@When("I press Equals")
	public void i_press_equals() {
		AppiumUtility.clickOnElement(AppiumUtility.findElementId(equals));
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%--- Press Equals Button ---%%%%%%%%%%%%%%%%%%%%%%%%%");

	}

	@Then("Result should be {string} on the screen")
	public void the_result_should_be_on_the_screen(String result) {
		String total = AppiumUtility.getTextOfElement(AppiumUtility.findElementId(resultId));
		Assert.assertEquals(result, total, "Mismatch Result");
		log.info("%%%%%%%%%%%%%%%%%%%%%%%%%--- Verify the Result ---%%%%%%%%%%%%%%%%%%%%%%%%%");

	}

}
