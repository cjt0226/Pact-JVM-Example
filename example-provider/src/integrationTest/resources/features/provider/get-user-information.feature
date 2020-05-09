Feature: Get Information By Name

  Scenario Outline: Get Information
    Given <user> is in the system
    When Anyone get the <user> information
    Then Anyone should be able to see the information
      | name                 | <name>                 |
      | nationality          | <nationality>          |
      | salary               | <salary>               |
      | contact.Email        | <contact.Email>        |
      | contact.Phone Number | <contact.Phone Number> |


    Examples:
      | user   | name             | nationality | salary | contact.Email               | contact.Phone Number |
      | Miku   | Hatsune Miku     | Japan       | 45000  | hatsune.miku@ariman.com     | 9090950              |
      | Nanoha | Takamachi Nanoha | Japan       | 80000  | takamachi.nanoha@ariman.com | 9090940              |

