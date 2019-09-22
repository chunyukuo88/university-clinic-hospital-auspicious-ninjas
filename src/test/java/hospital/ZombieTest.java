package hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZombieTest {

	@Test
	public void canCreateSevenZombies() {
		Hospital testHospital = new Hospital();
		int zombieCount = testHospital.zombies.size();
		Zombie underTest1 = new Zombie();
		Zombie underTest2 = new Zombie();
		Zombie underTest3 = new Zombie();
		Zombie underTest4 = new Zombie();
		Zombie underTest5 = new Zombie();
		Zombie underTest6 = new Zombie();
		Zombie underTest7 = new Zombie();
		testHospital.addZombieToHospital(underTest1);
		testHospital.addZombieToHospital(underTest2);
		testHospital.addZombieToHospital(underTest3);
		testHospital.addZombieToHospital(underTest4);
		testHospital.addZombieToHospital(underTest5);
		testHospital.addZombieToHospital(underTest6);
		testHospital.addZombieToHospital(underTest7);
		int newZombieCount = testHospital.zombies.size();
		assertEquals(newZombieCount, zombieCount+7);
	}
}
