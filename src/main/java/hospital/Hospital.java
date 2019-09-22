package hospital;

import java.util.Collection;
import java.util.HashMap;

public class Hospital {

	HashMap<Integer, Zombie> zombies;
	HashMap<String, Employee> employees;
	HashMap<String, Patient> patients;

	public Hospital() {
		employees = new HashMap<>();
		patients = new HashMap<>();
		zombies = new HashMap<>();
		
		Zombie zombie1 = new Zombie(1);
		Zombie zombie2 = new Zombie(2);
		Zombie zombie3 = new Zombie(3);
		Zombie zombie4 = new Zombie(4);
		Zombie zombie5 = new Zombie(5);
		Zombie zombie6 = new Zombie(6);
		Zombie zombie7 = new Zombie(7);
		this.addZombieToHospital(zombie1);
		this.addZombieToHospital(zombie2);
		this.addZombieToHospital(zombie3);
		this.addZombieToHospital(zombie4);
		this.addZombieToHospital(zombie5);
		this.addZombieToHospital(zombie6);
		this.addZombieToHospital(zombie7);
		
		Doctor doctor1 = new Doctor("Dr. DoLittle", "Toenails");
		Doctor doctor2 = new Doctor("Dr. Who", "Space-Time");
		Nurse nurse1 = new Nurse("Wanda Sparks", 10);
		Nurse nurse2 = new Nurse("Mary Poppins", 10);
		Receptionist receptionist1 = new Receptionist("Cassie Fancher");
		Receptionist receptionist2 = new Receptionist("Polly Maynard");
		Janitor janitor1 = new Janitor("Chip Dipp");
		Janitor janitor2 = new Janitor("Larry Fisher");
		this.addEmployeeToHospital(doctor1);
		this.addEmployeeToHospital(doctor2);
		this.addEmployeeToHospital(nurse1);
		this.addEmployeeToHospital(nurse2);
		this.addEmployeeToHospital(receptionist1);
		this.addEmployeeToHospital(receptionist2);
		this.addEmployeeToHospital(janitor1);
		this.addEmployeeToHospital(janitor2);
		
		Patient patient1 = new Patient("Iam Sick");
		Patient patient2 = new Patient("Help MePlease");
		Patient patient3 = new Patient("Inna Koma");
		this.addPatientToHospital(patient1);
		this.addPatientToHospital(patient2);
		this.addPatientToHospital(patient3);
		
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

	public String[] paySalayForAllEmployees() {
		String[] employeePayroll = new String[employees.size()];
		String employeePayrollRecord = "";
		int i = 0;
		boolean ableToPayEmployee = true;
		String employeeName = "";
		String employeeType = "";
		String employeePaidStatus = "";
		int employeeSalary = 0;

		for (Employee employee : employees.values()) {
			employeeName = employee.getEmployeeName();
			employeeType = employee.getEmployeeType();
			employeeSalary = employee.getSalary();
			ableToPayEmployee = employee.paySalary();
			employeePaidStatus = ((ableToPayEmployee) ? "Paid Successfully" : "Previously Paid");

			employeePayrollRecord = (String.format("|%-15d", employee.getEmployeeNumber()))
					+ (String.format("|%-15s", employeeName)) 
					+ (String.format("|%-15s", employeeType))
					+ (String.format("|%,-15d", employeeSalary)) 
					+ (String.format("|%-19s", employeePaidStatus));

			employeePayroll[i] = employeePayrollRecord;
			i++;
		}
		return employeePayroll;
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
					+ (String.format("|%-15s", employee.getEmployeeName())) + (String.format("|%-15s", employeeType))
					+ (String.format("|%-18s", employeeMedicalSpecialty))
					+ (String.format("|%,-15d", employee.getSalary()))
					+ (String.format("|%-7s", ((employee.hasBeenPaid()) ? "Yes" : "No")))
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

	public String retrieveEmployeeRecord(Employee selectedEmployee) {

		String employeeRecord = "";
		String employeeType = "";
		String employeeMedicalSpecialty = "";
		String isEmployeeWorking = "";

		if (selectedEmployee instanceof Doctor) {
			Doctor doctor = (Doctor) selectedEmployee;
			employeeType = doctor.getEmployeeType();
			employeeMedicalSpecialty = doctor.getSpecialtyArea();
			isEmployeeWorking = "";
		} else if (selectedEmployee instanceof Nurse) {
			Nurse nurse = (Nurse) selectedEmployee;
			employeeType = nurse.getEmployeeType();
			employeeMedicalSpecialty = "Ward Max: " + String.valueOf(nurse.getNumberOfPatients());
			isEmployeeWorking = "";
		} else if (selectedEmployee instanceof Receptionist) {
			Receptionist receptionist = (Receptionist) selectedEmployee;
			employeeType = receptionist.getEmployeeType();
			employeeMedicalSpecialty = "";
			isEmployeeWorking = (receptionist.isOnThePhone()) ? "Yes" : "No";
		} else if (selectedEmployee instanceof Janitor) {
			Janitor janitor = (Janitor) selectedEmployee;
			employeeType = janitor.getEmployeeType();
			employeeMedicalSpecialty = "";
			isEmployeeWorking = (janitor.getSweeping()) ? "Yes" : "No";
		} else {
			employeeType = selectedEmployee.getEmployeeType();
			employeeMedicalSpecialty = "";
			isEmployeeWorking = "";
		}

		employeeRecord = (String.format("|%-15d", selectedEmployee.getEmployeeNumber()))
				+ (String.format("|%-15s", selectedEmployee.getEmployeeName()))
				+ (String.format("|%-15s", employeeType)) + (String.format("|%-18s", employeeMedicalSpecialty))
				+ (String.format("|%,-15d", selectedEmployee.getSalary()))
				+ (String.format("|%-7s", ((selectedEmployee.hasBeenPaid()) ? "Yes" : "No")))
				+ (String.format("|%-9s|", isEmployeeWorking));

		return employeeRecord;
	}
}