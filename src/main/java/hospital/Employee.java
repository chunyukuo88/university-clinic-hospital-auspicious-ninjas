package Hospital;

public class Employee {

	private String employeeName;
	private int employeeNumber;
	private int salary;
	private boolean hasBeenPaid;

	public Employee(String employeeName) {
		setEmployeeName(employeeName);
		setEmployeeNumber(1); // Update to set to a random number.
		setSalary(0); // Change for each subclass...
		setHasBeenPaid(false);
	}

	public void paySalary() {
		setHasBeenPaid(true);
	};

	public String getEmployeeName() {
		return employeeName;
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

	public boolean isHasBeenPaid() {
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
}
