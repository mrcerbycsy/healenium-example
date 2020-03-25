package pages;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageYandex extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'button_theme_websearch')]")
    WebElement searchButton;

    public MainPageYandex(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPageYandex open() {
        driver.get(yandexPageUrl);
        return this;
    }

    public String takeTextFromButton() {
        return searchButton
                .findElement(By.xpath(".//span"))
                .getText();
    }
}
