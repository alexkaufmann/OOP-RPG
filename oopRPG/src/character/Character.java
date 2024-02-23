package character;

public class Character {
	//Constructor
	public Character(String name, int health, int attack, int defense) {
		this.name = name;
		this.health = new Health(health);
		this.attack = new Stat("Attack", attack);
		this.defense = new Stat("Defense", defense);
	}
	
	private String name;
	private Health health;
	private Stat attack;
	private Stat defense;
	
	public String getName() {
		return this.name;
	}
	
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

	public Health getHealth() {
		return health;
	}

	public Stat getAttack() {
		return attack;
	}

	public Stat getDefense() {
		return defense;
	}
	
	
	
	
}
