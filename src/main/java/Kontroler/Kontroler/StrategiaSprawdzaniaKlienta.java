package Kontroler.Kontroler;

import Model.Model.*;
import Widok.Widok.*;

/**
 * Klasa implementująca interfejs {@link StrategiaSprawdzaniaBiletow}.
 * Klasa implementująca strategię sprawdzania ważności biletu dla klienta.
 */
public class StrategiaSprawdzaniaKlienta implements StrategiaSprawdzaniaBiletow {

	private final WyswietlanieInformacji wyswietlanieInformacji;

	/**
	 * Konstruktor klasy StrategiaSprawdzaniaKlienta.
	 *
	 * @param wyswietlanieInformacji interfejs do wyświetlania informacji
	 */
	public StrategiaSprawdzaniaKlienta(WyswietlanieInformacji wyswietlanieInformacji) {
		this.wyswietlanieInformacji = wyswietlanieInformacji;
	}

	/**
	 * Wykonuje strategię sprawdzania ważności biletu.
	 *
	 * @param interakcjeZUzytkownikiem interfejs do interakcji z użytkownikiem
	 * @param obslugaBiletow           interfejs do obsługi biletów
	 */
	@Override
	public void wykonajStrategie(InterakcjeZUzytkownikiem interakcjeZUzytkownikiem, ObslugaBiletow obslugaBiletow) {
		wyswietlanieInformacji.wyswietlInformacje("Strategia dla Klienta: Sprawdzanie biletu...");

		int nrBiletu = interakcjeZUzytkownikiem.podajNrBiletu();
		Bilet bilet = obslugaBiletow.pobierzBilet(nrBiletu);

		if (bilet != null) {
			boolean czyWazny = obslugaBiletow.sprawdzWaznosc(nrBiletu);
			wyswietlanieInformacji.wyswietlInfoWaznoscBiletu(czyWazny);

			if (czyWazny) {
				wyswietlanieInformacji.wyswietlInformacje("Bilet ważny do: " + bilet.getDataWaznosci());
			}
		} else {
			wyswietlanieInformacji.wyswietlBlad("Bilet nr " + nrBiletu + " nie istnieje.");
		}
	}
}
