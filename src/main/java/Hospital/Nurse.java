package Hospital;

public class Nurse extends Medical {

	private int numberOfPatients = 0;
	
	public Nurse(String employeeName, int numberOfPatients) {
		super(employeeName);
		setNumberOfPatients(numberOfPatients);
		this.setSalary(50_000);
	}

	public int getNumberOfPatients() {
		return numberOfPatients;
	}

	public void setNumberOfPatients(int numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}

}
