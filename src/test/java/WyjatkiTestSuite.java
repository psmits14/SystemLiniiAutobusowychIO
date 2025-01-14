

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BiletTest.class,
        FasadaBiletowTest.class,
        OsobaTest.class
})
@IncludeTags("Wyjatek")  // Uwzględnia tylko testy z tagiem "Wyjatek"
public class WyjatkiTestSuite {
}