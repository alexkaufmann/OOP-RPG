package attributes;

import java.util.Enumeration;
import java.util.Hashtable;

public class StatBlock {
	public StatBlock(int health, int attack, int defense) {
		this.stats = new Hashtable<StatType, Stat>();
		stats.put(StatType.HEALTH, new Health(health));
		stats.put(StatType.ATTACK, new Stat("Attck", attack, StatType.ATTACK));
		stats.put(StatType.DEFENSE, new Stat("Defense", defense, StatType.DEFENSE));
	}
	
	private Hashtable<StatType, Stat> stats;
	
	public Enumeration<StatType> getEnum(){
		return this.stats.keys();
	}
	
	public Stat get(StatType type){
		return stats.get(type);
	}
	
	public void buffStat(StatType type, int value) {
		stats.get(type).buff(value);
		
	}
		
	public void debuffStat(StatType type, int value) {
		stats.get(type).debuff(value);
	}
	
	public String toString() {
		String string = "";
		Enumeration<StatType> e = this.stats.keys();
		
		while(e.hasMoreElements()) {
			string += this.stats.get(e.nextElement());
		}
		
		return string;
		
	}
}
