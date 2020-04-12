import static org.junit.Assert.*;

import org.junit.Test;

public class CalTest {

	@Test
	public void test() {
		ClassToBeTested toBeTested = new ClassToBeTested () ;
		assertEquals(3, toBeTested.calTwoDigits(1, 2));
		}

}
