package com.epam.sha.selenium;

import org.junit.Test;
import pages.AjaxLoadPage;
import pages.MainPage;
import pages.MainPageWithFindBy;
import pages.MainPageYandex;
import static org.junit.Assert.assertTrue;


public class MarkupTest extends BaseTest {

    @Test
    public void testButtonClickWithFindByAnnotationPage() {
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        //find test button
        mainPage.open().clickTestButton();
        //confirm Alert
        mainPage.confirmAlert();
        for (int i = 0; i <= 2; i++) {
            mainPage
                .generateMarkup() //regenerate Markup
                .clickTestButton(); //find test button again
            mainPage.confirmAlert();  //confirm Alert again
        }
    }

    @Test
    public void testButtonClickWithFindElementPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
            .clickTestButton();
        mainPage.confirmAlert();
        for (int i = 0; i <= 2; i++) {
            mainPage
                .generateMarkup()
                .clickTestButton();
            mainPage.confirmAlert();
        }
    }

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
    public void testFindElementWithinParent() {
        /*
        Checking the bug: https://github.com/healenium/healenium-web/issues/43
         */
        MainPageYandex mainYandex = new MainPageYandex(driver).open();
        String text = mainYandex.takeTextFromButton();
        assertTrue("Text doesn't match with expected result", text.equalsIgnoreCase("найти"));
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
        assertTrue("The error while checking element invisible",
                mainPage.checkThatButtonInvisible());
    }

}
