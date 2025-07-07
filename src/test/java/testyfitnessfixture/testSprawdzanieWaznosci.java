package testyfitnessfixture;

import fit.ColumnFixture;
import Model.Bilet;
import Model.Osoba;
import Model.Rola;

import java.time.LocalDateTime;

/**
 * Klasa testowa FitNesse do sprawdzania ważności biletu.
 */
public class testSprawdzanieWaznosci extends ColumnFixture {

    public int nrBiletu; // Numer biletu przekazywany w teście

    public testSprawdzanieWaznosci() {
        SetUp.fasadaBiletow.dodajBilet(new Bilet(11, true, false, new Osoba("Jan", "Kowalski", 99010112345L, "ABC123", Rola.Klient), LocalDateTime.now().plusDays(10)));
        SetUp.fasadaBiletow.dodajBilet(new Bilet(12, false, true, null, LocalDateTime.now().plusDays(10)));
        SetUp.fasadaBiletow.dodajBilet(new Bilet(13, true, false, new Osoba("Anna", "Nowak", 85050567890L, "XYZ456", Rola.Kontroler_biletow), LocalDateTime.now().minusDays(10))); // Ten bilet jest nieważny
    }
    /**
     * Metoda sprawdza, czy bilet o podanym numerze jest ważny.
     * @return true, jeśli bilet jest ważny; false, jeśli nie.
     */
    public boolean sprawdzWaznosc() {
        return SetUp.fasadaBiletow.sprawdzWaznosc(nrBiletu);
    }
}
