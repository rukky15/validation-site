package validation.site.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import validation.site.google.navigation.GoogleNavigation;
import validation.site.google.search.GoogleSearchPage;
import validation.site.helper.Constants;

public class GoogleStepDefinitions {

	@And("{actor} navigate to google search engine")
	public void i_navigate_to_google_search_engine(Actor actor) {
		actor.wasAbleTo(GoogleNavigation.toGoogleSearchPage());
	}

	@And("{actor} try to verify news headline on google search engine")
	public void i_try_to_verify_news_headline_on_google_search_engine(Actor actor) {
		actor.attemptsTo(GoogleSearchPage.search(Constants.ARTICLE_TITLE));
	}

	@Then("{actor} should see a valid news title on google search list")
	public void i_should_see_a_valid_news_title_on_google(Actor actor) {
		new GoogleSearchPage().isValidNews();
	}

	@Then("I should see an invalid news title on google search list")
	public void iShouldSeeAnInvalidNewsTitleOnGoogleSearchList() {
		new GoogleSearchPage().inValidNews();
	}
}
