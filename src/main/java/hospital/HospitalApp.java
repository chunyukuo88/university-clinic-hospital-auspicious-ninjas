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
		System.out.println("Please choose an option from the following menu:");
		System.out.println("1. Add an employee to the hospital.     [EMP]");
		System.out.println("2. Admit a new patient to the hospital. [PAT]");
		System.out.println("3. View all hospital employees.         [EMV]");
		System.out.println("4. View all admitted patients.          [PAV]");
		System.out.println("5. Exit the application.                [END]");

		userResponse = scanner.nextLine().trim().toUpperCase();
		System.out.println();

		switch (userResponse) {
		case "EMP":
			addEmployeeToTheHospital();
			break;
		case "PAT":
			addPatientToTheHospital();
			break;
		case "EMV":
			displayEmployeeRecords();
			break;
		case "PAV":
			displayPatientRecords();
			break;
		case "END":
			terminateApplication();
			break;
		default:
			System.out.println("Response not recognized.");
		}
	}

	private static void addEmployeeToTheHospital() {
		stayInMenu = true;
		while (stayInMenu) {

			System.out.println("Which type of employee do you want to add?");
			System.out.println();
			System.out.println("1. Doctor                 [DOC]");
			System.out.println("2. Nurse                  [NUR]");
			System.out.println("3. Receptionist           [REP]");
			System.out.println("4. Janitor                [JAN]");
			System.out.println("5. Back to previous menu. [PRE]");
			System.out.println("6. Exit the application.  [END]");
			userResponse = scanner.nextLine().trim().toUpperCase();
			System.out.println();

			String employeeName = "";
			switch (userResponse) {
			case "DOC":
				System.out.println("What is the doctor's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				System.out.println("What is the doctor's specialty area?");
				userResponse = scanner.nextLine().trim();
				System.out.println();
				Doctor doctor = new Doctor(employeeName, userResponse);
				hospital.addEmployeeToHospital(doctor);
				System.out.println("Dr. " + doctor.getEmployeeName() + " has been added.");
				System.out.println();
				break;
			case "NUR":
				System.out.println("What is the nurse's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				System.out.println("How many patients can this nurse handle concurrently?");
				userResponse = scanner.nextLine().trim();
				System.out.println();
				Nurse nurse = new Nurse(employeeName, Integer.parseInt(userResponse));
				hospital.addEmployeeToHospital(nurse);
				System.out.println("Nurse " + nurse.getEmployeeName() + " has been added.");
				System.out.println();
				break;
			case "REP":
				System.out.println("What is the receptionist's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				Receptionist receptionist = new Receptionist(employeeName);
				hospital.addEmployeeToHospital(receptionist);
				System.out.println("Receptionist " + receptionist.getEmployeeName() + " has been added.");
				System.out.println();
				System.out.println("Is " + receptionist.getEmployeeName() + " currently on the phone? [Y/N]");
				userResponse = scanner.nextLine().trim().toUpperCase();
				System.out.println();
				if (userResponse.equals("N")) {
					receptionist.setOnThePhone(false);
				}
				break;
			case "JAN":
				System.out.println("What is the janitor's name?");
				employeeName = scanner.nextLine().trim();
				System.out.println();
				Janitor janitor = new Janitor(employeeName);
				hospital.addEmployeeToHospital(janitor);
				System.out.println("Receptionist " + janitor.getEmployeeName() + " has been added.");
				System.out.println();
				System.out.println("Is " + janitor.getEmployeeName() + " currently sweeping? [Y/N]");
				userResponse = scanner.nextLine().trim().toUpperCase();
				System.out.println();
				if (userResponse.equals("N")) {
					janitor.setSweeping(false);
				}
				break;
			case "PRE":
				stayInMenu = false;
				break;
			case "END":
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
		System.out.println("Patient " + patient.getPatientName() + " has been admitted to the hospital.");
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
		System.out.println("|----------------------------------------------------------------------------------------------------|");	
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
