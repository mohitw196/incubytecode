package stepdefs;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, 
				  glue = {"stepdefs"}, tags = "@Test")
public class TestRunner {
	
}
