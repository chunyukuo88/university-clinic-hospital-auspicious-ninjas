package Hospital;

import java.util.Collection;
import java.util.HashMap;

public class Hospital {

	int zombiesInHospital = 10;
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

	public String[] retrieveEmployeeRecords() {
		String[] employeeRecordsArray = new String[employees.size()];
		String employeeRecord = "";
		String employeeType = "";
		String employeeMedicalSpecialty = "";
		String isEmployeeWorking = "";
		int i = 0;

		for (Employee employee : employees.values()) {

			if (employee instanceof Doctor) {
				Doctor doctor = (Doctor) employee;
				employeeType = doctor.getEmployeeType();
				employeeMedicalSpecialty = doctor.getSpecialtyArea();
				isEmployeeWorking = "";
			} else if (employee instanceof Nurse) {
				Nurse nurse = (Nurse) employee;
				employeeType = nurse.getEmployeeType();
				employeeMedicalSpecialty = "Ward Max: " + String.valueOf(nurse.getNumberOfPatients());
				isEmployeeWorking = "";
			} else if (employee instanceof Receptionist) {
				Receptionist receptionist = (Receptionist) employee;
				employeeType = receptionist.getEmployeeType();
				employeeMedicalSpecialty = "";
				isEmployeeWorking = (receptionist.isOnThePhone()) ? "Yes" : "No";
			} else if (employee instanceof Janitor) {
				Janitor janitor = (Janitor) employee;
				employeeType = janitor.getEmployeeType();
				employeeMedicalSpecialty = "";
				isEmployeeWorking = (janitor.getSweeping()) ? "Yes" : "No";
			} else {
				employeeType = employee.getEmployeeType();
				employeeMedicalSpecialty = "";
				isEmployeeWorking = "";
			}

			employeeRecord = (String.format("|%-15d", employee.getEmployeeNumber()))
					+ (String.format("|%-15s", employee.getEmployeeName()))
					+ (String.format("|%-15s", employeeType)) 
					+ (String.format("|%-18s", employeeMedicalSpecialty))
					+ (String.format("|%,-15d", employee.getSalary()))
					+ (String.format("|%-7s", ((employee.isHasBeenPaid()) ? "Yes" : "No")))
					+ (String.format("|%-9s|", isEmployeeWorking));
			employeeRecordsArray[i] = employeeRecord;
			i++;
		}
		return employeeRecordsArray;
	}

	public String[] retrievePatientRecords() {
		String[] patientRecordsArray = new String[patients.size()];
		String patientRecord = "";
		int i = 0;
		for (Patient patient : patients.values()) {
			patientRecord = (String.format("|%-15d", patient.getPatientNumber()))
					+ (String.format("|%-15s", patient.getPatientName()))
					+ (String.format("|%-15d", patient.getBloodLevel()))
					+ (String.format("|%-15d", patient.getHealthLevel()));
			patientRecordsArray[i] = patientRecord;
			i++;
		}
		return patientRecordsArray;
	}
}