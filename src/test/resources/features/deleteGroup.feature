Feature:
  @search4
  Scenario: verify admin can delete the group
  Given Studymate.com
    When Admin logins by providing right credentials.
    Then Admin sees main page.
    Then Admin clicks Groups button.
    Then Admin sees list of groups in the platform.
    Then Admin finds the group
    Then Admin clicks on three dots(more options)
    Then Admin clicks delete button to delete  the group from the platform.
    Then Admin  must not  see the deleted group in the groups list.