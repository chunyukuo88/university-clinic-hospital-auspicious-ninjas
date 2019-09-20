package hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hospital.Janitor;

public class JanitorTest {

	@Test
	public void canCreateJanitor() {
		Janitor underTest = new Janitor("Guido van Rossum");
		String expectedName = underTest.getEmployeeName();
		boolean expectedSweeping = underTest.getSweeping();
		int expectedSalary = underTest.getSalary();
		assertEquals(expectedName, "Guido van Rossum");
		assertEquals(expectedSalary, 40_000);
		assertEquals(expectedSweeping, true);
	}
	
	@Test
	private void janitorCanFightZombies() {
		Janitor underTest = new Janitor("Bjarne Stroustrup");
		Hospital testHospital = new Hospital(); //Default 10 zombies.
		underTest.fightZombies();
		int resultingZombieCount = testHospital.zombiesInHospital;
		assertEquals(resultingZombieCount, 8);
	}
}

