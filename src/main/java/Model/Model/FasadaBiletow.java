package Model.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Klasa implementująca interfejs {@link ObslugaBiletow}.
 * Zarządza kolekcją biletów oraz umożliwia sprawdzanie ich ważności i pobieranie.
 */
public class FasadaBiletow implements ObslugaBiletow {

	private Collection<Bilet> Bilety = new ArrayList<>(); // Kolekcja przechowująca bilety

	/**
	 * Sprawdza ważność biletu na podstawie jego numeru.
	 *
	 * @param nrBiletu Numer biletu do sprawdzenia.
	 * @return True, jeśli bilet jest ważny; false w przeciwnym przypadku.
	 */
	public boolean sprawdzWaznosc(int nrBiletu) {
		for (Bilet bilet : Bilety) {
			if (bilet.SprawdzWaznosc(nrBiletu)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Pobiera bilet na podstawie jego numeru.
	 *
	 * @param nrBiletu Numer biletu do pobrania.
	 * @return Obiekt {@link Bilet}, jeśli istnieje; null, jeśli bilet o podanym numerze nie istnieje.
	 */
	@Override
	public Bilet pobierzBilet(int nrBiletu) {
		for (Bilet bilet : Bilety) {
			if (bilet.getNrBiletu() == nrBiletu) {
				return bilet;
			}
		}
		return null;
	}

	/**
	 * Dodaje nowy bilet do kolekcji.
	 *
	 * @param bilet Obiekt {@link Bilet}, który ma zostać dodany.
	 */
	public void dodajBilet(Bilet bilet) {
		if (bilet == null) {
			throw new IllegalArgumentException("Nie można dodać nullowego biletu.");
		}
		if (pobierzBilet(bilet.getNrBiletu()) != null) {
			throw new IllegalArgumentException("Bilet o numerze " + bilet.getNrBiletu() + " już istnieje.");
		}
		Bilety.add(bilet);
	}

}
