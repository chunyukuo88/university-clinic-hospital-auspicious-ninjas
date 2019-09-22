package hospital;

import java.util.Random;

public class Patient {

	private String patientName = "";
	private String patientNumber = "";
	private int bloodLevel = 20;
	private int healthLevel = 10;
	
	public Patient(String nameOfPatient) {
		this.setPatientName(nameOfPatient);
		this.setPatientNumber();
	}

	private void setPatientNumber() {
		String patientNumber = String.valueOf(newValue());
		this.patientNumber = patientNumber;
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

	public String getPatientNumber() {
		return patientNumber;
	}
	
	public int newValue() {
		Random rand = new Random();
		int randomNum = rand.nextInt(999999);
		return randomNum;
	}
	
}
