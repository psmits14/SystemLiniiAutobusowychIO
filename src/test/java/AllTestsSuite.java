

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;


@Suite
@SelectClasses({
        OsobaTest.class,
        BiletTest.class,
        FasadaBiletowTest.class
})
public class AllTestsSuite {
}
