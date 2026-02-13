import org.example.Kalkulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

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


}
