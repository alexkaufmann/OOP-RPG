package item;

import attributes.Stat;

public class Item {
	public Item(String name, ItemType type, SlotType slot, Stat[] statBlock) {
		this.name = name;
		this.type = type;
		this.slot = slot;
		this.statBlock = statBlock;
	}
	
	private String name;
	private ItemType type;
	private SlotType slot;
	private Stat[] statBlock;
	
	public String getName() {
		return name;
	}

	public ItemType getType() {
		return type;
	}

	public SlotType getSlot() {
		return slot;
	}

	public Stat[] getStatBlock() {
		return statBlock;
	}
}
