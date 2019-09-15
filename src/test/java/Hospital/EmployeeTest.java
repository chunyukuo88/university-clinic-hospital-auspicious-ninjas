package Hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void canCreateEmployee() {
		Employee underTest = new Employee("Diablo");
		String nameOfEmployee = underTest.getEmployeeName();
		assertEquals(nameOfEmployee, "Diablo");
	}
	
	
}
