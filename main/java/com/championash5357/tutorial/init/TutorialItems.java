package com.championash5357.tutorial.init;

import com.championash5357.tutorial.item.ItemStrawberry;
import com.championash5357.tutorial.item.ItemStrawberrySeeds;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialItems {
	
	public static Item strawberry_seeds;
	public static Item strawberry;
	
	public static void init() {
		strawberry_seeds = new ItemStrawberrySeeds(TutorialBlocks.strawberry_crop, Blocks.FARMLAND);
		strawberry = new ItemStrawberry(2, 1.0f, false);
	}
	
	public static void register() {
		registerItem(strawberry_seeds);
		registerItem(strawberry);
	}
	
	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders() {
		registerRender(strawberry_seeds);
		registerRender(strawberry);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
