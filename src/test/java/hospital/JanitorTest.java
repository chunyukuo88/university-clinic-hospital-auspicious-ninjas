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
	public void janitorCanKillZombies() {
		Janitor underTest = new Janitor("Bjarne Stroustrup");
		Hospital testHospital = new Hospital();
		Zombie testZombie = new Zombie();
		testHospital.addEmployeeToHospital(underTest);
		testHospital.addZombieToHospital(testZombie);
		underTest.killZombie(testHospital, testZombie);
		int expectingNumOfZombies = testHospital.zombies.size();
		assertEquals(expectingNumOfZombies, 7);
	}

}
