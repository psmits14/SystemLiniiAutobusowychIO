package testyfitnessfixture;

import fit.ColumnFixture;
import Model.Bilet;
import Model.Osoba;
import Model.Rola;

import java.time.LocalDateTime;
import java.util.IllegalFormatCodePointException;

/**
 * Klasa testowa FitNesse do jednoczesnego dodawania biletów i sprawdzania ich ważności.
 */
public class DodawanieBiletuISprawdzanieWaznosci extends ColumnFixture {

    public int nrBiletu;
    public boolean imiennosc;
    public boolean ulga;
    public String imieOsoby;
    public String nazwiskoOsoby;
    public long pesel;
    public String nrDokumentu;
    public String rola;
    public String dataWaznosci;

    /**
     * Dodaje bilet do fasady biletów.
     * @return true, jeśli bilet został dodany, false w przypadku błędu.
     */
    public boolean dodajBilet() throws IllegalFormatCodePointException {
        try {
            Osoba osoba = imiennosc ? new Osoba(imieOsoby, nazwiskoOsoby, pesel, nrDokumentu, Rola.valueOf(rola)) : null;
            LocalDateTime data = LocalDateTime.parse(dataWaznosci);

            Bilet bilet = new Bilet(nrBiletu, imiennosc, ulga, osoba, data);
            SetUp.fasadaBiletow.dodajBilet(bilet);

            return true; // Bilet dodany poprawnie
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * Sprawdza, czy dodany bilet jest ważny.
     * @return true, jeśli bilet jest ważny; false, jeśli nie istnieje lub jest nieważny.
     */
    public boolean sprawdzWaznosc() {
        return SetUp.fasadaBiletow.sprawdzWaznosc(nrBiletu);
    }

    /**
     * Metoda zamienia tekstowe "null" na faktyczny null.
     */
    private String konwertujNull(String wartosc) {
        if ("null".equalsIgnoreCase(wartosc) || wartosc == null || wartosc.trim().isEmpty()) {
            return null;
        }
        return wartosc;
    }
}
