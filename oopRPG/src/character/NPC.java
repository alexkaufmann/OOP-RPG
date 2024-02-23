package character;

public class NPC extends Character{
	//Constructor
	public NPC(String name, int health, int attack, int defense, int experience) {
		super(name, health, attack, defense);
		this.experience = experience;
	}
	
	private int experience;
	
	public int getExperice() {
		return this.experience;
	}
}
