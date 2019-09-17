package Hospital;

import java.util.Collection;
import java.util.HashMap;

public class Hospital {
	
	HashMap<String, Employee> employees;
	HashMap<String, Patient> patients;

	public Hospital() {
		employees = new HashMap<>();
		patients = new HashMap<>();
	}
	
	public void addEmployeeToHospital(Employee employeeToAdd) {
		employees.put(employeeToAdd.getEmployeeName(), employeeToAdd);
	}
	
	public void addPatientToHospital(Patient patientToAdd) {
		patients.put(patientToAdd.getPatientName(), patientToAdd);
	}
	
	public Collection<Employee> retrieveEmployeeList() {
		return employees.values();
	}
	
	public Collection<Patient> retrievePatientList() {
		return patients.values();
	}

	public void paySalayForAllEmployees() {
		for (Employee employee : employees.values()) {
			employee.paySalary();
		}
	}
		
}