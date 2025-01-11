package Model.Model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Dane {

    public static final Osoba[] osobyPoprawne = {
            new Osoba("Jan", "Kowalski", 12345678900L, "ABC123456", Rola.Klient),
            new Osoba("Anna", "Nowak", 98765432100L, "XYZ987654", Rola.Klient),
            new Osoba("Piotr", "Zieliński", 11122233300L, "QWE111222", Rola.Kierowca)
    };

    public static final List<Object[]> osobyNiepoprawne = Arrays.asList(
            new Object[]{"Anna", "Nowak", -987654321L, "XYZ987654", Rola.Koordynator},   // PESEL ujemny
            new Object[]{"", "Zieliński", 11122233344L, "QWE111222", Rola.Kierowca},     // Puste imię
            new Object[]{"Piotr", "", 11122233344L, "QWE111222", Rola.Kierowca},         // Puste nazwisko
            new Object[]{"Jan", "Kowalski", 123456L, "ABC123456", Rola.Klient},          // PESEL zbyt krótki
            new Object[]{"Jan", "Kowalski", 1234567890123L, "ABC123456", Rola.Klient},   // PESEL zbyt długi
            new Object[]{"Jan", "Kowalski", 12345678900L, "", Rola.Klient},              // Pusty numer dokumentu
            new Object[]{"Jan", "Kowalski", 12345678900L, "ABC123456", null}             // Null w roli
    );

        public static final List<String> oczekiwaneImiona = Arrays.asList(
                "Jan",
                "Anna",
                "Piotr"
        );

        public static final List<String> oczekiwaneNazwiska = Arrays.asList(
                "Kowalski",
                "Nowak",
                "Zieliński"
        );

        public static final List<Long> oczekiwanePesel = Arrays.asList(
                12345678900L,
                98765432100L,
                11122233300L
        );

        public static final List<String> oczekiwaneNrDokumentu = Arrays.asList(
                "ABC123456",
                "XYZ987654",
                "QWE111222"
        );

        public static final List<Rola> oczekiwaneRole = Arrays.asList(
                Rola.Klient,
                Rola.Klient,
                Rola.Kierowca
        );


    public static final Bilet[] bilety = new Bilet[]{
            new Bilet(1, true, false, osobyPoprawne[0], LocalDateTime.now().plusDays(5)),
            new Bilet(2, true, true, osobyPoprawne[1], LocalDateTime.now().minusDays(3)),
            new Bilet(3, false, false, null, LocalDateTime.now().minusDays(1)),
            new Bilet(4, false, false, null, LocalDateTime.now().plusDays(10))
    };
    //Tablica wyników czy bilety są ważne
    public static final boolean[] oczekiwaneWynikiBilety = {true, false, false, true};

}
