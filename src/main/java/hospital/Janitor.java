package hospital;

public class Janitor extends Employee {

	private boolean isSweeping = true;
	
	public Janitor(String employeeName) {
		super(employeeName);
		this.setSalary(40_000);
	}

	public boolean getSweeping() {
		return isSweeping;
	}

	public void setSweeping(boolean isSweeping) {
		this.isSweeping = isSweeping;
	}

	public void fightZombies() {
		Hospital.zombiesInHospital -= 3;
	}

}
