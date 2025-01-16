import Model.Model.Bilet;
import Model.Model.Dane;
import Model.Model.Osoba;
import Model.Model.Rola;
import mockit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Entity")
public class BiletTestMockit {

    @Mocked
    private Osoba mockedOsoba;

    @Injectable
    private Dane dane;

    @Tested
    private Bilet bilet;

    @BeforeEach
    public void setUp() {
        bilet = new Bilet(1, true, false, mockedOsoba, LocalDateTime.now().plusDays(1));
    }

    @Test
    public void testWaznosciBiletowZMockiem() {
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
            new Bilet(-1, true, true, mockedOsoba, LocalDateTime.now().plusDays(1));
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
