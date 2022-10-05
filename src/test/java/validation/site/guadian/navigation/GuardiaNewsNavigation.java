package validation.site.guadian.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import validation.site.guadian.pageobject.GuardianNewsPage;

public class GuardiaNewsNavigation {

    public static Performable theGuardianNewsPage() {
        return Task.where("{0} opens the guardian news page",
                Open.browserOn().the(GuardianNewsPage.class));
    }
}
