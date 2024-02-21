package starter.search;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchForm {
    static Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchbox_input");
   public static By SEARCH_FIELDw = By.cssSelector("[class*='LoginForm_login-form__forgPass'] [href]");
}
