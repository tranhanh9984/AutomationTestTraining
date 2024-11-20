package autotest.testcases;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

public class OanhBuoi7 {

	public OanhBuoi7() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void tc1(){
		System.out.println("Thuc hanh TC1");
		assertEquals(1, 2);
	}
	@BeforeTest
	public void tc2(){
		System.out.println("Thuc hanh TC2");
		assertEquals(1, 1);
	}
	
	
}
