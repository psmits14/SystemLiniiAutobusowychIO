# System Informacyjny Linii Autobusowych

## Opis projektu

Projekt System Informacyjny Linii Autobusowych został wykonany w ramach przedmiotu Inżynieria Oprogramowania, którego celem było zapoznanie się z zaawansowanymi koncepcjami projektowania oprogramowania, w szczególności wzorcami projektowymi, architekturą warstwową (MVC) oraz metodologią wytwarzania oprogramowania.

Aplikacja umożliwia kompleksowe zarządzanie liniami autobusowymi, przystankami, biletami oraz użytkownikami systemu. Została zrealizowana w języku Java z wykorzystaniem wzorców projektowych, takich jak Fasada, Strategia i Fabryka Abstrakcyjna, co zapewnia modularność, elastyczność i łatwość przyszłej rozbudowy systemu.

W trakcie realizacji projektu wykorzystano narzędzie Visual Paradigm do tworzenia różnorodnych diagramów UML oraz makiet interfejsu użytkownika, co pozwoliło na dokładne zaplanowanie architektury systemu przed implementacją. Umieszczono je w folderze Diagramy.
## Funkcjonalności

- **Zarządzanie liniami autobusowymi**: Dodawanie, modyfikowanie i usuwanie linii, przystanków oraz godzin odjazdów.
- **Obsługa biletów**: Sprawdzanie ważności biletów, zarządzanie biletami imiennymi i jednorazowymi.
- **Zarządzanie użytkownikami**: Przypisywanie ról (Klient, Kierowca, Kontroler, Koordynator) oraz uprawnień.
- **Interakcja z użytkownikiem**: Intuicyjny interfejs do przeglądania informacji o liniach, przystankach i biletach.

## Architektura

Projekt został zaimplementowany w architekturze warstwowej (MVC) z podziałem na:
- **Warstwa modelu**: Zawiera klasy reprezentujące dane, takie jak `Bilet`, `Osoba`, `LiniaAutobusowa`, `Przystanek`.
- **Warstwa kontrolera**: Zarządza logiką biznesową, wykorzystując wzorce takie jak Strategia i Fasada.
- **Warstwa widoku**: Odpowiada za interakcję z użytkownikiem i wyświetlanie informacji.

## Wykorzystane wzorce projektowe

- **Fasada**: Uproszczenie interakcji z systemem poprzez centralne punkty dostępu (np. `FasadaBiletow`, `FasadaLini`).
- **Strategia**: Dynamiczne wybieranie algorytmów sprawdzania biletów w zależności od roli użytkownika.
- **Fabryka Abstrakcyjna**: Tworzenie obiektów pojazdów bez ujawniania ich konkretnych klas.

## Testowanie

W projekcie zaimplementowano testy jednostkowe oraz testy FitNesse, aby zapewnić poprawność działania systemu. Testy jednostkowe obejmują m.in. klasy `Bilet`, `FasadaBiletow` i `Osoba`. Stworzono również zestawy testów `TestSuide`. Testy FitNesse służą do weryfikacji funkcjonalności systemu w bardziej złożonych scenariuszach.

## Wymagania systemowe

- Java 8 lub nowsza.
- System operacyjny: Windows/Linux/macOS.
- Zalecane środowisko developerskie: IntelliJ IDEA lub Eclipse.

## Instrukcja uruchomienia

1. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/psmits14/IO
   ```
2. Otwórz projekt w wybranym środowisku developerskim.
3. Skompiluj i uruchom aplikację.

## Autorzy
- Patrycja Smits
- Julia Krok
