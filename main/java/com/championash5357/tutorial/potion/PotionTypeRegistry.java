package com.championash5357.tutorial.potion;

import com.championash5357.tutorial.client.Tutorial;
import com.google.common.base.Predicate;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;

public class PotionTypeRegistry extends PotionType{
	/*
	public static final PotionType FLY = new PotionType("fly", new PotionEffect[] {new PotionEffect(Tutorial.FLY_POTION, 2400)});
	public static final PotionType LONG_FLY = new PotionType("fly", new PotionEffect[] {new PotionEffect(Tutorial.FLY_POTION, 9600)});
	
	public static void registerPotionTypes() {
		PotionType.registerPotionType("fly", FLY);
		PotionType.registerPotionType("long_fly", LONG_FLY);
		Predicate<ItemStack> ender_eye = new PotionHelper.ItemPredicateInstance(Items.ENDER_EYE);
		Predicate<ItemStack> redstone = new PotionHelper.ItemPredicateInstance(Items.REDSTONE);
		PotionHelper.registerPotionTypeConversion(PotionTypes.INVISIBILITY, ender_eye, FLY);
		PotionHelper.registerPotionTypeConversion(FLY, redstone, LONG_FLY);
	}*/
}
