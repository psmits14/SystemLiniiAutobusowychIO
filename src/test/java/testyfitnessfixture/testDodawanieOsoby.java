package testyfitnessfixture;

import Model.Osoba;
import Model.Rola;
import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

/**
 * Klasa testowa FitNesse do dodawania osób.
 */
public class testDodawanieOsoby extends ColumnFixture {

    public String imie;
    public String nazwisko;
    public long pesel;
    public String nrDokumentu;
    public String rola;

    /**
     * Konstruktor resetujący wartości pól, aby uniknąć nadpisywania.
     */
    public testDodawanieOsoby() {
        imie = null;
        nazwisko = null;
        pesel = 0;
        nrDokumentu = null;
        rola = null;
    }

    /**
     * Test dodawania osoby do systemu.
     * @return true, jeśli osoba została poprawnie dodana; false, jeśli wystąpił błąd.
     * @throws IllegalFormatCodePointException w przypadku niepoprawnych danych.
     */
    public boolean dodajOsobe() throws IllegalFormatCodePointException {
        try {
            // **Zamiana pustych wartości na rzeczywiste `null`**
            if ("null".equals(imie)) imie = null;
            if ("null".equals(nazwisko)) nazwisko = null;
            if ("null".equals(nrDokumentu)) nrDokumentu = null;

            // Tworzenie obiektu Osoba
            Osoba osoba = new Osoba(imie, nazwisko, pesel, nrDokumentu, Rola.valueOf(rola));

            return osoba != null; // Jeśli obiekt został utworzony, zwracamy true
        } catch (IllegalArgumentException e) {
            return false; // Jeśli wystąpił wyjątek, zwracamy false
        }
    }
}
