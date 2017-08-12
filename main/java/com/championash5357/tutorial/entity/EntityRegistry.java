package com.championash5357.tutorial.entity;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.client.Tutorial;

import net.minecraft.util.ResourceLocation;

public class EntityRegistry {
	public static void registerEntities() {
		net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":rock"), EntityRock.class, "Rock", -1, Tutorial.instance, 64, 1, true);
	}
}
