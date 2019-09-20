package hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZombieTest {

	@Test
	public void canCreateSevenZombies() {
		Hospital testHospital = new Hospital();
		Zombie underTest1 = new Zombie(1);
		Zombie underTest2 = new Zombie(2);
		Zombie underTest3 = new Zombie(3);
		Zombie underTest4 = new Zombie(4);
		Zombie underTest5 = new Zombie(5);
		Zombie underTest6 = new Zombie(6);
		Zombie underTest7 = new Zombie(7);
		testHospital.addZombieToHospital(underTest1);
		testHospital.addZombieToHospital(underTest2);
		testHospital.addZombieToHospital(underTest3);
		testHospital.addZombieToHospital(underTest4);
		testHospital.addZombieToHospital(underTest5);
		testHospital.addZombieToHospital(underTest6);
		testHospital.addZombieToHospital(underTest7);
		int expectedZombieCount = testHospital.zombies.size();
		assertEquals(expectedZombieCount, 7);
	}
}
