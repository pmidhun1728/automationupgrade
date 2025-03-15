package com.upgrade.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
    private WebDriver driver;


//    @BeforeClass
//    public void beforeClass(){
//        getDriver();
//    }


    public WebDriver getDriver() {
        if(driver==null){
            setup();
        }
        return driver;
    }

    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser property is missing in config file.");
        }
        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
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
