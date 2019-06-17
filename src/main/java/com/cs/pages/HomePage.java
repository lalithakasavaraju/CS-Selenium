package com.cs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;
    private By csLogo = By.xpath("(//a[@class=\"logo navbar-logo\"])[2]");
    private By cookieBanner = By.xpath("//div[@ng-class=\"{show: showCookiesWarning}\"]");
    private By cookieBannerText = By.xpath("(//div[@ng-class=\"{show: showCookiesWarning}\"]//p)[1]");
    private By noProblemButton = By.xpath("//div[@ng-class=\"{show: showCookiesWarning}\"]//span");
    private By moreInfoButton = By.xpath("//div[@ng-class=\"{show: showCookiesWarning}\"]//a");

    public HomePage() {
        this.driver=BasePage.driver;
    }

    public boolean isClearScoreLogoVisible() {
        return (isElementPresent(csLogo));
    }

    public boolean isCookieBannerVisible() {
        return (isElementPresent(cookieBanner));
    }

    public String getCookieBannerText() {
        return getText(cookieBannerText);
    }

    public boolean isNoProblemButtonPresent() {
        return isElementPresent(noProblemButton);
    }

    public boolean isMoreInfoButtonPresent() {
        return isElementPresent(moreInfoButton);

    }

    public void clickNoProblemButton() {
        click(noProblemButton);
        sleep(1);
    }

}
