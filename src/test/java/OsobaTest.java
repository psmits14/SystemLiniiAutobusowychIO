

import Model.Model.Dane;
import Model.Model.Osoba;
import Model.Model.Rola;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class OsobaTest implements TestExecutionExceptionHandler {

    Dane dane;
    private List<String> oczekiwaneImiona;
    private List<String> oczekiwaneNazwiska;
    private List<Long> oczekiwanePesel;
    private List<String> oczekiwaneNrDokumentu;
    private List<Rola> oczekiwaneRole;
    private Osoba[] osobyPoprawne;

    @BeforeEach
    public void setUp() {
        Dane dane = new Dane();
        osobyPoprawne = dane.osobyPoprawne;
        oczekiwaneImiona = dane.oczekiwaneImiona;
        oczekiwaneNazwiska = dane.oczekiwaneNazwiska;
        oczekiwanePesel = dane.oczekiwanePesel;
        oczekiwaneNrDokumentu = dane.oczekiwaneNrDokumentu;
        oczekiwaneRole = dane.oczekiwaneRole;
    }

    @Test
    @Tag("Pozytywny")
    public void testPoprawneDaneOsob() {
        for (int i = 0; i < osobyPoprawne.length; i++) {
            Osoba osoba = osobyPoprawne[i];
            assertEquals(oczekiwaneImiona.get(i), osoba.getImie(), "Niepoprawne imię");
            assertEquals(oczekiwaneNazwiska.get(i), osoba.getNazwisko(), "Niepoprawne nazwisko");
            assertEquals(oczekiwanePesel.get(i), osoba.getPesel(), "Niepoprawny PESEL");
            assertEquals(oczekiwaneNrDokumentu.get(i), osoba.getNrDokumentu(), "Niepoprawny numer dokumentu");
            assertEquals(oczekiwaneRole.get(i), osoba.getRola(), "Niepoprawna rola");
        }
    }

    @ParameterizedTest
    @Tag("Wyjatek")
    @Tag("NieoprawnoscDanych")
    @ExtendWith(OsobaTest.class)
    @MethodSource("provideNiepoprawneDaneOsob")
    public void testNiepoprawneDaneOsob(String imie, String nazwisko, long pesel, String nrDokumentu, Rola rola) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Osoba(imie, nazwisko, pesel, nrDokumentu, rola);
        });
    }

    private static Stream<Arguments> provideNiepoprawneDaneOsob() {
        return Stream.of(
                Arguments.of("", "Zieliński", 11122233344L, "QWE111222", Rola.Kierowca),    // Puste imię
                Arguments.of("Piotr", "", 11122233344L, "QWE111222", Rola.Kierowca),        // Puste nazwisko
                Arguments.of("Anna", "Nowak", -987654321L, "XYZ987654", Rola.Koordynator),  // PESEL ujemny
                Arguments.of("Jan", "Kowalski", 123456L, "ABC123456", Rola.Klient),         // PESEL za krótki
                Arguments.of("Jan", "Kowalski", 1234567890123L, "ABC123456", Rola.Klient),  // PESEL za długi
                Arguments.of("Jan", "Kowalski", 12345678900L, "", Rola.Klient),             // Pusty numer dokumentu
                Arguments.of("Jan", "Kowalski", 12345678900L, "ABC123456", null)            // Rola null
        );
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalFormatCodePointException) {
            System.out.println("Obsłużono wyjątek IllegalFormatCodePointException: " + throwable.getMessage());
        } else {
            throw throwable;
        }
    }
}
