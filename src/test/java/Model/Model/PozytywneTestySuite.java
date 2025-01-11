package Model.Model;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.IncludeTags;

@Suite
@SelectClasses({BiletTest.class, FasadaBiletowTest.class, OsobaTest.class})
@IncludeTags("Pozytywny")
public class PozytywneTestySuite {
    @BeforeAll
    static void init() {
        System.out.println("Uruchamiam testy pozytywne...");
    }
}
