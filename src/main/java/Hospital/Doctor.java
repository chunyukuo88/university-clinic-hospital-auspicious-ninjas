package Hospital;

public class Doctor extends Medical {

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
	
	

}
