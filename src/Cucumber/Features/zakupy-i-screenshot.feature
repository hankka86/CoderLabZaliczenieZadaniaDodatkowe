Feature: Zadanie2

  Scenario: user kupuje 5 szt przedmiotów ze sklepu z rabarem 20%, wybiera metode platnosci i adres dostawy, na koniec robi screenshota
    Given otwieramy przegladarke i logujemy sie na konto Antonio Banderasa
    When wybieramy sweter do zakupu
    Then wybieramy rozmiar "M"
    Then wybieramy 5 szt
    Then dodajemy do koszyka
    Then przechodzimy do checkout
    Then potwierdzamy adres
    Then wybieramy metodę odbioru - PrestaShop "pick un in store"
    Then wybieramy metodę płatnosci "Pay by Check"
    Then klikamy w "order with an obligation to pay"
    Then robimy screenshota
    Then wchodzimy w historie zamówień i detale
    Then sprawdzamy czy zamówienie ma status "Awaiting check payment", oraz czy kwota sie zgadza
    And Zamykamy przeglądarkę

