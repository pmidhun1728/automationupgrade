package com.upgrade.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FooterPage {

    private WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateFooterLinks() throws InterruptedException {

       WebElement footer =  driver.findElement(By.className("styles__StyledText-sc-1hgzk9e-0 gAKIVV footer-menu__category"));
        List<WebElement> links = footer.findElements(By.className("list--unstyled"));

       int count = links.size();
        System.out.println("No of links are: "+ count);

//       List<WebElement> links = driver.findElements(By.className("list--unstyled"));
//       String originalWindow =  driver.getWindowHandle();


//       for(WebElement link: links){
//          String url = link.getAttribute("href");

//          if(url !=null && !url.isEmpty()){
//              driver.switchTo().newWindow(WindowType.TAB);
//              driver.get(url);
//              System.out.println("Opened URL" + url);
//              Thread.sleep(2000);
//              driver.close();
//              driver.switchTo().window(originalWindow);
//          }
//       }
    }
}
