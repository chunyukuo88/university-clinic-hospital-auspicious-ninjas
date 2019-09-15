package Hospital;

public class Receptionist extends Employee {

	private boolean isOnThePhone = true;
	
	public Receptionist(String employeeName) {
		super(employeeName);
		this.setSalary(45_000);
	}

	public boolean isOnThePhone() {
		return isOnThePhone;
	}

	public void setOnThePhone(boolean isOnThePhone) {
		this.isOnThePhone = isOnThePhone;
	}

}
