package Runner;

import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@RunWith(CucumberSerenityRunner.class)
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.liita.tas.stepdefinitions")
@ExcludeTags(value = {"ignore", "qa"})
public class Junit5CucumberRunnerDEV {
}
