package com.upgrade.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser property is missing in config file.");
        }
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("upgrade/chromedriver");
//            options.addArguments("--incognito");
            options.addArguments("--disable-images");
            options.addArguments("blink-settings=imagesEnabled=false");
            options.addArguments("--disable-css");
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }


    @AfterClass
    public void logOut() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
