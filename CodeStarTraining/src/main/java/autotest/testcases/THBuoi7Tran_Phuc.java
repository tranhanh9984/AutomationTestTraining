package autotest.testcases;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;;
@Test
public class THBuoi7 {

	public THBuoi7() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void tc1() {
		System.out.println("Test case 1");
		assertEquals(1, 1);
	}
	@Test
	public void tc2() {
		assertEquals(3, 4);
	}

}
