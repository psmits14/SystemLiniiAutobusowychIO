
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BiletTest.class,
        FasadaBiletowTest.class,
        OsobaTest.class
})
@IncludeTags("PoprawnoscDanych")  // Uwzględnia tylko testy związane z poprawnością danych
public class PoprawnoscDanychTestSuite {
}
