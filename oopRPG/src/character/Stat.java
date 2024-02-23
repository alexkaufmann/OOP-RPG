package character;

public class Stat {
	
	//Constructor
	public Stat(String name, int value) {
		this.name = name;
		this.currentValue = value;
		this.baseValue = value;
	}

	//Name of stat
	private String name;
	//Current value of stat 
	private int currentValue;
	//Base value of stat
	private int baseValue;
	
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
	
}
