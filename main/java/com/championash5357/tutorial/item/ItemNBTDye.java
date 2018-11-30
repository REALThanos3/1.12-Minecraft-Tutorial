package com.championash5357.tutorial.item;

import com.championash5357.tutorial.util.DyeUtil;
import com.championash5357.tutorial.util.DyeUtil.DyeType;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemNBTDye extends Item {
	
	public ItemNBTDye() {
		setRegistryName("dye");
		setUnlocalizedName("itemdye");
		setCreativeTab(CreativeTabs.MISC);
		setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if(this.isInCreativeTab(tab)) {
			for(DyeType dye : DyeType.values())
				items.add(DyeUtil.createDye(new ItemStack(this), dye));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + DyeUtil.getRegistryNameFromNBT(stack);
	}
}
