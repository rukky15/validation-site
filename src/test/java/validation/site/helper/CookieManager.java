package validation.site.helper;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieManager extends PageObject {

	public static final Target ACCEPT_ALL_COOKIES = Target.the("iframe cookie pop up")
			.located(By.tagName("iframe"));

	public void acceptCookie(String cookieButton){
		WebDriver element = getDriver().switchTo().frame("sp_message_iframe_717122");
		element.findElement(By.cssSelector("button[title=\""+cookieButton+"\"]")).click();
	}
}
