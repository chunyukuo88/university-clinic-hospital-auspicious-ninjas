package hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hospital.Receptionist;

public class ReceptionistTest {

	@Test
	public void canCreateReceptionist() {
		Receptionist underTest = new Receptionist("Humphrey Bogart");
		String expectedName = underTest.getEmployeeName();
		boolean expectedOnThePhone = underTest.isOnThePhone();
		int expectedSalary = underTest.getSalary();
		assertEquals(expectedName, "Humphrey Bogart");
		assertEquals(expectedSalary, 45_000);
		assertEquals(expectedOnThePhone, true);
	}
	
	
}
