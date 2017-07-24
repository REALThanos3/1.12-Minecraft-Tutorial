package com.championash5357.tutorial.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentFly extends Enchantment{

	public EnchantmentFly(Rarity rarityIn, EntityEquipmentSlot[] slots) {
		super(rarityIn, EnumEnchantmentType.ARMOR_FEET, slots);
		this.setName("fly");
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 30 * enchantmentLevel;
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
}
