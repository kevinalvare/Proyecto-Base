Feature: Search by keywords (outline)

  @outline
  Scenario Outline: Searching for different keywords
    Given Sergey is researching things on the internet
    When Sergey looks up "<keyword>"
    Then Sergey should see information about "<keyword>"

    Examples:
      | keyword |
      | fish    |
      | dog     |
      | cat     |

