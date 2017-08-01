package com.championash5357.tutorial.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemStrawberry extends ItemFood{

	public ItemStrawberry(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName("strawberry");
		setRegistryName("itemstrawberry");
	}
}
