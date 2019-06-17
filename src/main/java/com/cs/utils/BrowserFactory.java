package com.cs.utils;

import com.cs.pages.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static WebDriver driver;
    private static final String ENV_URL = "https://www.clearscore.com/";
    private static BasePage basePage;

    public static WebDriver getDriver()
    {
        return driver;
    }



    @Before
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver_mac_2.46");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get(ENV_URL);
        basePage = new BasePage();
        basePage.setWebDriver(driver);
    }

    @After
    public static void closeBrowser() {
        driver.quit();
        System.out.println("Closed Browser");
    }
}



