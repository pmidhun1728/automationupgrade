package com.upgrade.tests;

import com.upgrade.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BossWebUtil;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private BossWebUtil bossWebUtil;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize browser window
        driver = new ChromeDriver(options);

        // Initialize utility class
        bossWebUtil = new BossWebUtil(driver);

        // Navigate to the Upgrade website
        driver.get("https://www.upgrade.com");

        // Initialize LoginPage with WebDriver
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testPersonalLoansDropDownClick() throws InterruptedException {
        bossWebUtil.waitForPageLoad();
        loginPage.personalLoansDropDownClick();
        Assert.assertTrue(driver.getCurrentUrl().contains("upgrade"), "Failed to verify dropdown click.");
        loginPage.clickPersonalLoansDropDown();
        loginPage.enterLoanDetails();
    }
}

