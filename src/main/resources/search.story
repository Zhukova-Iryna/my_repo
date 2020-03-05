
Narrative:
As a user
I want to be able to filter and sort the search results
So that I can find items according to my requests

Scenario: sorting price in ascending order is correct
Given I am on the search results page
When I select item and click button and open item's page
When I select tab with all price offers
When I select sorting price in ascending order
Then I should see that the prices shown in ascending order

Scenario: filtred items by producer
Given I am on the search results page
When I select producer 'Samsung' checkbox
Then I count filtered items and their quantity should correspond to the described

Scenario: relevant search results
Given I am on the start page
When I enter <request> in search field and click enter
Then I should see at list one relevant search result according to my <request>

Examples:
|request
|Samsung A50


