package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface WebUtil <T extends WebUtil<T>> {
    WebElement enterText(By locator, String text);
    WebElement clickElement(By locator);
    WebElement selectOption(By locator, String text);
    WebElement waitForElement(By locator);
    T  waitForPageLoad();
    T waitForElementVisible(By locator);

}
