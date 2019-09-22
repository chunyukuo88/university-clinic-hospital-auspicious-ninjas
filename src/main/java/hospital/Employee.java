package hospital;

import java.util.Random;

public abstract class Employee {

	private String employeeName;
	private int employeeNumber;
	private int salary;
	private boolean hasBeenPaid;

	public Employee(String employeeName) {
		setEmployeeName(employeeName);
		setEmployeeNumber(this.newValue());
		setSalary(0); 
		setHasBeenPaid(false);
	}

	public boolean paySalary() {
		
		boolean ableToPayEmployee = true;
		
		if (this.hasBeenPaid()) {
			ableToPayEmployee = false;
		} else {
			setHasBeenPaid(true);
		}
		
		return ableToPayEmployee;
	};

	public String getEmployeeName() {
		return employeeName;
	}

	public void killZombie(Hospital hospital, Zombie zombie) {
		hospital.removeZombieFromHospital(zombie);
	}
	
	private void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	private void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getSalary() {
		return salary;
	}

	protected void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean hasBeenPaid() {
		return hasBeenPaid;
	}

	private void setHasBeenPaid(boolean hasBeenPaid) {
		this.hasBeenPaid = hasBeenPaid;
	}

	public String getEmployeeType() {
		String employeeType = "";
		if (this instanceof Doctor) {
			employeeType = "Doctor";
		} else if (this instanceof Nurse) {
			employeeType = "Nurse";
		} else if (this instanceof Receptionist) {
			employeeType = "Receptionist";
		} else if (this instanceof Janitor) {
			employeeType = "Janitor";
		} else {
			employeeType = "Unknown";
		}
		return employeeType;
	}

	public int newValue() {
		Random rand = new Random();
		int randomNum = rand.nextInt(999999);
		return randomNum;
	}
}
