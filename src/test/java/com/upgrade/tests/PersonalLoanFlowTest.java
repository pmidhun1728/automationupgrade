package com.upgrade.tests;

import com.upgrade.pages.PersonalLoanFlowPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BossWebUtil;

public class PersonalLoanFlowTest extends BaseTest {
    private PersonalLoanFlowPage personalLoanFlowPage;
    private BossWebUtil bossWebUtil;

    @BeforeClass
    public void initializePageObjects() {
        bossWebUtil = new BossWebUtil(driver);
        personalLoanFlowPage = new PersonalLoanFlowPage(driver);
    }

    @Test
    public void testPersonalLoansDropDownClick() throws InterruptedException {
        bossWebUtil.waitForPageLoad();
        Assert.assertTrue(driver.getCurrentUrl().contains("upgrade"), "Failed to verify dropdown click.");
        personalLoanFlowPage.clickPersonalLoansDropDown();
        personalLoanFlowPage.enterLoanDetails();
        personalLoanFlowPage.enterIndividualDetails();
        personalLoanFlowPage.enterAnnualIncome();
        personalLoanFlowPage.createAccount();
    }
}