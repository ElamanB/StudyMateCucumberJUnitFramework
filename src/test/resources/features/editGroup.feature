Feature:
  @search3
  Scenario:verify user can edit group by group name
    Given Studymate.com
    When Admin logins by providing right credentials.
    Then Admin sees main page.
    Then Admin clicks Groups button
    Then Admin sees list of groups in the platform.
    Then Admin finds the group
    Then Admin clicks on three dots(more options)
    And Admin clicks on edit button.
    Then Admin sees fill-out form
    Then Admin fills-out the form by providing:(group name)
    Then Admin clicks on save button.
    Then Admin must see the edited group in the groups list.