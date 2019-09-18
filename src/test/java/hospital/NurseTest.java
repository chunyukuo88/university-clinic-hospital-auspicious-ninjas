package hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hospital.Nurse;
import hospital.Patient;

public class NurseTest {

	@Test
	public void canCreateNurse() {
		Nurse underTest = new Nurse("Fig Newton", 500);
		String expectedName = underTest.getEmployeeName();
		int expectedNumberOfPatients = underTest.getNumberOfPatients();
		int expectedSalary = underTest.getSalary();
		assertEquals(expectedName, "Fig Newton");
		assertEquals(expectedNumberOfPatients, 500);
		assertEquals(expectedSalary, 50_000);
	}
	
	@Test
	public void nurseCanDrawBlood() {
		Nurse underTest = new Nurse("Felix Mendelsohnn", 500);
		Patient testPatient = new Patient("Arnold Schwarzenegger");
		underTest.drawBlood(testPatient);
		int testPatientBloodLevel = testPatient.getBloodLevel();
		assertEquals(testPatientBloodLevel, 18);
	}
}
