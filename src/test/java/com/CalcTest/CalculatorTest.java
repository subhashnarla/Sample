package com.CalcTest;

import org.junit.runner.RunWith;
import cucumber.*;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//comments
@RunWith(Cucumber.class)
@CucumberOptions(
  features = { "classpath:features/calculator.feature" },
  glue = {"com.baeldung.cucumber.calculator" })
public class CalculatorTest {}
