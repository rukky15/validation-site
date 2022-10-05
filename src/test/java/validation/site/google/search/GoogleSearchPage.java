package validation.site.google.search;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import validation.site.helper.Constants;

@DefaultUrl("https://google.com")
public class GoogleSearchPage extends PageObject {
    static Target SEARCH_FIELD = Target
            .the("search field")
            .located(By.name("q"));

    public static final Target SEARCH_RESULT_TITLES = Target
            .the("search results")
            .located(By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3"));

    public static Performable search(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "' on google",
                Enter.theValue(searchTerm)
                        .into(SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }

    public void isValidNews() {
        WebElement element = getDriver().findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3"));
        Assertions.assertThat(element.getText().substring(0, 40)).contains(Constants.ARTICLE_TITLE.substring(0, 40));
    }
    public void inValidNews() {
        WebElement element = getDriver().findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3"));
        Assertions.assertThat(element.getText().substring(0, 10)).doesNotContain(Constants.ARTICLE_TITLE.substring(0, 10));
    }
}
