package hospital;

import java.util.Scanner;

public class HospitalApp {

	private static Scanner scanner = new Scanner(System.in);
	public static Hospital hospital = new Hospital();
	public static String userResponse = "";
	public static boolean stayInMenu;

	public static void main(String[] args) {

		System.out.println("Welcome to the University Clinic Hospital.");
		System.out.println();

		stayInMenu = true;
		while (stayInMenu) {
			displayMenu();
		}

	}

	private static void displayMenu() {
		System.out.println("MAIN MENU");
		System.out.println("Please enter a number from these options:");
		System.out.println();
		System.out.println("1. Employees Menu");
		System.out.println("2. Patients Menu");
		System.out.println("3. View Records");
		System.out.println("0. Exit");
		userResponse = scanner.nextLine();
		System.out.println();

		switch (userResponse) {
		case "1":
			displayEmployeeMenu();
			break;
		case "2":
			displayPatientMenu();
			break;
		case "3":
			displayEmployeeRecords();
			displayPatientRecords();
			break;
		case "0":
			terminateApplication();
			break;
		default:
			System.out.println("Response not recognized.");
		}
	}

	private static void displayPatientMenu() {
		stayInMenu = true;
		while (stayInMenu) {
			System.out.println("PATIENT MENU");
			System.out.println("Please enter a number from these options:");
			System.out.println();
			System.out.println("1. Admit a patient to the hospital.");
			System.out.println("2. Discharge a patient from the hospital.");
			System.out.println("3. View patient records.");
			System.out.println("4. Back to main menu.");
			System.out.println("0. Exit.");

			userResponse = scanner.nextLine();
			System.out.println();

			switch (userResponse) {
			case "1":
				addPatientToTheHospital();
				break;
			case "2":
				removePatientFromHospital();
				break;
			case "3":
				displayPatientRecords();
				break;
			case "4":
				stayInMenu = false;
				break;
			case "0":
				terminateApplication();
				break;
			default:
				System.out.println("Response not recognized.");
			}
		}
		stayInMenu = true;
	}

	private static void displayEmployeeMenu() {
		stayInMenu = true;
		while (stayInMenu) {
			System.out.println("EMPLOYEE MENU");
			System.out.println("Please enter a number from these options:");
			System.out.println();
			System.out.println("1. Add an employee to the hospital.");
			System.out.println("2. Remove an employee from the hospital.");
			System.out.println("3. Search for one employee.");
			System.out.println("4. Pay all employees.");
			System.out.println("5. View employee records.");
			System.out.println("6. Back to main menu.");
			System.out.println("0. Exit.");

			userResponse = scanner.nextLine().trim().toUpperCase();
			System.out.println();

			switch (userResponse) {
			case "1":
				addEmployeeToTheHospital();
				break;
			case "2":
				removeEmployeeFromTheHospital();
				break;
			case "3":
				searchByEmployeeName();
				// WIP: Add another sub-menu for employee actions.
				break;
			case "4":
				submitEmployeePayroll();
				break;
			case "5":
				displayEmployeeRecords();
				break;
			case "6":
				stayInMenu = false;
				break;
			case "0":
				terminateApplication();
				break;
			default:
				System.out.println("Response not recognized.");
			}
		}
		stayInMenu = true;
	}

	private static void submitEmployeePayroll() {
		System.out.println("Results from Employee Payroll Submission");
		System.out.print(String.format("|%-15s", "Employee Number"));
		System.out.print(String.format("|%-15s", "Employee Name"));
		System.out.print(String.format("|%-15s", "Employee Type"));
		System.out.print(String.format("|%-15s", "Annual Salary"));
		System.out.print(String.format("|%-19s", "Payroll Status"));
		System.out.println();
		System.out.println(
				"|----------------------------------------------------------------------------------------------------|");
		String[] employeePayrollRecords = hospital.paySalayForAllEmployees();
		for (String record : employeePayrollRecords) {
			System.out.println(record);
		}
		System.out.println();
		
	}

	private static void searchByEmployeeName() {
		System.out.print("Enter the name of the employee:\n>");
		userResponse = scanner.nextLine();
		displayEmployeeRecord(userResponse);
	}

	private static void displayEmployeeRecord(String nameOfEmployee) {
		System.out.print(String.format("|%-15s", "Employee Number"));
		System.out.print(String.format("|%-15s", "Employee Name"));
		System.out.print(String.format("|%-15s", "Employee Type"));
		System.out.print(String.format("|%-18s", "Medical Specialty"));
		System.out.print(String.format("|%-15s", "Annual Salary"));
		System.out.print(String.format("|%-7s", "Paid?"));
		System.out.print(String.format("|%-9s|", "Working?"));
		System.out.println();
		System.out.println(
				"|----------------------------------------------------------------------------------------------------|");
		Employee selectedEmployee = hospital.retrieveEmployee(nameOfEmployee);
		String employeeRecord = hospital.retrieveEmployeeRecord(selectedEmployee);
		System.out.println(employeeRecord);
		System.out.println();
	}

	private static void removePatientFromHospital() {
		stayInMenu = true;
		while (stayInMenu) {

			displayPatientRecords();
			System.out.println("Enter the Patient Number of the patient to remove, or X to return to the previous menu.");
			String patientNumber = scanner.nextLine();
			System.out.println();

			if (patientNumber.equals("X") || patientNumber.equals("x")) {
				stayInMenu = false;

			} else {
				Patient patientToRemove = hospital.retrievePatient(patientNumber);
				String patientName = patientToRemove.getPatientName();
				hospital.removePatientFromHospital(patientToRemove);
				System.out.println(patientName + " (" + patientNumber + ") has been removed.");

				System.out.println("Do you want to remove another patient? [Y/N]");
				userResponse = scanner.nextLine().trim().toUpperCase();
				if (userResponse.equals("N")) {
					stayInMenu = false;
				}
			}
		}
		stayInMenu = true;
	}

	private static void removeEmployeeFromTheHospital() {
		stayInMenu = true;
		while (stayInMenu) {

			displayEmployeeRecords();
			System.out.println("Enter the Employee Number of the employee to remove, or X to return to the previous menu.");
			String employeeNumber = scanner.nextLine();
			System.out.println();

			if (employeeNumber.equals("X") || employeeNumber.equals("x")) {
				stayInMenu = false;

			} else {
				Employee employeeToRemove = hospital.retrieveEmployee(employeeNumber);
				String employeeName = employeeToRemove.getEmployeeName();
				hospital.removeEmployeeFromHospital(employeeToRemove);
				System.out.println(employeeName + " (" + employeeNumber + ") has been removed.");

				System.out.println("Do you want to remove another employee? [Y/N]");
				userResponse = scanner.nextLine().trim().toUpperCase();
				if (userResponse.equals("N")) {
					stayInMenu = false;
				}
			}
		}
		stayInMenu = true;
	}

	private static void addEmployeeToTheHospital() {
		stayInMenu = true;
		while (stayInMenu) {

			System.out.println("Which type of employee do you want to add?");
			System.out.println();
			System.out.println("1. Doctor                ");
			System.out.println("2. Nurse                 ");
			System.out.println("3. Receptionist          ");
			System.out.println("4. Janitor               ");
			System.out.println("5. Back to previous menu.");
			System.out.println("0. Exit the application ");
			userResponse = scanner.nextLine().trim().toUpperCase();
			System.out.println();

			String employeeName = "";
			switch (userResponse) {
			case "1":
				System.out.println("What is the doctor's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				System.out.println("What is the doctor's specialty area?");
				userResponse = scanner.nextLine().trim();
				System.out.println();
				Doctor doctor = new Doctor(employeeName, userResponse);
				hospital.addEmployeeToHospital(doctor);
				System.out.println("Dr. " + doctor.getEmployeeName() + " (" + doctor.getEmployeeNumber() + ") has been added.");
				System.out.println();
				break;
			case "2":
				System.out.println("What is the nurse's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				System.out.println("How many patients can this nurse handle concurrently?");
				userResponse = scanner.nextLine().trim();
				System.out.println();
				Nurse nurse = new Nurse(employeeName, Integer.parseInt(userResponse));
				hospital.addEmployeeToHospital(nurse);
				System.out.println("Nurse " + nurse.getEmployeeName() + " (" + nurse.getEmployeeNumber() + ")  has been added.");
				System.out.println();
				break;
			case "3":
				System.out.println("What is the receptionist's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				Receptionist receptionist = new Receptionist(employeeName);
				hospital.addEmployeeToHospital(receptionist);
				System.out.println("Receptionist " + receptionist.getEmployeeName() + " (" + receptionist.getEmployeeNumber() + ")  has been added.");
				System.out.println();
				System.out.println("Is " + receptionist.getEmployeeName() + " currently on the phone? [Y/N]");
				userResponse = scanner.nextLine().trim().toUpperCase();
				System.out.println();
				if (userResponse.equals("N")) {
					receptionist.setOnThePhone(false);
				}
				break;
			case "4":
				System.out.println("What is the janitor's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				Janitor janitor = new Janitor(employeeName);
				hospital.addEmployeeToHospital(janitor);
				System.out.println("Janitor " + janitor.getEmployeeName() + " (" + janitor.getEmployeeNumber() + ")  has been added.");
				System.out.println();
				System.out.println("Is " + janitor.getEmployeeName() + " currently sweeping? [Y/N]");
				userResponse = scanner.nextLine().trim().toUpperCase();
				System.out.println();
				if (userResponse.equals("N")) {
					janitor.setSweeping(false);
				}
				break;
			case "5":
				stayInMenu = false;
				break;
			case "0":
				terminateApplication();
				break;
			default:
				unknownUserResponse();
			}
		}
		stayInMenu = true;
	}

	private static void addPatientToTheHospital() {
		System.out.println("What is the patient's name?");
		userResponse = scanner.nextLine().trim();
		Patient patient = new Patient(userResponse);
		hospital.addPatientToHospital(patient);
		System.out.println();
		System.out.println("Patient " + patient.getPatientName() + " (" + patient.getPatientNumber() + ") has been admitted to the hospital.");
		System.out.println();
	}

	private static void terminateApplication() {
		System.out.println("Thank you for using the University Clinic Hospital application.");
		System.out.println("Have a nice day!");
		System.exit(0);
	}

	private static void unknownUserResponse() {
		System.out.println("Response not recognized.");
	}

	private static void displayEmployeeRecords() {
		System.out.println("Employees:");
		System.out.print(String.format("|%-15s", "Employee Number"));
		System.out.print(String.format("|%-15s", "Employee Name"));
		System.out.print(String.format("|%-15s", "Employee Type"));
		System.out.print(String.format("|%-18s", "Medical Specialty"));
		System.out.print(String.format("|%-15s", "Annual Salary"));
		System.out.print(String.format("|%-7s", "Paid?"));
		System.out.print(String.format("|%-9s|", "Working?"));
		System.out.println();
		System.out.println(
				"|----------------------------------------------------------------------------------------------------|");
		String[] employeeRecords = hospital.retrieveEmployeeRecords();
		for (String record : employeeRecords) {
			System.out.println(record);
		}
		System.out.println();
	}

	private static void displayPatientRecords() {
		System.out.println("Patients:");
		System.out.print(String.format("|%-15s", "Patient Number"));
		System.out.print(String.format("|%-15s", "Patient Name"));
		System.out.print(String.format("|%-15s", "Blood Level"));
		System.out.print(String.format("|%-15s|", "Health Level"));
		System.out.println();
		System.out.println("|---------------------------------------------------------------|");
		String[] patientRecords = hospital.retrievePatientRecords();
		for (String record : patientRecords) {
			System.out.println(record);
		}
		System.out.println();

	}

}
