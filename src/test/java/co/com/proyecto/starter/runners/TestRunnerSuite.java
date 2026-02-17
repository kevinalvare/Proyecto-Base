package co.com.proyecto.starter.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/orangehrm_employee_registration.feature"},
        glue = "co.com.proyecto.starter.stepdefinitions",
        snippets = CAMELCASE,
        tags = "@orangehrm",
        plugin = {"rerun:target/TestRunner.txt"}
)
public class TestRunnerSuite {
}
