package Model.Model;

import Model.Model.Bilet;

public interface ObslugaBiletow {
	boolean sprawdzWaznosc(int nrBiletu);
	Bilet pobierzBilet(int nrBiletu);
	void dodajBilet(Bilet bilet);
}
