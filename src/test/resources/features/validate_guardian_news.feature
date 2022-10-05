Feature: Guardian valid news information

  Background:
    Given I navigate to guardian news page
    Then I verify the news page "News | The Guardian"
    Then I accept site cookie by clicking "Yes, I’m happy"

  @focus
  Scenario: valid news headline
    When I click on news heading 10
    Then I should be in a news article
    And I navigate to google search engine
    And I try to verify news headline on google search engine
    Then I should see a valid news title on google search list

  @focus
  Scenario: Searching for a invalid news
    When I click on news heading 5
    Then I should be in a news article
    When I set invalid news title as "Unknown news source that is being search for verification"
    And I navigate to google search engine
    And I try to verify news headline on google search engine
    Then I should see an invalid news title on google search list
