

import Model.Model.Bilet;
import Model.Model.Dane;
import Model.Model.FasadaBiletow;
import Model.Model.Osoba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class FasadaBiletowTest implements TestExecutionExceptionHandler {

    private FasadaBiletow fasada;
    private Dane dane;

    @BeforeEach
    public void setUp() {
        fasada = new FasadaBiletow();
        dane = new Dane();
        for (Bilet bilet : dane.bilety) {
            fasada.dodajBilet(bilet);
        }
    }


    // Test sprawdzający ważność biletów
    @ParameterizedTest
    @Tag("Pozytywny")
    @CsvSource({
            "1, true",
            "2, false",
            "3, false",
            "4, true",
            "5, false"  //sprawdzenie dla biletu nieistniejacego
    })
    public void testSprawdzWaznosc(int nrBiletu, boolean oczekiwanyWynik) {
        boolean wynik = fasada.sprawdzWaznosc(nrBiletu);
        assertEquals(oczekiwanyWynik, wynik, "Niepoprawny wynik dla biletu nr " + nrBiletu);
    }

    // Test pobierania istniejących biletów
    @Test
    @Tag("Pozytywny")
    public void testPobierzBiletIstniejacy() {
        Bilet bilet = fasada.pobierzBilet(1);
        assertNotNull(bilet, "Bilet nr 1 powinien istnieć.");
        assertEquals(1, bilet.getNrBiletu(), "Niepoprawny numer biletu.");
    }

    //Test pobierania nieistniejącego biletu
    @Test
    @Tag("Pozytywny")
    public void testPobierzBiletNieistniejacy() {
        Bilet bilet = fasada.pobierzBilet(999);
        assertNull(bilet, "Bilet nr 999 nie powinien istnieć.");
    }

    // Test dodawania biletu do kolekcji
    @Test
    @Tag("Pozytywny")
    public void testDodajBilet() {
        Bilet nowyBilet = new Bilet(5, false, false, null, LocalDateTime.now().plusDays(2));
        fasada.dodajBilet(nowyBilet);
        assertNotNull(fasada.pobierzBilet(5), "Bilet nr 5 powinien zostać dodany.");
    }

    //Test dodawania nullowego biletu
    @Test
    @Tag("Wyjatek")
    @ExtendWith(FasadaBiletowTest.class)
    public void testDodajNullBilet() {
        assertThrows(IllegalArgumentException.class, () -> fasada.dodajBilet(null), "Oczekiwano wyjątku dla nullowego biletu");
    }

    @Test
    @Tag("Wyjatek")
    @ExtendWith(FasadaBiletowTest.class)
    public void testDodajBiletIstniejacyNumer() {
        Bilet nowyBilet = new Bilet(1, false, false, null, LocalDateTime.now().plusDays(2));
        assertThrows(IllegalArgumentException.class, () -> fasada.dodajBilet(nowyBilet),
                "Dodanie biletu z istniejącym numerem powinno rzucić wyjątek.");
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
