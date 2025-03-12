package com.upgrade.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BossWebUtil;

public class LoginPage {

   WebDriver driver;
   BossWebUtil bossWebUtil;

   @FindBy(xpath = "//span[@class='styles__StyledText-sc-1hgzk9e-0 ipOwg styles__MenuItemText-sc-d94xdo-7 jblynv'][normalize-space()='Personal Loans']")
   private WebElement personalLoansDropDown;

   @FindBy(xpath = "//span[normalize-space()='All Personal Loans']")
   public WebElement allPersonalLoans;

   @FindBy(xpath = "//input[@id='pl-loan-amount']")
   public WebElement loanAmountTextBox;

   @FindBy(id = "pl-loan-purpose-select")
   public WebElement loanPurposeDropDown;

   @FindBy(xpath = "//select[@id='pl-loan-purpose-select']//option[text()='Pay off Credit Cards']")
   public  WebElement payOffCreditCardsDropDownValue;

   @FindBy(xpath= "//span[@class='contentWrapper'][normalize-space()='Check your rate']")
   public WebElement checkYourRateButton;


   public void enterLoanDetails(){

      loanAmountTextBox.click();
      loanAmountTextBox.sendKeys("20000");
      loanPurposeDropDown.click();
      payOffCreditCardsDropDownValue.click();
      checkYourRateButton.click();

   }

   public LoginPage(WebDriver driver) {
      this.driver = driver;
      this.bossWebUtil = new BossWebUtil(driver);
      PageFactory.initElements(driver, this);
   }

   public void personalLoansDropDownClick() {
      try {
         bossWebUtil.waitForElementClickable(personalLoansDropDown);
         personalLoansDropDown.click();
      } catch (StaleElementReferenceException e) {
         System.out.println("Caught StaleElementReferenceException. Retrying...");
         bossWebUtil.waitForElementClickable(personalLoansDropDown);
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", personalLoansDropDown);
      }
   }

   public void clickPersonalLoansDropDown() throws InterruptedException {
      personalLoansDropDown.click();
      Thread.sleep(1000);
      allPersonalLoans.click();

   }
}