
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BiletTest.class,
        FasadaBiletowTest.class,
        OsobaTest.class
})
@IncludeTags("Pozytywny")  // Uwzględnia testy z tagiem "Pozytywny"
@ExcludeTags("NieoprawnoscDanych")  // Wyklucza testy z tagiem "NieoprawnoscDanych"
public class TestyBezNiepoprawnychDanychSuite {
}