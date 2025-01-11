package Widok.Widok;

import java.util.*;
import Model.Model.*;

/**
 * Klasa implementująca interfejs WyswietlanieInformacji.
 * Odpowiada za wyświetlanie informacji w aplikacji, takich jak szczegóły linii,
 * przystanków, biletów oraz komunikatów o błędach lub powodzeniach.
 */
public class FasadaFabrykaWidoku implements WyswietlanieInformacji {

	/**
	 * Konstruktor domyślny klasy FasadaFabrykaWidoku.
	 */
	public FasadaFabrykaWidoku() {
	}

	/**
	 * Wyświetla dostępne opcje menu dla użytkownika.
	 */
	@Override
	public void wyswietlOpcje() {
		System.out.println("1. Dodaj linie autobusowa.");
		System.out.println("2. Wyświetl informacje o linii autobusowej.");
		System.out.println("3. Wyświetl informacje o przystanku.");
		System.out.println("4. Sprawdź ważność biletu.");
		System.out.println("5. Zakończ.");
	}

	/**
	 * Wyświetla informacje o linii autobusowej, w tym przystanki i pojazdy.
	 *
	 * @param liniaAutobusowa Obiekt linii autobusowej, dla której mają zostać wyświetlone informacje.
	 */
	@Override
	public void wyswietlInfoLinia(LiniaAutobusowa liniaAutobusowa) {
		if (liniaAutobusowa != null) {
			System.out.println("Numer linii: " + liniaAutobusowa.getNrLinii());

			System.out.println("Przystanki na linii:");
			if (liniaAutobusowa.getPrzystanki().isEmpty()) {
				wyswietlBlad("Brak przystanków przypisanych do tej linii.");
			} else {
				liniaAutobusowa.getPrzystanki().forEach(przystanek ->
						System.out.println("- " + przystanek.getPrzystanek().getNazwa()));
			}

			System.out.println("Pojazdy przypisane do linii:");
			if (liniaAutobusowa.getPojazdy().isEmpty()) {
				System.out.println("Brak pojazdów przypisanych do tej linii.");
			} else {
				liniaAutobusowa.getPojazdy().forEach(pojazd ->
						System.out.println("- Numer rejestracyjny: " + pojazd.getNrRejestracyjny()));
			}
		} else {
			wyswietlBlad("Brak danych o linii autobusowej.");
		}
	}

	/**
	 * Wyświetla informacje o przystanku, w tym jego nazwę, numer linii i godziny odjazdów.
	 *
	 * @param przystanekLinii Obiekt przystanku z przypisanymi godzinami odjazdów.
	 */
	@Override
	public void wyswietlInfoPrzystanek(PrzystanekLinii przystanekLinii) {
		if (przystanekLinii != null) {
			System.out.println("Przystanek: " + przystanekLinii.getPrzystanek().getNazwa());
			System.out.println("Numer linii: " + przystanekLinii.getLinia().getNrLinii());
			System.out.println("Godziny odjazdów:");
			przystanekLinii.getGodzinyOdjazdow().forEach(godzina ->
					System.out.println("- " + godzina));
		} else {
			wyswietlBlad("Brak danych o przystanku.");
		}
	}

	/**
	 * Wyświetla komunikat o ważności biletu.
	 *
	 * @param waznosc Wartość boolean określająca, czy bilet jest ważny.
	 */
	@Override
	public void wyswietlInfoWaznoscBiletu(boolean waznosc) {
		if (waznosc) {
			System.out.println("Bilet jest ważny. :) ");
		} else {
			System.out.println("Bilet jest nieważny. :( ");
		}
	}

	/**
	 * Wyświetla dane osoby do weryfikacji, takie jak imię, nazwisko, PESEL, numer dokumentu i rolę.
	 *
	 * @param osoba Obiekt osoby, dla której mają zostać wyświetlone dane.
	 */
	@Override
	public void wyswietlDaneDoWeryfikacji(Osoba osoba) {
		if (osoba != null) {
			System.out.println("Imię: " + osoba.getImie());
			System.out.println("Nazwisko: " + osoba.getNazwisko());
			System.out.println("PESEL: " + osoba.getPesel());
			System.out.println("Nr Dokumentu: " + osoba.getNrDokumentu());
			System.out.println("Rola: " + osoba.getRola());
		} else {
			System.out.println("Brak danych o osobie.");
		}
	}

	/**
	 * Wyświetla komunikat o błędzie.
	 *
	 * @param komunikat Treść komunikatu o błędzie.
	 */
	@Override
	public void wyswietlBlad(String komunikat) {
		System.out.println("Błąd! " + komunikat);
	}

	/**
	 * Wyświetla komunikat o powodzeniu operacji.
	 *
	 * @param komunikat Treść komunikatu o powodzeniu.
	 */
	@Override
	public void wyswietlPowodzenie(String komunikat) {
		System.out.println("Powodzenie! " + komunikat);
	}

	/**
	 * Wyświetla ogólny komunikat informacyjny.
	 *
	 * @param komunikat Treść komunikatu informacyjnego.
	 */
	@Override
	public void wyswietlInformacje(String komunikat) {
		System.out.println(komunikat);
	}
}
