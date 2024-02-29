package attributes;

public class Stat {
	
	//Constructor
	public Stat(String name, int value, StatType type) {
		this.name = name;
		this.currentValue = value;
		this.baseValue = value;
		this.type = type;
	}

	//Name of stat
	private String name;
	//Current value of stat 
	private int currentValue;
	//Base value of stat
	private int baseValue;
	//Type of stat
	private StatType type;
	
	//Get Name
	public String getName() {
		return this.name;
	}
	
	//Get Current Value
	public int getValue() {
		return this.currentValue;
	}
	
	public int getBaseValue() {
		return this.baseValue;
	}
	
	public StatType getType() {
		return this.type;
	}
	
	//Increase currentValue
	public void buff(int value) {
		this.currentValue += value;
	}
	
	//Decrease currentValue
	public void debuff(int value) {
		this.currentValue -= value;
	}
	
	public void levelUp(int value) {
		this.baseValue += value;
		this.reset();
	}
	
	//Rest currentValue to baseValue
	public void reset() {
		this.currentValue = this.baseValue;
	}
	
	public String toString() {
		return String.format("   %-10s: %d %n%n", this.name, this.currentValue);
	}
	
}
