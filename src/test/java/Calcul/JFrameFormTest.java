package Calcul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JFrameFormTest {

	TestClass testClass;
	   @Before
	    public void setUp() throws Exception {
		   testClass = new TestClass("test", 0, 0); // �������� ����� ������ ��������� ����������� ����� JFrameForm � �������� title - �������� ������  
	    }

	    @Test
	    public void test() {
	        assertTrue("test".equals(testClass.getTitle())); // �������� ��������� �� �������� (����������� ����� �������� �����) 
	    }
}

class TestClass extends JFrameForm{

	public TestClass(String _title, int width, int height) {
		super(_title, width, height);
		// TODO Auto-generated constructor stub
	}

}


// � 13 ������ ��������� ����������� ����� � �� ������ ��� test, � 18 ������ ���� �������� ���� �� �� ������� test,
// ���� ����, �� ���� �������