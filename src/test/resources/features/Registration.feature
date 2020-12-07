@all
Feature: registration flow: personal data

  Scenario: User can proceed to payment page after providing the required info
    Given user goes to register from landing page
    And user is on registration personal data page
    When user provides email, password and pin
    And user provides personal details information
    And user accepts Terms & conditions
    And user saves personal data and proceed to next page
    Then user is on registration payment page

    Scenario: Verify required fields
      Given user goes to register from landing page
      And user is on registration personal data page
      When user saves personal data
      Then user is on registration personal data page
      And 15 empty required fields are highlighted