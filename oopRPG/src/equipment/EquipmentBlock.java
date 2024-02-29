package equipment;

import java.util.Enumeration;
import java.util.Hashtable;

import attributes.StatType;
import item.Equipable;
import item.SlotType;

public class EquipmentBlock {

	public EquipmentBlock() {
		this.equipment = new Hashtable<SlotType, EquipmentSlot>();
		equipment.put(SlotType.HEAD, new EquipmentSlot("Head", SlotType.HEAD));
		equipment.put(SlotType.BODY, new EquipmentSlot("Body", SlotType.BODY));
		equipment.put(SlotType.PRIMARY, new EquipmentSlot("Primary", SlotType.PRIMARY));
		equipment.put(SlotType.SECONDARY, new EquipmentSlot("Secondary", SlotType.SECONDARY));
		equipment.put(SlotType.ACCESSORY, new EquipmentSlot("Accessory", SlotType.ACCESSORY));
	}
	
	private Hashtable<SlotType, EquipmentSlot> equipment;
	
	public int getEffect(StatType type) {
		int value = 0;
		
		Enumeration<SlotType> e = this.equipment.keys();
		while(e.hasMoreElements()) {
			value += this.equipment.get(e.nextElement()).getEffect(type);
		}
		
		return value;
	}

	public void equip(Equipable equipment) {
		this.equipment.get(equipment.getSlot()).equip(equipment);
	}
	
	
}
