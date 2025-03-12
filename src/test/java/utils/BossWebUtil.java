package utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BossWebUtil implements WebUtil {
    private final WebDriver driver;
    private final Wait<WebDriver> waitForElement;
    public BossWebUtil(WebDriver driver) {
        this.driver = driver;
        waitForElement = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    @Override
    public WebElement waitForElement(By locator)
    {
        return waitForElement.until(driver -> driver.findElement(locator));
    }

    @Override
    public BossWebUtil waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    @Override
    public BossWebUtil waitForElementVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    @Override
    public WebElement clickElement(By locator)
    {
        scrollToElement(locator);
        return waitForElement.until(driver -> {
            WebElement element = driver.findElement(locator);
            element.click();
            return element;
        });
    }

    public void waitForElementClickable(WebElement element) {
        try {
            waitForElement.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new RuntimeException("Element not clickable: " + element, e);
        }
    }
    @Override
    public WebElement selectOption(By locator, String text) {
        return null;
    }

    @Override
    public WebElement enterText(By locator, String text)
    {
        scrollToElement(locator);
        return waitForElement.until(driver -> {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
            return element;
        });
    }

    private void scrollToElement(By locator)
    {
        String script =
                "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                        + "var elementTop = arguments[0].getBoundingClientRect().top;"
                        + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, waitForElement(locator));
    }
}

