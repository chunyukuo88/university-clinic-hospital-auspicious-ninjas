package hospital;

public class Zombie {

	int	zombieHP = 70; //Maybe give max of 100 at some point.
	int zombieID = 0;
	
	public int getZombieHP() {
		return zombieHP;
	}

	public void setZombieHP(int zombieHP) {
		this.zombieHP = zombieHP;
	}

	public int getZombieID() {
		return zombieID;
	}

	public void setZombieID(int zombieID) {
		this.zombieID = zombieID;
	}

	public Zombie(int idOfZombie) {
		this.zombieID = idOfZombie;
	}
}
