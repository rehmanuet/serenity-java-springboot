package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.openqa.selenium.WebDriver;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;

public class SearchStepDefinitions {

    @Managed
    WebDriver driver;

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {

        System.out.println(driver.getTitle());
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term)
        );
    }
}
