package com.epam.sha.selenium;

import org.junit.Test;
import pages.MainPage;
import pages.MainPageWithFindBy;
import pages.MainPageWithContentFragment;

import static org.junit.Assert.assertThat;


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

    //test button can be found using HTML element page
    @Test
    public void testButtonClickWithHtmlElementPage() {
        MainPageWithContentFragment mainPageWithContentFragment = new MainPageWithContentFragment(driver);
        mainPageWithContentFragment.open()
            .clickButton();
        mainPageWithContentFragment.confirmAlert();
        for (int i = 0; i <= 2; i++) {
            mainPageWithContentFragment
                .generateMarkup()
                .clickButton();
            mainPageWithContentFragment.confirmAlert();
        }
    }
}
