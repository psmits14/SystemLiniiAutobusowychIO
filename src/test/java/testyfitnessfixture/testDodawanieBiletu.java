package testyfitnessfixture;

import Model.Bilet;
import Model.Osoba;
import Model.Rola;
import fit.ColumnFixture;

import java.time.LocalDateTime;
import java.util.IllegalFormatCodePointException;

/**
 * Klasa testowa FitNesse do dodawania biletów do FasadaBiletow.
 */
public class testDodawanieBiletu extends ColumnFixture {

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
     * @throws IllegalFormatCodePointException jeśli dane wejściowe są niepoprawne.
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
}
