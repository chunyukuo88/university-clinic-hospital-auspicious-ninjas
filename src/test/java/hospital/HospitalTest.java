package hospital;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;
import org.junit.Test;

public class HospitalTest {

	@Test
	public void hospitalCanHaveEmployees() throws Exception {
		Hospital underTest = new Hospital();
		Janitor janitor = new Janitor("Test Janitor");
		Receptionist receptionist = new Receptionist("Test Receptionist");
		Doctor doctor = new Doctor("Test Doctor", "General Practitioner");
		Nurse nurse = new Nurse("Test Nurse", 10);
		underTest.addEmployeeToHospital(janitor);
		underTest.addEmployeeToHospital(receptionist);
		underTest.addEmployeeToHospital(doctor);
		underTest.addEmployeeToHospital(nurse);
		Collection<Employee> employees = underTest.retrieveEmployeeList();
		assertThat(employees, containsInAnyOrder(janitor, receptionist, doctor, nurse));
	}

	@Test
	public void hospitalCanHavePatients() throws Exception {
		Hospital underTest = new Hospital();
		Patient patient1 = new Patient("Test Patient 1");
		Patient patient2 = new Patient("Test Patient 2");	
		underTest.addPatientToHospital(patient1);
		underTest.addPatientToHospital(patient2);
		Collection<Patient> patients = underTest.retrievePatientList();		
		assertThat(patients, containsInAnyOrder(patient1, patient2));		
	}
	
	@Test
	public void hospitalPaysAllEmployees() throws Exception {
		Hospital underTest = new Hospital();
		Janitor janitor = new Janitor("Test Janitor");
		Receptionist receptionist = new Receptionist("Test Receptionist");
		Doctor doctor = new Doctor("Test Doctor", "General Practitioner");
		Nurse nurse = new Nurse("Test Nurse", 10);
		underTest.addEmployeeToHospital(janitor);
		underTest.addEmployeeToHospital(receptionist);
		underTest.addEmployeeToHospital(doctor);
		underTest.addEmployeeToHospital(nurse);
		
		underTest.paySalayForAllEmployees();
		
		boolean expectedJanitorHasBeenPaid = janitor.isHasBeenPaid();
		boolean expectedReceptionistHasBeenPaid = receptionist.isHasBeenPaid();
		boolean expectedDoctorHasBeenPaid = doctor.isHasBeenPaid();
		boolean expectedNurseHasBeenPaid = nurse.isHasBeenPaid();
		assertThat(expectedJanitorHasBeenPaid, is(true));
		assertThat(expectedReceptionistHasBeenPaid, is(true));
		assertThat(expectedDoctorHasBeenPaid, is(true));
		assertThat(expectedNurseHasBeenPaid, is(true));		
	}
	
	@Test
	public void hospitalCanRemoveEmployee() throws Exception {
		Hospital underTest = new Hospital();
		Janitor janitor = new Janitor("Test Janitor");
		Receptionist receptionist = new Receptionist("Test Receptionist");
		Doctor doctor = new Doctor("Test Doctor", "General Practitioner");
		Nurse nurse = new Nurse("Test Nurse", 10);
		underTest.addEmployeeToHospital(janitor);
		underTest.addEmployeeToHospital(receptionist);
		underTest.addEmployeeToHospital(doctor);
		underTest.addEmployeeToHospital(nurse);
		int employeeCount = underTest.retrieveEmployeeList().size();
		
		underTest.removeEmployeeFromHospital(janitor);
		employeeCount = employeeCount - 1;
		
		int newEmployeeCount = underTest.retrieveEmployeeList().size();
		assertThat(newEmployeeCount, is(3));
	}
}
