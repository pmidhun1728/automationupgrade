package com.upgrade.tests.web;

import com.upgrade.common.BaseTest;
import com.upgrade.pages.FooterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {
    private FooterPage footerPage;
    private WebDriver driver;

    @BeforeClass
    public void initializer(){
        driver = getDriver();
    }

    @Test
    public void footer() throws InterruptedException {
        footerPage.validateFooterLinks();
    }
}
