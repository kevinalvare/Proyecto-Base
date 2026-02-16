Feature: Search by keyword

  @green
  Scenario: Searching for 'fish'
    Given Sergey is researching things on the internet
    When Sergey looks up "fish"
    Then Sergey should see information about "fish"

  @red
  Scenario: Searching for 'dog'
    Given Sergey is researching things on the internet
    When Sergey looks up "dog"
    Then Sergey should see information about "dog"

  @blue
  Scenario: Searching for 'cat'
    Given Sergey is researching things on the internet
    When Sergey looks up "cat"
    Then Sergey should see information about "cat"
