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
		setHasBeenPaid(false); // Default here, or should it be defaulted in the set method?
	}

	public void paySalary() {
		// Change to abstract method to be called by the Hospital class...
	};

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isHasBeenPaid() {
		return hasBeenPaid;
	}

	public void setHasBeenPaid(boolean hasBeenPaid) {
		this.hasBeenPaid = hasBeenPaid;
	}

}
