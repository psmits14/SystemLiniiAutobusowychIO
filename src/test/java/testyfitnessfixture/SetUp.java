package testyfitnessfixture;
import Model.FasadaBiletow;
import fit.Fixture;
public class SetUp extends Fixture{
    static FasadaBiletow fasadaBiletow;
    public SetUp() {
        fasadaBiletow = new FasadaBiletow();
    }
}