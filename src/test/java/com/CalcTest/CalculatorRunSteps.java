package com.CalcTest;
import org.hamcrest.Matchers;
import org.junit.Before;

import com.Calc.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CalculatorRunSteps {

    private int total;

    private Calculator calculator;

    @Before
    private void init() {
        total = -999;
    }

    @Given("^I have a calculator$")
    public void initializeCalculator() throws Throwable {
        calculator = new Calculator();
    }

    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void testAdd(int num1, int num2) throws Throwable {
        total = calculator.add(num1, num2);
    }

    @SuppressWarnings("deprecation")
	@Then("^the result should be (-?\\d+)$")
    public void validateResult(int result) throws Throwable {
    	Assert.assertEquals(total, (result));
    }
}