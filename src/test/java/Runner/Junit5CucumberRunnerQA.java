package Runner;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@Suite
@IncludeEngines("cucumber")
@RunWith(SerenityRunner.class)
@SelectClasspathResource("features")
@ExcludeTags(value = {"ignore", "dev"})
public class Junit5CucumberRunnerQA {
}
