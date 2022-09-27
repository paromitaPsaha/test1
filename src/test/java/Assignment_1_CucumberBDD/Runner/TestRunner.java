package Assignment_1_CucumberBDD.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:Features",
		glue = "Assignment_1_CucumberBDD.StepDef",
		tags = "",
		plugin = {"pretty",                      
	            "html:target/html/htmlReport.html",
	            "json:target/json/jsonReport.json",
	            },
		monochrome=true,
        publish= true,
        dryRun=false
		)





public class TestRunner {

}
