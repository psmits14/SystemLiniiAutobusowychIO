import Model.Model.Bilet;
import Model.Model.Dane;
import Model.Model.FasadaBiletow;
import Model.Model.Osoba;
import mockit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Entity")
public class BiletTestMockit {

    @Mocked
    private Osoba mockedOsoba;

    @Injectable
    private Bilet mockedBilet;

    @Injectable
    private Bilet bilet2Mock;

    @Tested
    private Bilet bilet;

    @BeforeEach
    public void setUp() {
        bilet = new Bilet(1, true, false, mockedOsoba, LocalDateTime.now().plusDays(1));
    }

    @Test
    @Tag("Bilet")
    public void testWaznosciBiletowZMockiem() {
        // Symulacja metody SprawdzWaznosc
        new MockUp<Bilet>() {
            @Mock
            public boolean SprawdzWaznosc(int nrBiletu) {
                if (nrBiletu == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        assertTrue(bilet.SprawdzWaznosc(1));
        assertFalse(bilet.SprawdzWaznosc(2));
    }

    @Test
    @Tag("Bilet")
    public void testNiepoprawneBiletyZMockiem() {
        // Sprawdzanie, czy zostanie rzucony wyjątek w przypadku niepoprawnych danych
        assertThrows(IllegalArgumentException.class, () -> {
            new Bilet(-1, true, true, mockedOsoba, LocalDateTime.now().plusDays(1));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Bilet(1, null, true, mockedOsoba, LocalDateTime.now().plusDays(1));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Bilet(1, true, null, mockedOsoba, LocalDateTime.now().plusDays(1));
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Bilet(1, true, true, mockedOsoba, null);
        });
    }

    @Test
    @Tag("Fasada")
    public void testSprawdzWaznoscBiletuFasada() {
        // Ustawienie danych dla biletów
        int nrBiletu1 = 1;
        int nrBiletu2 = 2;

        // Ustawienie mocków
        new Expectations() {{
            mockedBilet.getNrBiletu(); result = nrBiletu1;
            mockedBilet.SprawdzWaznosc(nrBiletu1); result = true;  // Pierwszy bilet jest ważny

            bilet2Mock.getNrBiletu(); result = nrBiletu2;
            bilet2Mock.SprawdzWaznosc(nrBiletu2); result = false; // Drugi bilet nie jest ważny
        }};

        // Tworzymy instancję fasady
        FasadaBiletow fasadaBiletow = new FasadaBiletow();

        // Dodajemy mockowane bilety do fasady
        fasadaBiletow.dodajBilet(mockedBilet);
        fasadaBiletow.dodajBilet(bilet2Mock);

        // Testowanie sprawdzania ważności
        assertTrue(fasadaBiletow.sprawdzWaznosc(nrBiletu1));  // Pierwszy bilet jest ważny
        assertFalse(fasadaBiletow.sprawdzWaznosc(nrBiletu2)); // Drugi bilet nie jest ważny
    }


    @Test
    @Tag("Fasada")
    public void testPobierzBiletZMockiem() {
        int nrBiletu = 5665;

        // Ustawienie mocka
        new Expectations() {{
            mockedBilet.getNrBiletu(); result = nrBiletu;
        }};

        // Tworzymy instancję fasady
        FasadaBiletow fasadaBiletow = new FasadaBiletow();

        // Dodajemy bilet do fasady
        fasadaBiletow.dodajBilet(mockedBilet);

        // Testowanie pobierania biletu
        Bilet biletPobrany = fasadaBiletow.pobierzBilet(nrBiletu);
        assertNotNull(biletPobrany); // Bilet powinien zostać pobrany
        assertEquals(nrBiletu, biletPobrany.getNrBiletu()); // Numer biletu powinien się zgadzać
    }

    @Test
    @Tag("Fasada")
    public void testDodajBiletZMockiem() {
        int nrBiletu = 2356;

        // Ustawienie mocka
        new Expectations() {{
            mockedBilet.getNrBiletu(); result = nrBiletu; // Ustawienie wartości zwracanej przez mocka
        }};

        // Tworzymy instancję fasady
        FasadaBiletow fasadaBiletow = new FasadaBiletow();

        // Dodajemy mockowany bilet do fasady
        fasadaBiletow.dodajBilet(mockedBilet);

        // Testowanie dodawania biletu
        Bilet biletPobrany = fasadaBiletow.pobierzBilet(nrBiletu);
        assertNotNull(biletPobrany);  // Bilet powinien zostać pobrany
        assertEquals(nrBiletu, biletPobrany.getNrBiletu()); // Numer biletu powinien się zgadzać
    }

    @Test
    @Tag("Fasada")
    public void testDodajBiletZDuplikatemZMockiem() {
        Bilet bilet1 = new Bilet(123, true, false, mockedOsoba, LocalDateTime.now().plusDays(1));
        Bilet bilet2 = new Bilet(123, true, false, mockedOsoba, LocalDateTime.now().plusDays(1));

        FasadaBiletow fasadaBiletow = new FasadaBiletow();

        // Dodajemy pierwszy bilet
        fasadaBiletow.dodajBilet(bilet1);

        // Sprawdzamy, czy pojawi się wyjątek przy dodawaniu duplikatu
        assertThrows(IllegalArgumentException.class, () -> {
            fasadaBiletow.dodajBilet(bilet2);
        });
    }
}


/*@Tag("Entity")
public class BiletTestMockit {

    @Mocked
    private Osoba mockedOsoba;

    @Injectable
    private Dane dane;

    @Tested
    private Bilet bilet = new Bilet(1, true, false, new Osoba("Jan", "Kowalski", 12345678901L, "ul. Przykładowa 1", Rola.Klient), LocalDateTime.now().plusDays(1));

    @Test
    public void testWaznosciBiletowZMockiem() {
        // Zamiast polegać na @Tested, tworzymy obiekt ręcznie, aby zainicjować jego zależności
        //Bilet bilet = new Bilet(1, true, false, mockedOsoba, LocalDateTime.now().plusDays(1));

        // Symulacja metody SprawdzWaznosc
        new MockUp<Bilet>() {
            @Mock
            public boolean SprawdzWaznosc(int nrBiletu) {
                if (nrBiletu == 1) {
                    return true;  // Symulacja pozytywnego wyniku
                } else {
                    return false;  // Symulacja negatywnego wyniku
                }
            }
        };

        // Testowanie metody
        assertTrue(bilet.SprawdzWaznosc(1));
    }

    @Test
    public void testNiepoprawneBiletyZMockiem() {
        // Sprawdzanie, czy zostanie rzucony wyjątek w przypadku niepoprawnych danych
        assertThrows(IllegalArgumentException.class, () -> {
            new Bilet(-1, null, true, null, LocalDateTime.now().plusDays(1));
        });
    }
}*/
