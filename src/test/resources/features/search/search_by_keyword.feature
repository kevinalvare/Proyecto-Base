Feature: Search by keyword

  @green
  Scenario: Searching for 'green'
    Given Sergey is researching things on the internet
    When Sergey looks up "green"
    Then Sergey should see information about "green"

  @red
  Scenario: Searching for 'red'
    Given Sergey is researching things on the internet
    When Sergey looks up "red"
    Then Sergey should see information about "red"

  @blue
  Scenario: Searching for 'blue'
    Given Sergey is researching things on the internet
    When Sergey looks up "blue"
    Then Sergey should see information about "blue"
