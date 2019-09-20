package hospital;

public class Patient {

	private String patientName = "";
	private int patientNumber = 1; // change to random number
	private int bloodLevel = 20;
	private int healthLevel = 10;
	
	public Patient(String nameOfPatient) {
		this.setPatientName(nameOfPatient);
		patientNumber++;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getBloodLevel() {
		return bloodLevel;
	}

	public void setBloodLevel(int bloodLevel) {
		this.bloodLevel = bloodLevel;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}

	public Integer getPatientNumber() {
		return patientNumber;
	}
	
}
