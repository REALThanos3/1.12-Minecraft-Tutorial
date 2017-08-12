package com.championash5357.tutorial.init;

import com.championash5357.tutorial.item.ItemFlyArmor;
import com.championash5357.tutorial.item.ItemRock;
import com.championash5357.tutorial.item.ItemStrawberry;
import com.championash5357.tutorial.item.ItemStrawberrySeeds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TutorialItems {
	
	public static ArmorMaterial FlyArmor = EnumHelper.addArmorMaterial("FlyArmor", "tutorial:fly", 40, new int[]{1,5,3,1}, 20, SoundEvents.BLOCK_ANVIL_LAND, 0.0f);
	public static Item fly_helmet;
	public static Item fly_chestplate;
	public static Item fly_leggings;
	public static Item fly_boots;
	
	public static Item strawberry_seeds;
	public static Item strawberry;
	
	public static Item rock;
	
	public static void init() {
		strawberry_seeds = new ItemStrawberrySeeds(TutorialBlocks.strawberry_crop, Blocks.FARMLAND);
		strawberry = new ItemStrawberry(2, 1.0f, false);
		fly_helmet = new ItemFlyArmor(FlyArmor, 1, EntityEquipmentSlot.HEAD).setUnlocalizedName("fly_helmet").setRegistryName("itemflyhelmet");
		fly_chestplate = new ItemFlyArmor(FlyArmor, 1, EntityEquipmentSlot.CHEST).setUnlocalizedName("fly_chestplate").setRegistryName("itemflychestplate");
		fly_leggings = new ItemFlyArmor(FlyArmor, 2, EntityEquipmentSlot.LEGS).setUnlocalizedName("fly_leggings").setRegistryName("itemflyleggings");
		fly_boots = new ItemFlyArmor(FlyArmor, 1, EntityEquipmentSlot.FEET).setUnlocalizedName("fly_boots").setRegistryName("itemflyboots");
		rock = new ItemRock();
	}
	
	public static void register() {
		registerItem(strawberry_seeds);
		registerItem(strawberry);
		registerItem(fly_helmet);
		registerItem(fly_chestplate);
		registerItem(fly_leggings);
		registerItem(fly_boots);
		registerItem(rock);
	}
	
	private static void registerItem(Item item) {
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders() {
		registerRender(strawberry_seeds);
		registerRender(strawberry);
		registerRender(fly_helmet);
		registerRender(fly_chestplate);
		registerRender(fly_leggings);
		registerRender(fly_boots);
		registerRender(rock);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}