package hospital;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import hospital.Doctor;
import hospital.Employee;
import hospital.Janitor;
import hospital.Nurse;
import hospital.Patient;
import hospital.Receptionist;

public class HospitalTest {

	@Test
	public void hospitalCanHaveEmployees() throws Exception {
		Hospital underTest = new Hospital();
		int employeeInitalCount = underTest.employees.size();
		Janitor janitor = new Janitor("Test Janitor");
		Receptionist receptionist = new Receptionist("Test Receptionist");
		Doctor doctor 			  = new Doctor("Test Doctor", "General Practitioner");
		Nurse nurse 			  = new Nurse("Test Nurse", 10);
		underTest.addEmployeeToHospital(janitor);
		underTest.addEmployeeToHospital(receptionist);
		underTest.addEmployeeToHospital(doctor);
		underTest.addEmployeeToHospital(nurse);
		int addedEmployees = 4;
		int employeeNewCount = underTest.employees.size();
		assertEquals(employeeNewCount, employeeInitalCount + addedEmployees);
		
		
	}

	@Test
	public void hospitalCanHavePatients() throws Exception {
		Hospital underTest = new Hospital();
		int patientCount = underTest.patients.size();
		Patient patientTest1 = new Patient("Test Patient 1");
		Patient patientTest2 = new Patient("Test Patient 2");	
		underTest.addPatientToHospital(patientTest1);
		underTest.addPatientToHospital(patientTest2);
		int patientCountAfterAddingPatients = underTest.patients.size();
		assertEquals(patientCountAfterAddingPatients, patientCount+2);
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
		
		boolean expectedJanitorHasBeenPaid = janitor.hasBeenPaid();
		boolean expectedReceptionistHasBeenPaid = receptionist.hasBeenPaid();
		boolean expectedDoctorHasBeenPaid = doctor.hasBeenPaid();
		boolean expectedNurseHasBeenPaid = nurse.hasBeenPaid();
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
		int newEmployeeCount = underTest.retrieveEmployeeList().size();
		assertThat(newEmployeeCount, is(employeeCount-1));
	}
	
	@Test
	public void hospitalCanRemovePatient() throws Exception {
		Hospital underTest = new Hospital();
		Patient patient1 = new Patient("Test Patient 1");
		Patient patient2 = new Patient("Test Patient 2");
		underTest.addPatientToHospital(patient1);
		underTest.addPatientToHospital(patient2);
		int patientCount = underTest.retrievePatientList().size();
		underTest.removePatientFromHospital(patient1);		
		int newPatientCount = underTest.retrievePatientList().size();
		assertThat(newPatientCount, is(patientCount-1));
	}
	
	@Test
	public void zombiesAreCreatedWithHospital() {
		Hospital underTest = new Hospital();
		int expectedNumberOfZombies = underTest.zombies.size();
		assertEquals(expectedNumberOfZombies, 7);
	}
	
	@Test
	public void returnFalseIfEmployeeAlreadyPaidThisSession() {
		Hospital underTest = new Hospital();
		Receptionist receptionist = new Receptionist("Test Receptionist");
		Doctor doctor = new Doctor("Test Doctor", "General Practitioner");
		underTest.addEmployeeToHospital(doctor);
		underTest.addEmployeeToHospital(receptionist);
		underTest.paySalayForAllEmployees();
		boolean canIPayEmployeeAgain = doctor.paySalary();
		assertEquals(canIPayEmployeeAgain, false);
	}
	
	@Test
	public void canReduceDirtLevel() {
		Hospital underTest	  = new Hospital();
		Janitor  janitor	  = new Janitor("Hulk Hogan");
		underTest.addEmployeeToHospital(janitor);
		underTest.sweepUpDirt(); //One sweeping reduces dirt by 7.
		int expectedDirtiness = underTest.getDirtiness();
		assertEquals(expectedDirtiness, 4);
	}
	
	@Test
	public void dirtLevelCannotBeNegative() {
		Hospital underTest	  = new Hospital();
		Janitor  janitor	  = new Janitor("Hulk Hogan");
		underTest.addEmployeeToHospital(janitor);
		underTest.sweepUpDirt(); //One sweeping reduces dirt by 7.
		underTest.sweepUpDirt(); //One sweeping reduces dirt by 7.
		underTest.sweepUpDirt(); //One sweeping reduces dirt by 7.
		int expectedDirtiness = underTest.getDirtiness();
		assertEquals(expectedDirtiness, 0);
	}
}
