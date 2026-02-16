package co.com.proyecto.starter.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/search/search_by_different_keywords.feature"},
        glue = "co/com/proyecto/starter/stepdefinitions",
        snippets = CAMELCASE,
        tags = "@green",
        plugin = {"rerun:target/TestRunner.txt"}
)

public class TestRunnerSuite {
}
