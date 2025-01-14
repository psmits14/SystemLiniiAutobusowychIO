

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BiletTest.class,
        FasadaBiletowTest.class,
        OsobaTest.class
})
@IncludeTags("Pozytywny")  // Uwzględnia tylko testy z tagiem "Pozytywny"
public class PozytywneTestSuite {
}
