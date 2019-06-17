@cookieBanner

Feature: Cookie banner

  Scenario: Verify cookie banner is present on homepage
    Given I am on Clearscore homepage
    And I should see the cookie banner
    When I click on 'No problem'
    And the banner is collapsed
    And I refresh the page
    Then I shouldn't see the cookie banner




