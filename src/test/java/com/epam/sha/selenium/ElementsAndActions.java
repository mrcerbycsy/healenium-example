package com.epam.sha.selenium;

import org.junit.Test;
import pages.AjaxLoadPage;
import pages.MainPageWithFindBy;
import pages.MainPageYandex;

import static org.junit.Assert.assertTrue;

public class ElementsAndActions extends BaseTest {

    @Test
    public void testWaitForJsElementToDisappear() {
        AjaxLoadPage mainPage = new AjaxLoadPage(driver);
        //  Click on `Send Request` button
        mainPage.open().click();
        //  Check that spinner is displayed
        assertTrue("Spinner is not displayed", mainPage.isLoadingSpinnerDisplayed());
        //  Wait for spinner to disappear
        mainPage.waitForLoadingSpinnerToDisappear();
        //  Check that spinner is not displayed
        assertTrue("Content loaded is not displayed", mainPage.isLoadingContentDisplayed());
    }

    @Test
    public void testHover() {
        /*
        Checking a bug: https://github.com/healenium/healenium-web/issues/30
         */
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver).open();
        mainPage.hoverOnTestButton();
        String class_of_element = mainPage.getAttributeFromTestButton("class");
        assertTrue("In the class not indicated that on the button hovered a cursor",
                class_of_element.contains("button_hovered"));
    }

    @Test
    public void testNotHealWhenUseInvisibilityOf() {
        /*
        Checking a bug: https://github.com/healenium/healenium-web/issues/31
         */
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver).open();
        mainPage
                .clickTestButton()
                .confirmAlert();
        new MainPageYandex(driver).open();
        assertTrue("The error while checking the invisibility of the element",
                mainPage.checkThatButtonInvisible());
    }

    @Test
    public void testFindElementWithinParent() {
        /*
        Checking the bug: https://github.com/healenium/healenium-web/issues/43
         */
        MainPageYandex mainYandex = new MainPageYandex(driver).open();
        String text = mainYandex.takeTextFromButton();
        assertTrue("The text doesn't match with the expected result",
                text.equalsIgnoreCase("Найти"));
    }

}
