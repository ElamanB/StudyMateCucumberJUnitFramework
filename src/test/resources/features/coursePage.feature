Feature: test log in functionalities
  Background:
    Given Admin navigates to Studymate
    When Admin logins by providing correct user name and password.
    And Admin clicks Course button, then sees list of course in the platform.

  @editCourse
  Scenario: verify that admin can edit course
    And   In course section choose batch5 course and click on the Edit button
    And  Admin changes course name to "batch5 edited"
    And  Admin changes course description to "course"
    And Admin put the date to the course date "12042024"
    Then After making your changes, click on the Save button to save your modifications.

  @deleteCourse
  Scenario: verify that admin can delete course
    And   In course section choose batch course and click on the delete button
    Then After making your changes, click on the save button to save your changes.

