package pages;

import com.epam.healenium.PageAwareFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Search form")
@FindBy(css = "div.App")
public class ContentFragment extends HtmlElement {

    @Name("Search button")
    @PageAwareFindBy(findBy = @FindBy(xpath = "//button[contains(@class,'default-btn')]"))
    WebElement testButton;

    public void clickTestButton() {
        testButton.click();
    }
}
