package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.WebDriver;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import java.net.MalformedURLException;

public class LandingSteps extends UIInteractionSteps {
    @Managed
    WebDriver driver;

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) throws MalformedURLException {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) throws MalformedURLException {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {

//        assertThat(driver.getTitle(), CoreMatchers.containsString(term));
//        actor.attemptsTo( Ensure.that(TheWebPage.title()).containsIgnoringCase(term));
    }

    @Given("{string} opens EliteSingle\\(US)")
    public void sergeyOpensEliteSingleUS(String actor) {
//        driver.get("https://www.elitesingles.com/");
        openUrl("https://www.elitesingles.com/");


    }

    @When("he wants to reset his password")
    public void heWantsToResetHisPassword() {
        find("[id='show-login']").click();
        find("[class*='LoginForm_login-form__forgPass'] [href]").click();
//        driver.findElement(By.cssSelector("[id='show-login']")).click();
//        driver.findElement(By.cssSelector("[class*='LoginForm_login-form__forgPass'] [href]")).click();
    }

    @Then("he enters email {string}")
    public void heEntersEmail(String arg0) {
//        driver.findElement(By.cssSelector("[class='spark-input'][autocomplete='username']")).sendKeys(arg0);
        find("[class='spark-input'][autocomplete='username']").sendKeys(arg0);
    }

    @Given("Sergey opens EliteSingle\\(US)")
    public void sergeyOpensEliteSingleUS() {
        openUrl("https://www.elitesingles.com/");

    }
}
