Feature:  UserLoginsFeature

  Scenario: Test login success user
    Given that the user is in the application
    When the user logs in successfully
    Then the user should see a success message displayed