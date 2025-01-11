package Model.Model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Klasa reprezentująca przystanek przypisany do konkretnej linii autobusowej.
 * Zawiera informacje o godzinach odjazdów oraz o linii, do której przystanek należy.
 */
public class PrzystanekLinii extends Przystanek {

	/** Linia autobusowa, do której przystanek jest przypisany. */
	private LiniaAutobusowa linia;

	/** Kolekcja godzin odjazdów dla przystanku. */
	private Collection<LocalTime> godzinyOdjazdow = new ArrayList<>();

	/**
	 * Konstruktor klasy PrzystanekLinii.
	 *
	 * @param nazwaPrzystanku Nazwa przystanku.
	 * @param linia Linia autobusowa, do której przystanek jest przypisany.
	 * @param godzinyOdjazdow Kolekcja godzin odjazdów dla przystanku.
	 */
	public PrzystanekLinii(String nazwaPrzystanku, LiniaAutobusowa linia, Collection<LocalTime> godzinyOdjazdow) {
		super(nazwaPrzystanku); // Wywołanie konstruktora klasy nadrzędnej (Przystanek)
		this.linia = linia;
		if (godzinyOdjazdow != null) {
			this.godzinyOdjazdow = godzinyOdjazdow;
		}
	}

	/**
	 * Zwraca linię autobusową, do której przystanek jest przypisany.
	 *
	 * @return Linia autobusowa.
	 */
	public LiniaAutobusowa getLinia() {
		return linia;
	}

	/**
	 * Ustawia linię autobusową dla przystanku.
	 *
	 * @param linia Nowa linia autobusowa.
	 */
	public void setLinia(LiniaAutobusowa linia) {
		this.linia = linia;
	}

	/**
	 * Zwraca kolekcję godzin odjazdów przypisanych do przystanku.
	 *
	 * @return Kolekcja godzin odjazdów.
	 */
	public Collection<LocalTime> getGodzinyOdjazdow() {
		return godzinyOdjazdow;
	}

	/**
	 * Ustawia kolekcję godzin odjazdów dla przystanku.
	 *
	 * @param godzinyOdjazdow Nowa kolekcja godzin odjazdów.
	 */
	public void setGodzinyOdjazdow(Collection<LocalTime> godzinyOdjazdow) {
		if (godzinyOdjazdow != null) {
			this.godzinyOdjazdow = godzinyOdjazdow;
		}
	}

	/**
	 * Zwraca obiekt przystanku (this), który dziedziczy po klasie Przystanek.
	 *
	 * @return Obiekt przystanku.
	 */
	public Przystanek getPrzystanek() {
		return this;
	}
}
