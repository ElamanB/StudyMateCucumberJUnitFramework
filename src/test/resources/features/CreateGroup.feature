Feature: Test create group functionality

  Scenario: Verify user can successfully create group
    Given Groups page on studymate.com
    When user clicks on create group button
    Then verify pop up window is appeared
    And user enters Group name
    And user enters Date fo creation
    And user enters Description
    And user clicks on Create button
    Then verify user sees an alert message "Group successfully saved"
    Then verify Group with name "" exist in Group page
