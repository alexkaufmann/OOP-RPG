package character;

import attributes.Health;
import attributes.Stat;
import attributes.StatBlock;
import attributes.StatType;

public class Character {
	//Constructor
	public Character(String name, int health, int attack, int defense) {
		this.name = name;
		this.stats = new StatBlock(health, attack, defense);
	}
	
	private String name;
	private StatBlock stats;
	
	public void attack(Character target){
		System.out.printf("%s attacks %s!%n%n", this.getName(), target.getName());
		target.defend(this.getAttack());
	}
	
	public void defend(Stat attack) {
		if(attack.getValue() - this.getDefense().getValue() <= 0) {
			System.out.printf("%s is hit for 1 damage!%n%n", this.getName());
			this.getHealth().damage(1);
		}else {
			System.out.printf("%s is hit for %d damage!%n%n", this.getName(), attack.getValue() - this.getDefense().getValue());
			this.getHealth().damage(attack.getValue() - this.getDefense().getValue());
		}
		
		if(this.isAlive()) {
			System.out.printf("%s has %d health left!%n%n", this.getName(), this.getHealth().getValue());
		}else {
			System.out.printf("%s has been defeated!%n%n", this.getName());
		}
	}
	
	public boolean isAlive() {
		return this.getHealth().getValue() > 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public StatBlock getStats() {
		return this.stats;
	}

	public Health getHealth() {
		return (Health) stats.get(StatType.HEALTH);
	}

	public Stat getAttack() {
		return stats.get(StatType.ATTACK);
	}

	public Stat getDefense() {
		return stats.get(StatType.DEFENSE);
	}
	
	
	public String toString() {
		return String.format(
				"-----------------------%n" +
				"%s Stats: %n%n" + 
				stats +
				"-----------------------%n%n", 
				this.name);
	}
	
}
