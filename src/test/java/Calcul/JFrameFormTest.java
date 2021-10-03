package Calcul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JFrameFormTest {

	TestClass testClass;
	   @Before
	    public void setUp() throws Exception {
		   testClass = new TestClass("test", 0, 0); // тестовый класс котоый расширяет абстрактный класс JFrameForm и задается title - название сверху  
	    }

	    @Test
	    public void test() {
	        assertTrue("test".equals(testClass.getTitle())); // проверка совпадает ли название (абстракстый класс сработал верно) 
	    }
}

class TestClass extends JFrameForm{

	public TestClass(String _title, int width, int height) {
		super(_title, width, height);
		// TODO Auto-generated constructor stub
	}

}


// в 13 строке создается абстрактный класс и он задает имя test, в 18 строке идет проверка стал ли он реально test,
// если стал, то тест пройден