Feature: test delete course functionalities
  @deleteCourse
  Scenario: verify that admin can delete course
    Given given Studymate
    When Admin logins by providing user name and password.
    And Admin clicks Course button, then sees list of course in the platform.
    And   In course section choose batch5 and click on the delete button
    Then After making your changes, click on the save button.