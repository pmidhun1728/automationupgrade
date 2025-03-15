package com.upgrade.web.tests;

import com.upgrade.common.BaseTestWeb;
import com.upgrade.web.pages.FooterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FooterTest extends BaseTestWeb {
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
