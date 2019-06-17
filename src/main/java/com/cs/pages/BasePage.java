package com.cs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private static final int DEFAULT_WEBDRIVER_WAIT_SECONDS = 25;
    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver) {
        this.driver=driver;
    }

    public void click(By button) {
        driver.findElement(button).click();
    }


    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public boolean isElementPresent(By elementBy) {
        List<WebElement> elements = driver.findElements(elementBy);
        if (elements.isEmpty()) {
            return false;
        }
        return driver.findElement(elementBy).isDisplayed();
    }

    public boolean doesUrlContain(String url) {
        return waitUntil(ExpectedConditions.urlContains(url));
    }

    public <T> T waitUntil(ExpectedCondition<T> condition) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WEBDRIVER_WAIT_SECONDS);
        return wait.until(condition);
    }


    public String getText(By element) {
        return driver.findElement(element).getText();
    }

    public int getNumberOfElemnets(By element) {
        return driver.findElements(element).size();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        sleep(1);
    }

}
