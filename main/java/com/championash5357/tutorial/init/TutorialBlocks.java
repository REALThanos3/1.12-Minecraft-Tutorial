package com.championash5357.tutorial.init;

import com.championash5357.tutorial.block.BlockDualFurnace;
import com.championash5357.tutorial.block.BlockModdedFence;
import com.championash5357.tutorial.block.BlockStrawberry;
import com.championash5357.tutorial.block.BlockWeirdCobblestone;
import com.championash5357.tutorial.tileentity.TileEntityDualFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TutorialBlocks {
	
	public static Block purple_glowstone_fence;
	public static Block dual_furnace;
	public static Block strawberry_crop;
	public static Block weird_cobblestone;
	
	public static void init() {
		purple_glowstone_fence = new BlockModdedFence(Material.GLASS, MapColor.PURPLE).setUnlocalizedName("purple_glowstone_fence").setRegistryName("blockpurpleglowstonefence");
		dual_furnace = new BlockDualFurnace();
		strawberry_crop = new BlockStrawberry();
		weird_cobblestone = new BlockWeirdCobblestone();
	}
	
	public static void register() {
		registerBlock(purple_glowstone_fence);
		registerBlock(dual_furnace);
		GameRegistry.registerTileEntity(TileEntityDualFurnace.class, "dual_furnace");
		registerBlock(strawberry_crop);
		registerBlock(weird_cobblestone);
	}
	
	private static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders() {
		registerRender(purple_glowstone_fence);
		registerRender(dual_furnace);
		registerRender(strawberry_crop);
		registerRender(weird_cobblestone);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
