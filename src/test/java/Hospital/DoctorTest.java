package Hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoctorTest {

	@Test
	public void canCreateDoctor() {
		Doctor underTest = new Doctor("Billy Joel", "Musical Therapy");
		String expectedName = underTest.getEmployeeName();
		String expectedSpecialtyArea = underTest.getSpecialtyArea();
		int expectedSalary = underTest.getSalary();
		assertEquals(expectedName, "Billy Joel");
		assertEquals(expectedSpecialtyArea, "Musical Therapy");
		assertEquals(expectedSalary, 90_000);
	}
	
	@Test
	public void canDrawBlood() {
		Doctor testDoctor = new Doctor("Billy Joel", "Musical Therapy");
		Patient testPatient = new Patient("George Washington");
		int testPatientBloodLevel = testPatient.getBloodLevel();
		testDoctor.drawBlood(testPatient);
		assertEquals(testPatientBloodLevel, 16);
	}	
}
