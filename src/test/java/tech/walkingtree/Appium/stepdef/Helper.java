package tech.walkingtree.Appium.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tech.walkingtree.Appium.util.AppiumUtility;



public class Helper {
	@FindBy(how = How.ID, using = "foobar") 
	WebElement equals;
//	@Given("I have entered <Second>,<First> into the calculator")
//	public void i_have_entered_into_the_calculator(int number) {
//	
//	}

	@When("I press add")
	public void i_press_add() {

	}

	@Then("Result should be {int} on the screen")
	public void the_result_should_be_on_the_screen(int result) {

	}

	@Given("I have entered {int} into the calculator")
	public void i_have_entered_into_the_calculator(int number) {
	}

	@When("I press Equals")
	public void i_press_equals() {
		AppiumUtility.touchOnElement(By.id(""));
	}

}
