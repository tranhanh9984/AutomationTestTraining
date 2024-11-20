package autotest.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
@Test
public class THbuoi7_ChuHong {

	
	
public void tc01() {
	System.out.print("Hong 1");
}
	public void tc02() {
		System.out.print("Hong 2");
		assertEquals(false, true);
	}

}
