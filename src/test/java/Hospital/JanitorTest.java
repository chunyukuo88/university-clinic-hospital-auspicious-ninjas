package Hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JanitorTest {

	@Test
	public void canCreateJanitor() {
		Janitor underTest = new Janitor("Michael Jordan");
		String expectedName = underTest.getEmployeeName();
		boolean expectedSweeping = underTest.getSweeping();
		int expectedSalary = underTest.getSalary();
		assertEquals(expectedName, "Michael Jordan");
		assertEquals(expectedSalary, 40_000);
		assertEquals(expectedSweeping, true);
	}
}

