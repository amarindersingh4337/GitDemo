package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber -> TestNG, Junit

@CucumberOptions(features="src/test/java/Cucumber",glue="rahulshettyacademy.stepDefinitions",
monochrome=true,plugin= {"html:reports/cucumber.html"}, tags = "Regression")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
