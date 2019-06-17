package com.cs.stepDefs;

import com.cs.pages.BasePage;
import com.cs.pages.HomePage;
import com.cs.pages.SavingsCalculatorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SavingsCalculatorSteps extends BaseSteps {

    private BasePage basePage;
    private HomePage homePage;
    private SavingsCalculatorPage savingsCalculatorPage;

    public SavingsCalculatorSteps(BasePage basePage, HomePage homePage, SavingsCalculatorPage savingsCalculatorPage) {
        this.basePage=basePage;
        this.homePage=homePage;
        this.savingsCalculatorPage=savingsCalculatorPage;
    }

    @Given("^I am on savings calculator page$")
    public void i_am_on_savings_calculator_page() throws Throwable {
        documentStep("In this step, making sure tha user is on clearscore home," +
                " by verifying the logo and opening the calculator");
        Assert.assertTrue("Logo not visible", homePage.isClearScoreLogoVisible());
        savingsCalculatorPage.openSavingsCalculator();
        Assert.assertTrue("Url is incorrect", basePage.doesUrlContain("/savings-calculator"));
    }

    @When("^I update current score to (\\d+)$")
    public void i_update_current_score_to(int arg1) throws Throwable {
        documentStep("In this step, moving the curren score slider");
        savingsCalculatorPage.moveCurrentScoreSlider();
    }

    @When("^I update score goal to (\\d+)$")
    public void i_update_score_goal_to(int arg1) throws Throwable {
        documentStep("In this step, moving the score goal slider");
        savingsCalculatorPage.moveScoreGoalSlider();
    }

    @Then("^current average interest rate is (\\d+)\\.(\\d+)%$")
    public void current_average_interest_rate_is(double percentage, int arg2) throws Throwable {
        documentStep("In this step, verifying the interest rate");
       Assert.assertEquals(36.5, savingsCalculatorPage.getInterestPresent(), percentage);
    }

    @Then("^current annual cost is £(\\d+)$")
    public void current_annual_cost_is_£(int annualCost) throws Throwable {
        documentStep("In this step, verifying the annual cost");
        Assert.assertEquals(849, savingsCalculatorPage.getAnnualCost(), annualCost);
    }

    @Then("^current cards available is (\\d+)$")
    public void current_cards_available_is(int cards) throws Throwable {
        documentStep("In this step, verifying the number of cards");
        Assert.assertEquals(22, savingsCalculatorPage.getNumberOfCards(), cards);
    }

}
