
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BiletTest.class,
        FasadaBiletowTest.class,
        OsobaTest.class
})
@ExcludeTags("Wyjatek")  // Wyklucza wszystkie testy z tagiem "Wyjatek"
public class WszystkieTestyBezWyjatkowSuite {
}