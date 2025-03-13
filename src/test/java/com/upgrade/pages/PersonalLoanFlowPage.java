package com.upgrade.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BossWebUtil;
import utils.FakerClass;

import java.time.Duration;

public class PersonalLoanFlowPage {

   WebDriver driver;
   BossWebUtil bossWebUtil;
   FakerClass fakerClass;

   @FindBy(xpath = "//span[@class='styles__StyledText-sc-1hgzk9e-0 ipOwg styles__MenuItemText-sc-d94xdo-7 jblynv'][normalize-space()='Personal Loans']")
   private WebElement personalLoansDropDown;

   @FindBy(xpath = "//span[normalize-space()='All Personal Loans']")
   public WebElement allPersonalLoans;

   @FindBy(xpath = "//input[@id='pl-loan-amount']")
   public WebElement loanAmountTextBox;

   @FindBy(id = "pl-loan-purpose-select")
   public WebElement loanPurposeDropDown;

   @FindBy(xpath = "//select[@id='pl-loan-purpose-select']//option[text()='Pay off Credit Cards']")
   public WebElement payOffCreditCardsDropDownValue;

   @FindBy(xpath = "//span[@class='contentWrapper'][normalize-space()='Check your rate']")
   public WebElement checkYourRateButton;

   // Individual Page
   @FindBy(xpath = "//div[@data-checked='true']")
   public WebElement individualRadioButton;

   @FindBy(xpath = "//input[@name='borrowerFirstName']")
   public WebElement borrowersFirstName;

   @FindBy(xpath = "//input[@name='borrowerLastName']")
   public WebElement borrowersLastName;

   @FindBy(xpath = "//input[@id='geosuggest__input--borrowerStreet']")
   public WebElement borrowersAddress;

   @FindBy(xpath = "//input[@name='borrowerCity']")
   public WebElement borrowersCity;

   @FindBy(xpath = "//input[@name='borrowerState']")
   public WebElement borrowersState;

   @FindBy(xpath = "//input[@name='borrowerZipCode']")
   public WebElement borrowersZipCode;

   @FindBy(xpath = "//input[@name='borrowerDateOfBirth']")
   public WebElement borrowersDOB;

   @FindBy(xpath = "//span[@class='contentWrapper']")
   public WebElement borrowersContinue;


   public void enterIndividualDetails(){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      Assert.assertTrue(individualRadioButton.isEnabled(), "Individual Button is enabled");

      wait.until(ExpectedConditions.elementToBeClickable(borrowersFirstName));

      borrowersFirstName.sendKeys(fakerClass.getFirstName());
      borrowersLastName.sendKeys(fakerClass.getLastName());
      borrowersAddress.sendKeys(fakerClass.getStreetAddress());
      borrowersCity.sendKeys(fakerClass.getCity());
      borrowersState.sendKeys(fakerClass.getStateAbbreviation());
      borrowersZipCode.sendKeys(fakerClass.getZipCode());
      borrowersDOB.sendKeys(fakerClass.getDateOfBirth());

      wait.until(ExpectedConditions.elementToBeClickable(borrowersContinue));
      borrowersContinue.submit();
   }


   public void enterLoanDetails() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(loanAmountTextBox));
      loanAmountTextBox.click();
      loanAmountTextBox.sendKeys(fakerClass.getLoanAmount());
      loanPurposeDropDown.click();
      payOffCreditCardsDropDownValue.click();
      checkYourRateButton.click();

   }

   public PersonalLoanFlowPage(WebDriver driver) {
      this.driver = driver;
      this.bossWebUtil = new BossWebUtil(driver);
      PageFactory.initElements(driver, this);
   }

   public void clickPersonalLoansDropDown() throws InterruptedException {
      personalLoansDropDown.click();
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.elementToBeClickable(allPersonalLoans));
      Thread.sleep(1000);
      allPersonalLoans.click();
   }
}
