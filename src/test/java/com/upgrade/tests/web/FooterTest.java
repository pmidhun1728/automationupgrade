package com.upgrade.tests.web;

import com.upgrade.pages.FooterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {
    private FooterPage footerPage;

    @BeforeClass
    public void initializer(){
        footerPage = new FooterPage(driver);
    }

    @Test
    public void footer() throws InterruptedException {
        footerPage.validateFooterLinks();
    }
}
