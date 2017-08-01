package com.championash5357.tutorial.potion;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionFly extends Potion {

	public PotionFly() {
		super(false, 8376831);
		setPotionName("effect.fly");
		setIconIndex(3, 2);
		setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + "fly"));
	}
}