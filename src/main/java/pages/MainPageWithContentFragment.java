package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class MainPageWithContentFragment extends BasePage {
    private ContentFragment contentFragment;
    By generateMarkupBtnId = By.id("markup-generation-button");

    public MainPageWithContentFragment(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public MainPageWithContentFragment open() {
        driver.get(mainPageUrl);
        return this;
    }

    public MainPageWithContentFragment clickButton() {
        contentFragment.clickTestButton();
        return this;
    }

    public MainPageWithContentFragment generateMarkup() {
        driver.findElement(generateMarkupBtnId).click();
        return this;
    }

}
