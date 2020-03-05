
Narrative: Authentication
  In order to gain access to the account settings
  As a user
  I need to be able to login and register

Scenario: successfully login
Given I am on the main page
When I open login form
When I enter email and password and click submit button
Then I should see that the inscription on the link to user account is to be changed to my username

Scenario: unsuccessfully registration with existed email
Given I am on the main page
When I open login form
When I switch to registration tab
When I enter new email and password and click submit button
Then I should see error registration message

Scenario: unsuccessfully login
Given I am on the main page
When I open login form
When I enter email and invalid password and click submit button
Then I should see error login message