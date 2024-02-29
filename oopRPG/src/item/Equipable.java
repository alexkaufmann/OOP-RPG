package item;

import attributes.Stat;
import attributes.StatType;

public class Equipable extends Item{
	public Equipable(String name, ItemType type, SlotType slot, Stat[] statBlock) throws IllegalArgumentException {
		super(name, type, slot, statBlock);
		if(type == ItemType.CONSUMABLE) {
			throw new IllegalArgumentException("Equipable items cannot be a CONSUMABLE ItemType");
		}
		
		if(slot == SlotType.NONE) {
			throw new IllegalArgumentException("Equipable items cannot have SlotType NONE");
		}
	}
	
	public boolean affectsStatType(StatType type) {
		for(Stat stat : this.getStatBlock()) {
			if(stat.getType() == type) {
				return true;
			}
		}
		
		return false;
	}
	
	public int getEffect(StatType type) {
		for(Stat stat : this.getStatBlock()) {
			if(stat.getType() == type) {
				return stat.getValue();
			}
		}
		
		return 0;
	}
}
