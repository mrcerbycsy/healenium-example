package com.epam.sha.selenium;

import org.junit.Test;
import pages.MainPage;
import pages.MainPageWithFindBy;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;


public class MarkupTest extends BaseTest {

    @Test
    public void testButtonClickWithFindByAnnotationPage() {
        MainPageWithFindBy mainPage = new MainPageWithFindBy(driver);
        //find test button
        mainPage.open().clickTestButton();
        //confirm Alert
        assertThat(mainPage.getAlertText(), equalToIgnoringCase(buttonFoundText));
        mainPage.confirmAlert();
        for (int i = 0; i <= 2; i++) {
            mainPage
                .generateMarkup() //regenerate Markup
                .clickTestButton(); //find test button again
            assertThat(mainPage.getAlertText(), equalToIgnoringCase(buttonFoundText));
            mainPage.confirmAlert();  //confirm Alert again
        }
    }

    @Test
    public void testButtonClickWithFindElementPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
            .clickTestButton();
        assertThat(mainPage.getAlertText(), equalToIgnoringCase(buttonFoundText));
        mainPage.confirmAlert();
        for (int i = 0; i <= 2; i++) {
            mainPage
                .generateMarkup()
                .clickTestButton();
            assertThat(mainPage.getAlertText(), equalToIgnoringCase(buttonFoundText));
            mainPage.confirmAlert();
        }
    }
}
