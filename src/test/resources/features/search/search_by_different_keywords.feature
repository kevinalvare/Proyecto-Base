Feature: Search by keyword

  @green
  Scenario: Searching for 'apple'
    Given Sergey is researching things on the internet
    When Sergey looks up "apple"
    Then Sergey should see information about "apple"

  @red
  Scenario: Searching for 'orange'
    Given Sergey is researching things on the internet
    When Sergey looks up "orange"
    Then Sergey should see information about "orange"


  @blue
  Scenario: Searching for 'lemon'
    Given Sergey is researching things on the internet
    When Sergey looks up "lemon"
    Then Sergey should see information about "lemon"
