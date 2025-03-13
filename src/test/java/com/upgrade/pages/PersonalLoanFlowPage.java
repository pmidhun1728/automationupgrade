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

   @FindBy(xpath = "//li[@id='ChIJCUEMWK059YgRx7uySfnyFQg']//span[1]")
   public WebElement borrowersAddressByIndex;

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

   @FindBy(xpath = "//h1[text()='How much money do you make in a year?']")
   public WebElement howMuchMoneyTextVerification;

   @FindBy(xpath = "//input[@name='borrowerIncome']")
   public WebElement individualAnnualIncomeTextBox;

   @FindBy(xpath = "//input[@name='borrowerAdditionalIncome']")
   public WebElement additionalAnnualIncomeTextBox;

   @FindBy(xpath = "//span[@class='contentWrapper']")
   public WebElement annualIncomeSubmit;

   @FindBy(xpath = "//input[@name='username']")
   public WebElement emailTextBox;

   @FindBy(xpath = "//input[@name='password']")
   public WebElement passwordTextBox;

   @FindBy(xpath = "//div[@class='sc-iKOmoZ sc-ckdEwu kdFYBU kLczNJ']")
   public WebElement checkBox;

   @FindBy(xpath = "//span[@class='contentWrapper']")
   public WebElement getCheckYourRateButton;

   @FindBy(xpath = "//h2[text()=\"We're sorry, we were unable to approve you.\"]")
   public WebElement verifyText;


   public void enterIndividualDetails(){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      Assert.assertTrue(individualRadioButton.isEnabled(), "Individual Button is enabled");

      wait.until(ExpectedConditions.elementToBeClickable(borrowersFirstName));

      borrowersFirstName.sendKeys(fakerClass.getFirstName());
      borrowersLastName.sendKeys(fakerClass.getLastName());
      borrowersAddress.sendKeys("123cdwcb");
//      borrowersAddressByIndex.click();
      borrowersCity.sendKeys(fakerClass.getCity());
      borrowersState.sendKeys(fakerClass.getStateAbbreviation());
      borrowersZipCode.sendKeys(fakerClass.getZipCode());
      borrowersDOB.sendKeys(fakerClass.getDateOfBirth());

      wait.until(ExpectedConditions.elementToBeClickable(borrowersContinue));
      borrowersContinue.submit();
   }

   public void enterAnnualIncome(){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      Assert.assertTrue(howMuchMoneyTextVerification.isDisplayed(), "Annual Income text is verified");
      individualAnnualIncomeTextBox.sendKeys(fakerClass.getLoanAmount());
      additionalAnnualIncomeTextBox.sendKeys(fakerClass.getLoanAmount());
      wait.until(ExpectedConditions.elementToBeClickable(annualIncomeSubmit));
      annualIncomeSubmit.click();
   }

   public void createAccount(){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      emailTextBox.sendKeys(fakerClass.getFirstName()+"@gmail.com");
      passwordTextBox.sendKeys("Midhun@2734");
      checkBox.click();
     Assert.assertTrue(checkBox.isEnabled(), "checkbox is Enabled");
     getCheckYourRateButton.click();
     wait.until(ExpectedConditions.elementToBeClickable(verifyText));
     Assert.assertTrue(verifyText.isDisplayed(), "We're sorry, we were unable to approve you. is displayed");
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
