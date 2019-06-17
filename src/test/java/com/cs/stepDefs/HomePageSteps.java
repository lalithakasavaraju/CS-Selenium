package com.cs.stepDefs;

import com.cs.pages.BasePage;
import com.cs.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HomePageSteps extends BaseSteps {

    private BasePage basePage;
    private HomePage homePage;

    public HomePageSteps(BasePage basePage, HomePage homePage) {
        this.basePage = basePage;
        this.homePage = homePage;
    }

    @Given("^I am on Clearscore homepage$")
    public void i_am_on_Clearscore_homepage() throws Throwable {
        documentStep("In this step, verifying the user is on homepage by verifying thhe URL, logo");
        Assert.assertTrue("URL is incorrect", basePage.doesUrlContain("https://www.clearscore.com/"));
        Assert.assertTrue("logo is not visible", homePage.isClearScoreLogoVisible());
    }

    @Given("^I should see the cookie banner$")
    public void i_should_see_the_cookie_banner() throws Throwable {
        documentStep("In this step, verifying the cookie banner is displayed");
        Assert.assertTrue("Cookie banner is not visible", homePage.isCookieBannerVisible());
        Assert.assertTrue("No problem button is not present", homePage.isNoProblemButtonPresent());
        Assert.assertTrue("More info button is not present", homePage.isMoreInfoButtonPresent());
    }

    @When("^I click on 'No problem'$")
    public void i_click_on_No_problem() throws Throwable {
        documentStep("In this step, clicking on the No problem button");
        homePage.clickNoProblemButton();
    }

    @When("^(?:the banner is collapsed|I shouldn't see the cookie banner)$")
    public void the_banner_is_collapsed() throws Throwable {
        documentStep("In this step, verifying that cookie banner is not visible");
        Assert.assertFalse("Cookie banner is visible", homePage.isCookieBannerVisible());
    }

    @When("^I refresh the page$")
    public void i_refresh_the_page() throws Throwable {
        documentStep("In this step, refreshing the page");
        basePage.refreshPage();
    }

}
