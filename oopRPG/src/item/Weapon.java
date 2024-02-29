package item;

import attributes.Stat;

public class Weapon extends Equipable {
	public Weapon(String name, Stat[] statBlock) {
		super(name, ItemType.WEAPON, SlotType.PRIMARY, statBlock);
	}
}
