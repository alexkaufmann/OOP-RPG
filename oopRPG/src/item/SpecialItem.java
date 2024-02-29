package item;

import attributes.Stat;

public class SpecialItem extends Item{
	public SpecialItem(String name, Stat[] statBlock) {
		super(name, ItemType.SPECIAL, SlotType.PASSIVE, statBlock);
	}

}
