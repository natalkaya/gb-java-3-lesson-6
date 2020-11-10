import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainClassTest {

    MainClass mainClass;

    @BeforeEach
    public void init() {
        mainClass = new MainClass();
    }

    @ParameterizedTest
    @MethodSource("leftSanitizedArrayTestData")
    public void leftSanitizedArrayTest(int[] inArr, int[] expectedArr) {
        final int[] actual = mainClass.leftSanitizedArray(inArr);
        Assertions.assertArrayEquals(expectedArr, actual);
    }

    public static Stream<Arguments> leftSanitizedArrayTestData() {
        int[] in1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] out1 = {1, 7};

        int[] in2 = {1, 4, 5};
        int[] out2 = {5};

        int[] in3 = {1, 1, 4};
        int[] out3 = {};

        return Stream.of(
                Arguments.of(in1, out1),
                Arguments.of(in2, out2),
                Arguments.of(in3, out3)
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionLeftSanitizedArrayData")
    public void exceptionLeftSanitizedArrayTest(int[] inArr) {
        Assertions.assertThrows(RuntimeException.class, () -> mainClass.leftSanitizedArray(inArr));
    }

    public static Stream<Arguments> exceptionLeftSanitizedArrayData() {
        int[] in3 = {1, 1, 1};
        int[] in4 = new int[1];
        return Stream.of(
                Arguments.of((Object) in3),
                Arguments.of((Object) in4)
        );
    }

    @ParameterizedTest
    @MethodSource("is1and4InArrayData")
    public void is1and4InArrayTest(boolean expectedRes, int[] inArr) {
        Assertions.assertEquals(expectedRes, mainClass.is1and4InArray(inArr));
    }

    private static Stream<Arguments> is1and4InArrayData() {
        int[] arr_1_4 =         {1, 1, 4, 4, 1};
        int[] arr_4 =           {4, 4};
        int[] arr_empty =       {};
        int[] arr_1 =           {1, 1, 1, 1};
        int[] arr_invalid_num = {1, 4, 4, 0};
        return Stream.of(
                Arguments.of(true,  arr_1_4),
                Arguments.of(false, arr_4),
                Arguments.of(false, arr_empty),
                Arguments.of(false, arr_1),
                Arguments.of(false, arr_invalid_num)
        );
    }
}
