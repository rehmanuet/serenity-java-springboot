package runner;

import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@RunWith(CucumberSerenityRunner.class)
@SelectClasspathResource("/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.lab.tas.stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporter")
@ExcludeTags(value = {"ignore", "dev"})
public class Junit5CucumberRunnerQA {
}
