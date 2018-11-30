package com.championash5357.tutorial.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DyeUtil {
	
	public static ItemStack createDye(ItemStack stack, DyeType dye) {
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setString("Dye", dye.getName());
		
		stack.setTagCompound(tag);
		
		return stack;
	}
	
	public static String getRegistryNameFromNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {
			if(stack.getTagCompound().hasKey("Dye")) {
				return stack.getTagCompound().getString("Dye");
			}
		}
		return "white";
	}
	
	public static enum DyeType {
		WHITE("white"),
		ORANGE("orange"),
		MAGENTA("magenta"),
		LIGHT_BLUE("light_blue"),
		YELLOW("yellow"),
		LIME("lime"),
		PINK("pink"),
		GRAY("gray"),
		SILVER("silver"),
		CYAN("cyan"),
		PURPLE("purple"),
		BLUE("blue"),
		BROWN("brown"),
		GREEN("green"),
		RED("red"),
		BLACK("black");
		
		private String name;
		
		private DyeType(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
	}
}
