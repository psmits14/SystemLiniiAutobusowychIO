package Widok.Widok;

import Model.Model.*;

public interface WyswietlanieInformacji {

	void wyswietlOpcje();

	/**
	 * 
	 * @param liniaAutobusowa
	 */
	void wyswietlInfoLinia(LiniaAutobusowa liniaAutobusowa);

	/**
	 * 
	 * @param przystanekLinii
	 */
	void wyswietlInfoPrzystanek(PrzystanekLinii przystanekLinii);

	/**
	 * 
	 * @param waznosc
	 */
	void wyswietlInfoWaznoscBiletu(boolean waznosc);

	/**
	 * 
	 * @param osoba
	 */
	void wyswietlDaneDoWeryfikacji(Osoba osoba);

	void wyswietlBlad(String komunikat);

	void wyswietlPowodzenie(String komunikat);

	void wyswietlInformacje(String komunikat);
}