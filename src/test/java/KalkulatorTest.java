import org.example.Kalkulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class KalkulatorTest {
    @Test
    public void testPenjumlahan()
    {
        Kalkulator calc = new Kalkulator();
        calc.setNumber1(1);
        calc.setNumber2(1);
        Assertions.assertNotNull(calc.getNumber1());
        Assertions.assertNotNull(calc.getNumber2());
        Assertions.assertEquals(2,calc.penjumlahan());
    }

    @Test
    public void testPengurangan()
    {
        Kalkulator calc = new Kalkulator();
        calc.setNumber1(5);
        calc.setNumber2(1);
        Assertions.assertNotNull(calc.getNumber1());
        Assertions.assertNotNull(calc.getNumber2());
        Assertions.assertEquals(4,calc.pengurangan());
    }

    @Test
    public void testPerkalian()
    {
        Kalkulator calc = new Kalkulator();
        calc.setNumber1(4);
        calc.setNumber2(2);
        Assertions.assertNotNull(calc.getNumber1());
        Assertions.assertNotNull(calc.getNumber2());
        Assertions.assertEquals(8,calc.perkalian());
    }

    @Test
    public void testPembagian()
    {
        Kalkulator calc = new Kalkulator();
        calc.setNumber1(10);
        calc.setNumber2(5);
        Assertions.assertNotNull(calc.getNumber1());
        Assertions.assertNotNull(calc.getNumber2());
        Assertions.assertEquals(2,calc.pembagian());
    }

    @ParameterizedTest(name = "Eksekusi ke-{index}, nilai: {arguments}")
    @ValueSource(ints = {2, 4, 6})
    void cekEventGenap(int param){
        Kalkulator kalk = new Kalkulator();
        assertTrue(kalk.cekEven(param));
    }

    @ParameterizedTest(name = "Eksekusi ke-{index}, nilai: {arguments}")
    @ValueSource(ints = {3, 5, 7})
    void cekEventGanjil(int param){
        Kalkulator kalk = new Kalkulator();
        assertFalse(kalk.cekEven(param));
    }

    @ParameterizedTest
    @CsvSource({"2,4,6", "1,2,3", "100,500,600"})
    void tambahParameterized(int a, int b, int expect){
        Kalkulator kalk = new Kalkulator(a,b);
        int actual = kalk.penjumlahan();
        assertEquals(expect,actual);
    }

    private static Stream<Arguments> provideParameters(){
        return Stream.of(
                Arguments.of("2","4","6"),
                Arguments.of("1","2","3"),
                Arguments.of("100","500","600")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void tambahparam(int a, int b, int expect){
        Kalkulator kalk = new Kalkulator(a,b);
        int actual = kalk.penjumlahan();
        assertEquals(expect,actual);
    }

}
