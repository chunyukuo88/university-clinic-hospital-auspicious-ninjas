package Hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Hospital.Patient;

public class PatientTest {

	@Test
	public void canCreatePatient() {
		Patient underTest = new Patient("Pacman");
		String  expectedName = underTest.getPatientName();
		int		expectedBloodLevel = underTest.getBloodLevel();
		int		expectedHealthLevel= underTest.getHealthLevel();
		assertEquals(expectedName, "Pacman");
		assertEquals(expectedBloodLevel, 20);
		assertEquals(expectedHealthLevel, 10);
	}
}
