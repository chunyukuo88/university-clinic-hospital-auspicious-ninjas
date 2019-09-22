package hospital;

import java.util.Random;

public class Zombie {

	int	zombieHP = 0; 
	String zombieID = "";
	
	public Zombie() {
		this.zombieID = String.valueOf(this.newValue(999999));
		this.zombieHP = this.newValue(100);
	}
	
	public int getZombieHP() {
		return zombieHP;
	}

	public void setZombieHP(int zombieHP) {
		this.zombieHP = zombieHP;
	}

	public String getZombieID() {
		return zombieID;
	}

	public void setZombieID(String zombieID) {
		this.zombieID = zombieID;
	}	
	
	public int newValue(int maxValue) {
		Random rand = new Random();
		int randomNum = rand.nextInt(maxValue);
		return randomNum;
	}
}
