package Model.Model;

/**
 * Klasa reprezentująca przystanek.
 */
public class Przystanek {

	/** Nazwa przystanku autobusowego. */
	private String nazwa;

	/**
	 * Konstruktor klasy Przystanek.
	 *
	 * @param nazwa Nazwa przystanku autobusowego.
	 */
	public Przystanek(String nazwa) {
		this.nazwa = nazwa;
	}

	/**
	 * Zwraca nazwę przystanku.
	 *
	 * @return Nazwa przystanku.
	 */
	public String getNazwa() {
		return nazwa;
	}

	/**
	 * Ustawia nową nazwę przystanku.
	 *
	 * @param nazwa Nowa nazwa przystanku.
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
