package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "./src/test/java/feature" },
glue = { "step"},
publish = true,
monochrome = true)

public class webMentionRunner extends AbstractTestNGCucumberTests{

}
