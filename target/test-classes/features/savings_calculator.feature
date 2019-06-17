@savingsCalculator

  Feature: Savings Calculator

    Scenario: Verify savings calculator
      Given I am on Clearscore homepage
      And I am on savings calculator page
      When I update current score to 50
      And I update score goal to 680
      Then current average interest rate is 36.5%
      And current annual cost is £849
      And current cards available is 22
