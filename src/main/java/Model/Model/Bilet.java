package Model.Model;

import java.time.LocalDateTime;

/**
 * Klasa reprezentująca bilet autobusowy.
 * Zawiera informacje o numerze biletu, jego imienności, uldze, przypisanej osobie oraz dacie ważności.
 */
public class Bilet {

	private int NrBiletu;                // Numer biletu
	private Boolean Imiennosc;           // Czy bilet jest imienny
	private Boolean Ulga;                // Czy bilet ma ulgę
	private Osoba Osoba;                 // Osoba przypisana do biletu
	private LocalDateTime DataWaznosci;  // Data ważności biletu

	/**
	 * Konstruktor klasy Bilet.
	 *
	 * @param nrBiletu      Numer biletu.
	 * @param imiennosc     Czy bilet jest imienny.
	 * @param ulga          Czy bilet ma ulgę.
	 * @param osoba         Osoba przypisana do biletu.
	 * @param dataWaznosci  Data i czas ważności biletu.
	 */
	public Bilet(int nrBiletu, Boolean imiennosc, Boolean ulga, Osoba osoba, LocalDateTime dataWaznosci) {
		// Walidacja numeru biletu
		if (nrBiletu <= 0) {
			throw new IllegalArgumentException("Numer biletu musi być większy od 0.");
		}
		// Walidacja daty ważności
		if (dataWaznosci == null) {
			throw new IllegalArgumentException("Data ważności biletu nie może być null.");
		}
		// Walidacja imienności
		if (imiennosc == null) {
			throw new IllegalArgumentException("Pole 'imienność' nie może być null.");
		}
		// Walidacja ulgi
		if (ulga == null) {
			throw new IllegalArgumentException("Pole 'ulga' nie może być null.");
		}
		// Sprawdzenie, czy bilet imienny ma przypisaną osobę
		if (imiennosc && osoba == null) {
			throw new IllegalArgumentException("Bilet imienny musi mieć przypisaną osobę.");
		}

		this.NrBiletu = nrBiletu;
		this.Imiennosc = imiennosc;
		this.Ulga = ulga;
		this.Osoba = osoba;
		this.DataWaznosci = dataWaznosci;
	}

	/**
	 * Zwraca numer biletu.
	 *
	 * @return Numer biletu.
	 */
	public int getNrBiletu() {
		return NrBiletu;
	}

	/**
	 * Ustawia numer biletu.
	 *
	 * @param nrBiletu Nowy numer biletu.
	 */
	public void setNrBiletu(int nrBiletu) {
		this.NrBiletu = nrBiletu;
	}

	/**
	 * Sprawdza, czy bilet jest imienny.
	 *
	 * @return True, jeśli bilet jest imienny, false w przeciwnym przypadku.
	 */
	public Boolean getImiennosc() {
		return Imiennosc;
	}

	/**
	 * Ustawia status imienności biletu.
	 *
	 * @param imiennosc True, jeśli bilet jest imienny.
	 */
	public void setImiennosc(boolean imiennosc) {
		this.Imiennosc = imiennosc;
	}

	/**
	 * Sprawdza, czy bilet posiada ulgę.
	 *
	 * @return True, jeśli bilet posiada ulgę, false w przeciwnym przypadku.
	 */
	public Boolean getUlga() {
		return Ulga;
	}

	/**
	 * Ustawia status ulgi dla biletu.
	 *
	 * @param ulga True, jeśli bilet ma ulgę.
	 */
	public void setUlga(boolean ulga) {
		this.Ulga = ulga;
	}

	/**
	 * Zwraca datę ważności biletu.
	 *
	 * @return Data i czas ważności biletu.
	 */
	public LocalDateTime getDataWaznosci() {
		return DataWaznosci;
	}

	/**
	 * Ustawia datę ważności biletu.
	 *
	 * @param dataWaznosci Nowa data i czas ważności biletu.
	 */
	public void setDataWaznosci(LocalDateTime dataWaznosci) {
		this.DataWaznosci = dataWaznosci;
	}

	/**
	 * Zwraca osobę przypisaną do biletu.
	 *
	 * @return Osoba przypisana do biletu.
	 */
	public Osoba getOsoba() {
		return Osoba;
	}

	/**
	 * Przypisuje osobę do biletu.
	 *
	 * @param osoba Nowa osoba przypisana do biletu.
	 */
	public void setOsoba(Osoba osoba) {
		this.Osoba = osoba;
	}

	/**
	 * Sprawdza ważność biletu.
	 *
	 * @param nrBiletu Numer biletu do sprawdzenia.
	 * @return True, jeśli numer biletu jest zgodny i data ważności nie minęła; false w przeciwnym przypadku.
	 */
	public boolean SprawdzWaznosc(int nrBiletu) {
		return this.NrBiletu == nrBiletu && DataWaznosci != null && LocalDateTime.now().isBefore(DataWaznosci);
	}
}
