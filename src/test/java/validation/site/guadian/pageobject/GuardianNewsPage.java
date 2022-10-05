package validation.site.guadian.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://www.theguardian.com/tone/news")
public class GuardianNewsPage extends PageObject {

	public static final Target NEWS_PAGE_TITLE = Target.the("news page title")
			.located(By.xpath("//body[@id='top']/div[3]/div/div/div/h1"));
	public static final Target ARTICLE_HEADING = Target.the("article heading title")
			.located(By.cssSelector("div[data-gu-name=\"headline\"]"));

	public void clickAnyNewsHeading(int newsPosition){
		List<WebElement> elements = getDriver().findElements(By.cssSelector("div[data-test-id=\"facia-card\"]"));
		elements.get(newsPosition).click();
	}

}
