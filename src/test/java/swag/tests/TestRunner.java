package swag.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/swag", 
    glue = "swag/steps", 
    plugin = { "pretty", "html: testreport/test-reports.html" } // Generates HTML report in the testreport/test-reports directory
)
public class TestRunner {
}
