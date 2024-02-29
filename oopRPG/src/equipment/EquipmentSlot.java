package equipment;

import attributes.StatType;
import item.Equipable;
import item.SlotType;

public class EquipmentSlot {
	
	public EquipmentSlot(String name, SlotType slot) {
		this.name = name;
		this.slot = slot;
		this.equipment = null;
	}
	
	public EquipmentSlot(String name, SlotType slot, Equipable equipment) throws IllegalArgumentException {
		if(equipment.getSlot() != slot) {
			throw new IllegalArgumentException("Slot Type Mismatch");
		}
		this.name = name;
		this.slot = slot;
		this.equipment = equipment;
	}
	
	private String name;
	private SlotType slot;
	private Equipable equipment;
	
	public void equip(Equipable equipment) throws IllegalArgumentException {
		if(equipment.getSlot() != this.slot) {
			throw new IllegalArgumentException("Slot Type Mismatch");
		}
		
		this.equipment = equipment;
	}
	
	public boolean affectsStatType(StatType type) {
		if(this.equipment == null) {
			return false;
		}
		return this.equipment.affectsStatType(type);
	}

	
	public int getEffect(StatType type) {
		if(this.equipment == null) {
			return 0;
		}
		return this.equipment.getEffect(type);
	}
	
	public String getName() {
		return name;
	}

	public SlotType getSlot() {
		return slot;
	}

	public Equipable getEquipment() {
		return equipment;
	}
}
