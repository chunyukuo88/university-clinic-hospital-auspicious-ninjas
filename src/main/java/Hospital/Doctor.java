package Hospital;

public class Doctor extends Medical implements DrawBlood {

	private String specialtyArea = "";
	
	public Doctor(String employeeName, String specialtyArea) {
		super(employeeName);
		this.specialtyArea = specialtyArea;
		
	}

	public String getSpecialtyArea() {
		return specialtyArea;
	}

	public void setSpecialtyArea(String specialtyArea) {
		this.specialtyArea = specialtyArea;
	}

	//
	public void drawBlood(Patient patient) {
		int newBloodLevel = patient.getBloodLevel() - amountDrawnByDoc;
		patient.setBloodLevel(newBloodLevel);
	}
	
	

}
