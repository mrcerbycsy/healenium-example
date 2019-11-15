package com.epam.sha.selenium;


import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingEngine;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



public class BaseTest {
    protected SelfHealingDriver driver;

    @Before
    public void setUp() {
        //declare delegate
        WebDriver delegate = new ChromeDriver();
        //declare configs for healenium
        Config config = ConfigFactory.load("healenium.properties");
        //declare engine with delegate and config
        SelfHealingEngine engine = new SelfHealingEngine(delegate, config);
        //create self-healing driver
        driver = SelfHealingDriver.create(engine);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1200, 800));
    }

    @After
    public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
