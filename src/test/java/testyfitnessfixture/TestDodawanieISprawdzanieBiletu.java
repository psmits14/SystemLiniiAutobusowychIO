package testyfitnessfixture;

import fit.ColumnFixture;

/**
 * Klasa testowa łącząca dodawanie biletów i sprawdzanie ich ważności.
 */
public class TestDodawanieISprawdzanieBiletu extends ColumnFixture {

    public int nrBiletu; // Numer biletu przekazywany w teście

    /**
     * Wykorzystuje istniejący test dodawania biletów.
     * @return true, jeśli bilet został dodany, false w przypadku błędu.
     */
    public boolean pobierzBilet() {
        return SetUp.fasadaBiletow.pobierzBilet(nrBiletu) != null;
    }

    /**
     * Wykorzystuje istniejący test sprawdzania ważności biletów.
     * @return true, jeśli bilet jest ważny; false, jeśli nie.
     */
    public boolean sprawdzWaznosc() {
        return SetUp.fasadaBiletow.sprawdzWaznosc(nrBiletu);
    }
}
