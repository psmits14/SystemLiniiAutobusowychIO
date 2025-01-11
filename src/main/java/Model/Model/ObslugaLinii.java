package Model.Model;

import java.util.Collection;

public interface ObslugaLinii {

	/**
	 * @param nrLinii
	 * @return
	 */
	boolean dodajLinie(int nrLinii);

	LiniaAutobusowa znajdzLinie(int nrLinii);

}