package validation.site.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import validation.site.helper.Constants;
import validation.site.helper.CookieManager;
import validation.site.guadian.navigation.GuardiaNewsNavigation;
import validation.site.guadian.pageobject.ArticleDetailPage;
import validation.site.guadian.pageobject.GuardianNewsPage;

public class GuardianNewsStepDefinitions {
	@Given("{actor} navigate to guardian news page")
	public void iNavigateToGuardianNewsPage(Actor actor) {
		actor.wasAbleTo(GuardiaNewsNavigation.theGuardianNewsPage());
	}

	@Then("{actor} verify the news page {string}")
	public void iVerifyIAmOnnTheNewsPage(Actor actor, String title) {
		String pageTitle = BrowseTheWeb.as(actor).getTitle();
		actor.attemptsTo(
				Ensure.that(pageTitle).contains(title)
		);
	}
	@Then("{actor} accept site cookie by clicking {string}")
	public void iAcceptSiteCookie(Actor actor, String textValue) {
		new CookieManager().acceptCookie(textValue);
	}

	@Then("{actor} on the {string} list page")
	public void iShouldSeeANewsPageTitle(Actor actor, String expectedTitle) {
		actor.attemptsTo(
				Ensure.that(GuardianNewsPage.NEWS_PAGE_TITLE).hasText(expectedTitle)
		);
	}

	@When("{actor} click on news heading {int}")
	public void iClickOnAnyNewsHeading(Actor actor, int newsPosition) {
		new GuardianNewsPage().clickAnyNewsHeading(newsPosition);
	}

	@Then("{actor} should be in a news article")
	public void iShouldBeInANewsArticle(Actor actor) {
		actor.attemptsTo(
				Ensure.that(GuardianNewsPage.ARTICLE_HEADING).textContent().isNotNull()
		);
		new ArticleDetailPage().setArticleTitle();
	}

	@When("{actor} set invalid news title as {string}")
	public void iSetInvalidNewsTitle(Actor actor, String fakeNews) {
		Constants.ARTICLE_TITLE = fakeNews;
	}
}