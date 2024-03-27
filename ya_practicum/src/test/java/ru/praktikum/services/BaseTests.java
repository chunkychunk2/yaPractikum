package ru.praktikum.services;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class BaseTests {

    protected WebDriver driver;

    @Before
    public void setup() {
        //   System.setProperty("webdriver.chrome.driver", "/home/chun/Documents/practicum/ya_practicum/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/chun/Documents/practicum/ya_practicum/geckodriver");
        //   driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
