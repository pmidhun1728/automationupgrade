package com.upgrade.tests.web;

import com.upgrade.common.BaseTest;
import com.upgrade.pages.PersonalLoanFlowPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BossWebUtil;
import utils.ScreenShotUtil;

public class PersonalLoanFlowTest extends BaseTest {
    private PersonalLoanFlowPage personalLoanFlowPage;
    private BossWebUtil bossWebUtil;
    private ScreenShotUtil screenShotUtil;
    private WebDriver driver;

    @BeforeClass
    public void initializePageObjects() {
        driver = getDriver();
        personalLoanFlowPage = new PersonalLoanFlowPage(driver);
    }

    @Test
    public void testPersonalLoansDropDownClick() throws InterruptedException {
        bossWebUtil.waitForPageLoad();
       try {
           Assert.assertTrue(driver.getCurrentUrl().contains("upgrade"), "Failed to verify dropdown click.");
           personalLoanFlowPage.clickPersonalLoansDropDown();
           personalLoanFlowPage.enterLoanDetails();
           personalLoanFlowPage.enterIndividualDetails();
           personalLoanFlowPage.enterAnnualIncome();
           personalLoanFlowPage.createAccount();

           screenShotUtil.captureScreenshot(driver, "testPersonalLoansDropDownClick_Success");

       } catch (Exception e) {
           screenShotUtil.captureScreenshot(driver, "testPersonalLoanclick-Failure");
           throw e;
       }
    }
}