package com.cs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class SavingsCalculatorPage extends BasePage {

    WebDriver driver;
    private static final String SAVINGS_CALCULATOR_URL = "https://www.clearscore.com/savings-calculator";

    private By currentScoreSliderLocator = By.xpath("//input[@class=\"cs-scalc__range-slider__input mdl-slider js-range-current\"]");
    private By scoreGoalSliderLocator = By.xpath("//input[@class=\"cs-scalc__range-slider__input mdl-slider js-range-goal\"]");
    private By currentInterestRate = By.xpath("//td[@class=\"number-value js-current-average-rate\"]");
    private By annualCost = By.xpath("//td[@class=\"number-value js-current-annual-cost\"]");
    private By numberOfCards = By.xpath("//td[@class=\"number-value js-current-cc-available\"]");

    public SavingsCalculatorPage() {
        this.driver=BasePage.driver;
    }

    public void openSavingsCalculator() {
        driver.get(SAVINGS_CALCULATOR_URL);
    }

    public void moveCurrentScoreSlider() {
        WebElement currentScoreSlider = driver.findElement(currentScoreSliderLocator);
        Actions currentScoreactions = new Actions(driver);
        currentScoreactions.clickAndHold().dragAndDropBy(currentScoreSlider, -254, 0).release().build().perform();
    }


    public void moveScoreGoalSlider() {
        WebElement scoreGoalSlider = driver.findElement(scoreGoalSliderLocator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(scoreGoalSlider).moveByOffset(281, 0).release().perform();
    }

    public int getInterestPresent() {
        return getNumberOfElemnets(currentInterestRate);
    }

    public int getAnnualCost() {
        return getNumberOfElemnets(annualCost);
    }

    public int getNumberOfCards() {
        return getNumberOfElemnets(numberOfCards);
    }
}
