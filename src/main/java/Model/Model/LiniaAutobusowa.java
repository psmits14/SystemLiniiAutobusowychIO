package Model.Model;

import java.time.LocalTime;
import java.util.*;

/**
 * Klasa reprezentująca linię autobusową, zawierającą przystanki oraz przypisane pojazdy.
 */
public class LiniaAutobusowa {

	private final int nrLinii;
	private Collection<PrzystanekLinii> przystanki = new ArrayList<>();
	private Collection<Pojazd> pojazdy = new ArrayList<>();

	/**
	 * Konstruktor klasy LiniaAutobusowa.
	 *
	 * @param nrLinii Numer linii autobusowej.
	 */
	public LiniaAutobusowa(int nrLinii) {
		this.nrLinii = nrLinii;
	}

	/**
	 * Zwraca numer linii autobusowej.
	 *
	 * @return Numer linii.
	 */
	public int getNrLinii() {
		return nrLinii;
	}

	/**
	 * Zwraca kolekcję przystanków przypisanych do linii.
	 *
	 * @return Kolekcja obiektów {@link PrzystanekLinii}.
	 */
	public Collection<PrzystanekLinii> getPrzystanki() {
		return przystanki;
	}

	/**
	 * Zwraca kolekcję pojazdów przypisanych do linii.
	 *
	 * @return Kolekcja obiektów {@link Pojazd}.
	 */
	public Collection<Pojazd> getPojazdy() {
		return pojazdy;
	}

	/**
	 * Dodaje przystanek do linii autobusowej.
	 *
	 * @param nazwaPrzystanku Nazwa przystanku do dodania.
	 * @return {@code true} jeśli przystanek został dodany pomyślnie, w przeciwnym razie {@code false}.
	 */
	public boolean dodajPrzystanekDoLinii(String nazwaPrzystanku) {
		if (nazwaPrzystanku != null && !nazwaPrzystanku.isEmpty()) {
			PrzystanekLinii przystanekLinii = new PrzystanekLinii(nazwaPrzystanku, this, new ArrayList<>());
			if (!przystanki.contains(przystanekLinii)) {
				przystanki.add(przystanekLinii);
				return true;
			}
		}
		return false;
	}

	/**
	 * Wyszukuje przystanek o podanej nazwie w linii autobusowej.
	 *
	 * @param nazwaPrzystanku Nazwa przystanku do wyszukania.
	 * @return Obiekt {@link PrzystanekLinii}, jeśli przystanek został znaleziony, w przeciwnym razie {@code null}.
	 */
	public PrzystanekLinii znajdzPrzystanek(String nazwaPrzystanku) {
		if (nazwaPrzystanku == null || nazwaPrzystanku.isEmpty()) {
			return null;
		}
		for (PrzystanekLinii przystanekLinii : przystanki) {
			if (przystanekLinii.getPrzystanek().getNazwa().equalsIgnoreCase(nazwaPrzystanku)) {
				return przystanekLinii;
			}
		}
		return null;
	}

	/**
	 * Dodaje pojazd do linii autobusowej.
	 *
	 * @param nrRejestracyjny Numer rejestracyjny pojazdu.
	 * @return {@code true} jeśli pojazd został dodany pomyślnie, w przeciwnym razie {@code false}.
	 */
	public boolean dodajPojazdDoLinii(String nrRejestracyjny) {
		if (nrRejestracyjny == null || nrRejestracyjny.isEmpty()) {
			return false;
		}
		KreatorPojazdow kreator = new KreatorAutobus();
		Pojazd nowyPojazd = kreator.stworzPojazd(nrRejestracyjny);

		if (!pojazdy.contains(nowyPojazd)) {
			pojazdy.add(nowyPojazd);
			return true;
		}
		return false;
	}

	/**
	 * Dodaje godziny odjazdów dla konkretnego przystanku w linii autobusowej.
	 *
	 * @param nazwaPrzystanku Nazwa przystanku, dla którego dodawane są godziny.
	 * @param godzinyOdjazdow Kolekcja godzin odjazdów {@link LocalTime}.
	 * @return {@code true} jeśli godziny zostały dodane pomyślnie, w przeciwnym razie {@code false}.
	 */
	public boolean dodajGodzinyOdjazdowPrzystanku(String nazwaPrzystanku, Collection<LocalTime> godzinyOdjazdow) {
		if (nazwaPrzystanku == null || godzinyOdjazdow == null || godzinyOdjazdow.isEmpty()) {
			return false;
		}

		for (PrzystanekLinii przystanekLinii : przystanki) {
			if (przystanekLinii.getPrzystanek().getNazwa().equals(nazwaPrzystanku)) {
				przystanekLinii.setGodzinyOdjazdow(godzinyOdjazdow);
				return true;
			}
		}
		return false;
	}
}
