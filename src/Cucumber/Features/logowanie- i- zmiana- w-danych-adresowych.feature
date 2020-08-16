Feature: Zadanie1
  Scenario Outline: user loguje sie danymi zdefniwanymi przez testera
    Given otwieramy przegladarke i wchodzimy odpowiednią stronę
    When  podajemy dane do zalogowania email i password
    Then  Uzytkownik jest zalogowany
    When przechodzimy do strony z adresmai i klikamy +Create New Address
    Then  wypełniamy formularz danymi z "<alias>","<address>", "<zipCode>", "<city>", "<country>"
    And  Sprawdzamy czy dane są poprawne "<alias>","<address>", "<zipCode>", "<city>", "<country>"
    And Zamykamy przeglądarke

    Examples:
      | alias     | address      | zipCode | city     | country       |
      | CodersLab | ul.Prosta 51 | 00-000  | Warszawa | United Kingdom |