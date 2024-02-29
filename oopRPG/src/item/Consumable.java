package item;

import attributes.Stat;

public class Consumable extends Item{
	public Consumable(String name, Stat[] statBlock) {
		super(name, ItemType.CONSUMABLE, SlotType.NONE, statBlock);
	}

}
