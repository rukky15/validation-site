package validation.site.google.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import validation.site.google.search.GoogleSearchPage;

public class GoogleNavigation {

    public static Performable toGoogleSearchPage() {
        return Task.where("{0} opens the google search page",
                Open.browserOn().the(GoogleSearchPage.class));
    }
}
