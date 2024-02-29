package character;

import java.util.Enumeration;

import attributes.StatType;
import equipment.EquipmentBlock;
import item.Equipable;

public class Player extends Character{

	//
	public Player(String name, int health, int attack, int defense) {
		super(name, health, attack, defense);
		this.level = 1;
		this.experience = 0;
		this.nextLevel = 10;
		this.equipment = new EquipmentBlock();
	}
	
	public Player(String name, int health, int attack, int defense, int level) {
		super(name, health, attack, defense);
		this.level = level;
		this.experience = 0;
		this.nextLevel = 10 * level;
		this.equipment = new EquipmentBlock();
	}
	
	public Player(String name, int health, int attack, int defense, int level, int experience) {
		super(name, health, attack, defense);
		this.level = level;
		this.experience = experience;
		this.nextLevel = 10 * level;
		this.equipment = new EquipmentBlock();
	}

	private EquipmentBlock equipment;
	
	private int level;
	private int experience;
	private int nextLevel;
	
	public void attack(NPC target) {
		super.attack(target);
		if(!target.isAlive()) {
			System.out.printf("%s has gained %d exp!%n%n", this.getName(), target.getExperice());
			this.gainExp(target.getExperice());
			this.hasLeveledUp();
		}
	}
	
	public void gainExp(int experience) {
		this.experience += experience;
	}
	
	public boolean hasLeveledUp() {
		if(experience > nextLevel) {
			System.out.printf("%s have leveled up!%n%n", this.getName());
			this.level++;
			this.experience -= this.nextLevel;
			this.nextLevel = 10 * this.level;
			this.getHealth().levelUp(10);
			this.getAttack().levelUp(2);
			this.getDefense().levelUp(2);
			System.out.printf("%s is now level %d!%n%n", this.getName(), this.level);
			return true;
		}else {
			return false;
		}
	}
	
	public void equip(Equipable equipment) {
		this.equipment.equip(equipment);
		this.checkEquipment();
	}
	
	public void checkEquipment() {
		Enumeration<StatType> e = this.getStats().getEnum();
		
		while(e.hasMoreElements()) {
			StatType type = e.nextElement();
			int effect = this.equipment.getEffect(type);
			if(effect > 0) {
				this.getStats().get(type).buff(effect);
			}else {
				this.getStats().get(type).debuff(effect);
			}
			
		}
	}
}
