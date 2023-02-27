import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org. junit.jupiter.api.Assertions.*;

public class HW8test {
    @BeforeAll
    public static void classSetup(){System.out.println("Lets do it");}
    @BeforeEach
    public void beforeTest(){System.out.println("You doing good");}
    @AfterEach
    public void afterTest(){System.out.println("You did good");}
    @AfterAll
    public static void classTearDown(){System.out.println("Good work!");}
    HW8 test1 = new HW8();

    static Stream<Arguments> getDayDataPrvider(){
        return Stream.of(
                Arguments.of(1, "Sunday"),
                Arguments.of(2, "Monday"),
                Arguments.of(3, "Tuesday"),
                Arguments.of(4, "Wednesday"),
                Arguments.of(5, "Thursday"),
                Arguments.of(6, "Friday"),
                Arguments.of(7, "Saturday")
        );
    }
    @ParameterizedTest
    @MethodSource("getDayDataPrvider")
    public void positiveGetDayTest(int dayNum, String expectedResult){
        String result = test1.getDay(dayNum);
        assertEquals(expectedResult, result);
    }
    @ParameterizedTest
    @DisplayName("dayNuber is smaller than the allowed numbers")
    @ValueSource(ints = {0, -1, -10, -33569834})
    public void negativeSmallerThenOneTest(int dayNum){
        System.out.println(test1.getDay(dayNum));
        assertFalse(dayNum >1);
        assertFalse(dayNum ==1);
    }
    @ParameterizedTest
    @DisplayName("dayNuber is larger than the allowed numbers")
    @ValueSource(ints = {8, 16, 38, 33569834})
    public void negativeLargerThenSevenTest(int dayNum){
        System.out.println(test1.getDay(dayNum));
        assertFalse(dayNum <7 );
        assertFalse(dayNum ==7);
    }
    @Test
    @DisplayName("Nullpointer Exception test")
    public void nullValueTest(){
        assertThrows( NullPointerException.class, () -> {test1.getDay(null);});
    }
}