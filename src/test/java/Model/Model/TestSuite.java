package Model.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Suite
@IncludeTags("Pozytywny")
public class TestSuite {

    @BeforeAll
    public static void initSuite() {
        System.out.println("Rozpoczynanie zestawu testów...");
    }

    @BeforeEach
    public void initEachTest() {
        System.out.println("Przygotowanie testu...");
    }

}
