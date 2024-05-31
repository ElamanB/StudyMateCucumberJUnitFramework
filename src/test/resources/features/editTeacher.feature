Feature:
  @search2
  Scenario:verify user can edit teacher by phone number
  Given Studymate.com
    When Admin logins by providing right credential.
    Then Admin sees main page.
    Then Admin clicks Teachers button
    Then sees list of teachers in the platform.
    Then Admin finds the teacher that they created
    Then Admin finds the given teacher
    Then Admin clicks on three dots (more options)
    Then user clicks on edit button.
    Then Admin sees fill-out form
    Then Admin edits the form by changing phone number to a different phone number
    Then user clicks on save button.
    Then Admin see the changed phone number in the list.