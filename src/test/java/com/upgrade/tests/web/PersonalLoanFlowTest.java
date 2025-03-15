package com.upgrade.tests.web;

import com.upgrade.pages.PersonalLoanFlowPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BossWebUtil;
import utils.ScreenShotUtil;

public class PersonalLoanFlowTest extends BaseTest {
    private PersonalLoanFlowPage personalLoanFlowPage;
    private BossWebUtil bossWebUtil;
    private ScreenShotUtil screenShotUtil;

    @BeforeClass
    public void initializePageObjects() {
        bossWebUtil = new BossWebUtil(driver);
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