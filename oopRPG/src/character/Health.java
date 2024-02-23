package character;

public class Health extends Stat{

	public Health(int value) {
		super("Health", value);
	}
	
	public void heal(int value) {
		if(this.getValue() + value > this.getBaseValue()) {
			this.reset();
		}else {
			this.buff(value);
		}	
	}
	
	public void damage(int value) {
		if(this.getValue() - value < 0) {
			this.debuff(this.getValue());
		}else {
			this.debuff(value);
		}
	}

}
