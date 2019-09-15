package Hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MedicalTest {

	@Test
	public void canCreateMedicalEmployee() {
		Employee underTest = new Medical("Buck Rogers");
		String expectedName = underTest.getEmployeeName();
		assertEquals(expectedName, "Buck Rogers");
	}
	
	@Test
	public void test() {
		
	}
}
