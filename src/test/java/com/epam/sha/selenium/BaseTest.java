package com.epam.sha.selenium;


import com.epam.healenium.SelfHealingDriver;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    static protected SelfHealingDriver driver;

    @BeforeAll
    static public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        //declare delegate
        WebDriver delegate = new ChromeDriver(options);
        //declare configs for healenium
        Config config = ConfigFactory.load("healenium.properties");
        //create self-healing driver
        driver = SelfHealingDriver.create(delegate, config);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1200, 800));
    }

    @AfterAll
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
