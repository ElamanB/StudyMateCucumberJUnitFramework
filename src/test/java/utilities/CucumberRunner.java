package utilities;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/reports/cucumber.html","json:target/reports/cucumber.json",},
        features = "src/test/resources/features" ,
        glue = "step_definitions",
        tags = "search3",
        dryRun = true
)

public class CucumberRunner {
}
