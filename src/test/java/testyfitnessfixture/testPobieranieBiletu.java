package testyfitnessfixture;

import fit.ColumnFixture;
import Model.Bilet;
import Model.Osoba;
import Model.Rola;

import java.time.LocalDateTime;

/**
 * Klasa testowa FitNesse do pobierania biletu.
 */
public class testPobieranieBiletu extends ColumnFixture {

    public int nrBiletu; // Numer biletu do pobrania

    /**
     * Konstruktor sprawdzający, czy bilety istnieją. Jeśli nie – dodaje je.
     */
    public testPobieranieBiletu() {
        SetUp.fasadaBiletow.dodajBilet(new Bilet(10, true, false, new Osoba("Jan", "Kowalski", 99010112345L, "ABC123", Rola.Klient), LocalDateTime.now().plusDays(10)));
        SetUp.fasadaBiletow.dodajBilet(new Bilet(20, false, true, null, LocalDateTime.now().plusDays(10)));
        SetUp.fasadaBiletow.dodajBilet(new Bilet(30, true, false, new Osoba("Anna", "Nowak", 85050567890L, "XYZ456", Rola.Kontroler_biletow), LocalDateTime.now().minusDays(10))); // Ten bilet jest nieważny
    }

    /**
     * Sprawdza, czy bilet o podanym numerze istnieje.
     * @return true, jeśli bilet istnieje; false, jeśli nie.
     */
    public boolean pobierzBilet() {
        return SetUp.fasadaBiletow.pobierzBilet(nrBiletu) != null;
    }
}
