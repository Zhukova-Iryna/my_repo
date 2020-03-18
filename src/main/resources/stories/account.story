Narrative:
As a user
I want to be able to change my account settings
So that I can extend my tools set for picking up exactly what I need

Scenario: save hobby settings
Given I login to my account with email bu9ira@gmail.com and password test2010
When I scroll to hobby settings and select tourism
When I click save changes button
Then I should see success saving message

Scenario: create new favorites list
Given I login to my account with email bu9ira@gmail.com and password test2010
When I click favorites link
When I click create new list button
When I enter name TestList for new favorite list and click save button
Then I should see new TestList added to favorites list


Scenario: add new item to default favorite list
Given I login to my account with email bu9ira@gmail.com and password test2010
When I click favorites link
When I count and remember amount of added items
When I enter request Samsung A50 in search field and run search
When I add fourth item from search results to default favorite list
When I click favorites link on the main page
Then I should see amount of items increased by 1