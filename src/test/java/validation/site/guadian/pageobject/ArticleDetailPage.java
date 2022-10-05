package validation.site.guadian.pageobject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import validation.site.helper.Constants;

public class ArticleDetailPage extends PageObject {

	public void setArticleTitle(){
		WebElement element = getDriver().findElement(By.cssSelector("h1"));
		Constants.ARTICLE_TITLE = element.getText();
		System.out.println("Assigned "+element.getText());
	}
}
