package hospital;

import java.util.Collection;
import java.util.HashMap;

public class Hospital {

	HashMap<Integer, Zombie> zombies;
	HashMap<String, Employee> employees;
	HashMap<String, Patient> patients;

	public Hospital() {
		employees = new HashMap<>();
		patients  = new HashMap<>();
		zombies   = new HashMap<>();
		Zombie zombie1 = new Zombie(1);
		Zombie zombie2 = new Zombie(2);
		Zombie zombie3 = new Zombie(3);
		Zombie zombie4 = new Zombie(4);
		Zombie zombie5 = new Zombie(5);
		Zombie zombie6 = new Zombie(6);
		Zombie zombie7 = new Zombie(7);
		addZombieToHospital(zombie1);
		addZombieToHospital(zombie2);
		addZombieToHospital(zombie3);
		addZombieToHospital(zombie4);
		addZombieToHospital(zombie5);
		addZombieToHospital(zombie6);
		addZombieToHospital(zombie7);
	}

	public void addEmployeeToHospital(Employee employeeToAdd) {
		employees.put(employeeToAdd.getEmployeeName(), employeeToAdd);
	}
	
	public void removeEmployeeFromHospital(Employee employeeToRemove) {
		employees.remove(employeeToRemove.getEmployeeName(), employeeToRemove);
	}
	
	public Employee retrieveEmployee(String employeeName) {
		return employees.get(employeeName);
	}
	
	public Patient retrievePatient(String patientName) {
		return patients.get(patientName);
	}
	
	public void removeZombieFromHospital(Zombie zombie) {
		zombies.remove(zombie.getZombieID());
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

	
	public void addZombieToHospital(Zombie zombie) {
		zombies.put(zombie.getZombieID(), zombie);
	}

	public void removePatientFromHospital(Patient patient) {
		patients.remove(patient.getPatientName(), patient);		
	}
}