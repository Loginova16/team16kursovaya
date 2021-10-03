package Calcul;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CalculateTest {

	Calculate calc;
	@Before
    public void setUp() throws Exception {
		calc = new Calculate("10", "6", "10000", true, true); // создаем экземпл€р класса calculate который высчитает итоговое значение вклада
    }

    @Test
    public void test() {
    	 System.out.println(calc.getFinalValue());
        assertTrue(calc.getFinalValue() == 626400.0); // убеждаемс€ что результат верен
    }

}
