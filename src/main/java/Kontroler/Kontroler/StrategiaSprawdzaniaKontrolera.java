package Kontroler.Kontroler;

import Widok.Widok.*;
import Model.Model.*;

/**
 * Klasa implementująca interfejs {@link StrategiaSprawdzaniaBiletow}.
 * Strategia sprawdzania biletów przeznaczona dla kontrolera.
 * Uwzględnia dokładne sprawdzenie ważności biletu oraz weryfikację danych w przypadku biletów imiennych.
 */
public class StrategiaSprawdzaniaKontrolera implements StrategiaSprawdzaniaBiletow {

	private final WyswietlanieInformacji wyswietlanieInformacji;

	/**
	 * Konstruktor klasy StrategiaSprawdzaniaKontrolera.
	 *
	 * @param wyswietlanieInformacji interfejs do wyświetlania informacji
	 */
	public StrategiaSprawdzaniaKontrolera(WyswietlanieInformacji wyswietlanieInformacji) {
		this.wyswietlanieInformacji = wyswietlanieInformacji;
	}

	/**
	 * Wykonuje strategię sprawdzania biletu dla kontrolera.
	 *
	 * @param interakcjeZUzytkownikiem interfejs do interakcji z użytkownikiem
	 * @param obslugaBiletow           interfejs do obsługi biletów
	 */
	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
		wyswietlanieInformacji.wyswietlInformacje("Strategia dla Kontrolera: Dokładne sprawdzanie biletu...");

		int nrBiletu = interakcjeZUzytkownikiem.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null) {
			boolean czyWazny = obslugaBiletow.sprawdzWaznosc(nrBiletu);
			wyswietlanieInformacji.wyswietlInfoWaznoscBiletu(czyWazny);

			if (bilet.getImiennosc()) {
				wyswietlanieInformacji.wyswietlInformacje("Bilet jest imienny. Weryfikacja danych osoby...");

				Osoba osoba = bilet.getOsoba();
				if (osoba != null) {
					// Wyświetlanie danych osoby
					wyswietlanieInformacji.wyswietlDaneDoWeryfikacji(osoba);

					// Weryfikacja zgodności danych
					if (interakcjeZUzytkownikiem.zatwierdzZgodnoscOsoby()) {
						wyswietlanieInformacji.wyswietlInformacje("Zgodność danych została potwierdzona.");
					} else {
						wyswietlanieInformacji.wyswietlInformacje("Zgodność danych nie została potwierdzona. Bilet jest nieważny. Wystawianie mandatu.");
					}
				} else {
					wyswietlanieInformacji.wyswietlBlad("Brak danych osoby przypisanej do biletu.");
				}
			}
			else {
				wyswietlanieInformacji.wyswietlInformacje("Bilet jest nieimienny. ");
			}
		} else {
			wyswietlanieInformacji.wyswietlBlad("Bilet nr " + nrBiletu + " nie istnieje. Proszę o przedstawienie ważnego biletu, inaczej konieczne bedzie wystawienie mandatu");
		}
	}
}
