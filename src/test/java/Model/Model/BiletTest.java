package Model.Model;

import Model.Model.Bilet;
import Model.Model.Dane;
import Model.Model.Osoba;
import Model.Model.Rola;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BiletTest implements TestExecutionExceptionHandler {

    private Bilet[] bilety;
    private boolean[] oczekiwaneWynikiWaznosci;
    private Dane dane;

    @BeforeEach
    public void setUp() {
        dane = new Dane();
        bilety = dane.bilety;
        oczekiwaneWynikiWaznosci = dane.oczekiwaneWynikiBilety;
    }

    // Test sprawdzający ważność biletów
    @Test
    @Tag("Pozytywny")
    public void testWaznosciBiletow() {
        for (int i = 0; i < bilety.length; i++) {
            Bilet bilet = bilety[i];
            boolean wynik = bilet.SprawdzWaznosc(bilet.getNrBiletu());
            boolean oczekiwanyWynik = oczekiwaneWynikiWaznosci[i];
            assertEquals(oczekiwanyWynik, wynik, "Błąd w sprawdzaniu ważności biletu nr " + bilet.getNrBiletu());
        }
    }

    // Test sprawdzający poprawne dane biletów
    @Test
    @Tag("Pozytywny")
    @Tag("PoprawnoscDanych")
    public void testPoprawneDaneBiletow() {
        for (int i = 0; i < bilety.length; i++) {
            Bilet bilet = bilety[i];
            assertEquals(i + 1, bilet.getNrBiletu(), "Niepoprawny numer biletu");
            assertNotNull(bilet.getDataWaznosci(), "Data ważności nie powinna być null");
            assertEquals(oczekiwaneWynikiWaznosci[i], bilet.SprawdzWaznosc(bilet.getNrBiletu()), "Niepoprawna ważność biletu");

            // Sprawdzanie pól `imienność` i `ulga`
            assertNotNull(bilet.getImiennosc(), "Pole imienność nie powinno być null");
            assertNotNull(bilet.getUlga(), "Pole ulga nie powinno być null");
        }
    }

    // Test parametryzowany sprawdzający ważność biletu
    @ParameterizedTest
    @Tag("Pozytywny")
    @MethodSource("provideBiletyTestData")
    public void testSprawdzWaznosc(int nrBiletu, boolean oczekiwanyWynik) {
        Bilet bilet = bilety[nrBiletu - 1];
        boolean wynik = bilet.SprawdzWaznosc(nrBiletu);
        assertEquals(oczekiwanyWynik, wynik, "Niepoprawny wynik dla biletu nr " + nrBiletu);
    }

    // Metoda dostarczająca dane do testu parametryzowanego
    private static Stream<Arguments> provideBiletyTestData() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true)
        );
    }

    // Test parametryzowany sprawdzający niepoprawne bilety
    @ParameterizedTest
    @Tag("Wyjatek")
    @Tag("NieoprawnoscDanych")
    @ExtendWith(BiletTest.class)
    @MethodSource("provideNiepoprawneBilety")
    public void testNiepoprawneBilety(int nrBiletu, Boolean  imiennosc, Boolean ulga, Osoba osoba, LocalDateTime dataWaznosci) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Bilet(nrBiletu, imiennosc, ulga, osoba, dataWaznosci);
        }, "Oczekiwano wyjątku dla niepoprawnych danych biletu.");
    }

    // Metoda dostarczająca dane do testu niepoprawnych biletów
    private static Stream<Arguments> provideNiepoprawneBilety() {
        return Stream.of(
                Arguments.of(-1, true, false, null, LocalDateTime.now().plusDays(1)),       // Brak numeru biletu
                Arguments.of(1, true, false, null, null),                                   // Brak daty ważności
                Arguments.of(1, null, true, null, LocalDateTime.now().plusDays(1)),         // Ulga ustawiona na null
                Arguments.of(1, true, null, null, LocalDateTime.now().plusDays(1)),         // Imiennosc ustawiona na null
                Arguments.of(1, true, false, null, LocalDateTime.now().plusDays(1))        // Bilet imienny, ale brak przypisanej osoby
        );
    }

    // Obsługa wyjątków
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalArgumentException) {
            System.out.println("Obsłużono wyjątek: " + throwable.getMessage());
        } else {
            throw throwable;
        }
    }
}
