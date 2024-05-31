Feature:
  @search2
  Scenario:verify user is able to delete teacher
  Given Studymate.com
    When Admin logins by providing right credentials.
    Then Admin sees main page.
    Then Admin clicks Teachers button
    Then Admin sees list of teachers in the platform.
    Then Admin finds the given teacher
    Then Admin clicks three dots( more options)
    Then Admin clicks on delete button.
    Then Admin must not see the deleted teacher in the list.