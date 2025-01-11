package Model.Model;

import java.util.Objects;

/**
 * Klasa reprezentująca pojazd przypisany do linii autobusowej.
 * Każdy pojazd jest identyfikowany przez unikalny numer rejestracyjny.
 */
public abstract class Pojazd {

	/** Numer rejestracyjny pojazdu. */
	private String nrRejestracyjny = "";

	/**
	 * Zwraca numer rejestracyjny pojazdu.
	 *
	 * @return Numer rejestracyjny pojazdu.
	 */
	public String getNrRejestracyjny() {
		return nrRejestracyjny;
	}

	/**
	 * Ustawia numer rejestracyjny pojazdu.
	 *
	 * @param nrRejestracyjny Nowy numer rejestracyjny pojazdu.
	 */
	public void setNrRejestracyjny(String nrRejestracyjny) {
		this.nrRejestracyjny = nrRejestracyjny;
	}

	/**
	 * Porównuje bieżący obiekt z innym obiektem, aby sprawdzić równość.
	 *
	 * @param obj Obiekt do porównania.
	 * @return {@code true}, jeśli obiekty są równe; {@code false} w przeciwnym wypadku.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Pojazd pojazd = (Pojazd) obj;
		return Objects.equals(nrRejestracyjny, pojazd.nrRejestracyjny);
	}

	/**
	 * Zwraca skrócony kod mieszający (hash code) dla obiektu Pojazd.
	 * Używany do identyfikacji obiektu w kolekcjach takich jak {@link java.util.HashSet}.
	 *
	 * @return Wartość hashcode oparta na numerze rejestracyjnym pojazdu.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nrRejestracyjny);
	}
}
