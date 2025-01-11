package Model.Model;

import static Model.Model.Rola.Klient;

/**
 * Klasa reprezentująca osobę w systemie.
 * Zawiera informacje takie jak imię, nazwisko, numer PESEL, numer dokumentu i rolę użytkownika.
 */
public class Osoba {

	private String Imie = "";
	private String Nazwisko = "";
	private long Pesel;
	private String NrDokumentu = "";
	private Rola Rola = Klient;


		public Osoba(String imie, String nazwisko, long pesel, String nrDokumentu, Rola rola) {
			if (imie == null || imie.isEmpty()) {
				throw new IllegalArgumentException("Imię nie może być puste");
			}
			if (nazwisko == null || nazwisko.isEmpty()) {
				throw new IllegalArgumentException("Nazwisko nie może być puste");
			}
			if (pesel < 10000000000L || pesel > 99999999999L) {
				throw new IllegalArgumentException("Niepoprawny PESEL");
			}
			if (nrDokumentu == null || nrDokumentu.isEmpty()) {
				throw new IllegalArgumentException("Numer dokumentu nie może być pusty");
			}
			if (rola == null) {
				throw new IllegalArgumentException("Rola nie może być null");
			}

			this.Imie = imie;
			this.Nazwisko = nazwisko;
			this.Pesel = pesel;
			this.NrDokumentu = nrDokumentu;
			this.Rola = rola;
		}


	/**
	 * Zwraca imię osoby.
	 *
	 * @return Imię osoby.
	 */
	public String getImie() {
		return Imie;
	}

	/**
	 * Ustawia imię osoby.
	 *
	 * @param imie Nowe imię osoby.
	 */
	public void setImie(String imie) {
		this.Imie = imie;
	}

	/**
	 * Zwraca nazwisko osoby.
	 *
	 * @return Nazwisko osoby.
	 */
	public String getNazwisko() {
		return Nazwisko;
	}

	/**
	 * Ustawia nazwisko osoby.
	 *
	 * @param nazwisko Nowe nazwisko osoby.
	 */
	public void setNazwisko(String nazwisko) {
		this.Nazwisko = nazwisko;
	}

	/**
	 * Zwraca numer PESEL osoby.
	 *
	 * @return Numer PESEL osoby.
	 */
	public long getPesel() {
		return Pesel;
	}

	/**
	 * Ustawia numer PESEL osoby.
	 *
	 * @param pesel Nowy numer PESEL osoby.
	 */
	public void setPesel(int pesel) {
		this.Pesel = pesel;
	}

	/**
	 * Zwraca numer dokumentu tożsamości osoby.
	 *
	 * @return Numer dokumentu tożsamości.
	 */
	public String getNrDokumentu() {
		return NrDokumentu;
	}

	/**
	 * Ustawia numer dokumentu tożsamości osoby.
	 *
	 * @param nrDokumentu Nowy numer dokumentu tożsamości.
	 */
	public void setNrDokumentu(String nrDokumentu) {
		this.NrDokumentu = nrDokumentu;
	}

	/**
	 * Zwraca rolę przypisaną osobie.
	 *
	 * @return Rola osoby {@link Rola}.
	 */
	public Rola getRola() {
		return Rola;
	}

	/**
	 * Ustawia rolę osoby.
	 *
	 * @param rola Nowa rola osoby {@link Rola}.
	 */
	public void setRola(Rola rola) {
		this.Rola = rola;
	}
}
