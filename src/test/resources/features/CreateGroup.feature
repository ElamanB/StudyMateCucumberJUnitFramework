Feature: Test create group functionality

  Background:
    Given user Logged in on studymate.com
    And user navigates to the Groups Page


  @createGroup
  Scenario: Verify user can successfully create a group
    When user clicks on create group button
    Then verify that a popUp window appears
    When user enters Group name
    And user enters Date of creation
    And user enters Description
    And user provides Group Photo
    And user clicks on Create button
    Then verify that an alert message "Group successfully saved" is displayed
    Then verify that a group with the specified name exists on the Groups Page
    And the user logs out

  @createGroup
  Scenario: Verify user can cancel group creation process
    When user clicks on create group button
    Then verify that a popUp window appears
    When user enters Group name
    And user enters Date of creation
    And user enters Description
    And user provides Group Photo
    Then verify that the cancel button is displayed
    And user clicks on Cancel button
    Then verify that a group with the specified name does not exists on the Groups Page
    And the user logs out

  @createGroup
  Scenario: Verify error when creating a group with a duplicate name
    When user clicks on create group button
    Then verify that a popUp window appears
    When user enters Group name which is already exists
    And user enters Date of creation
    And user enters Description
    And user provides Group Photo
    And user clicks on Create button
    Then verify that an error alert message "A group with the same title already exists" is displayed
    And user clicks on Cancel button
    And the user logs out


