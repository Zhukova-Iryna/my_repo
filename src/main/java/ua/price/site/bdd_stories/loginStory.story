Meta:

  Narrative: As a user I need to be able to login and logout

  Scenario: Successfully login
    Given I am on 'Main' Page
    When I open login form
    When I enter email Email and enter password CorrectPassword and click on 'Login' button
    Then I should see that the inscription in 'User account link' changed to my login

  Scenario: Login with invalid password
    Given I am on 'Main' page
    When I open login form
    When I enter email Email and enter password InvalidPassword and click on 'Login' button
    Then I should see error message