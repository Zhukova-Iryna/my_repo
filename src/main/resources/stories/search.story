Narrative:
As a user
I want to be able to filter and sort the search results
So that I can find items according to my requests

Scenario: relevant search request results
Given I am on the main page and run search by request Samsung A50
Then I should see at list 1 relevant result according to request Samsung A50

Scenario: sorting price in ascending order is correct
Given I am on the main page and run search by request Samsung A50
When I select item and click button and open item's page
When I select tab with all price offers
When I select sorting price in ascending order
Then I should see that the prices shown in ascending order

Scenario: filtered items by producer
Given I am on the main page and run search by request Samsung A50
When I select producer Samsung checkbox
Then I count filtered items and their quantity should correspond to the described

Scenario: filtered items by price range
Given I am on the main page and run search by request Samsung A50
When I enter 200 and 400 in price range inputs and submit filtration
Then I should only see the items in price range from 200 to 400


