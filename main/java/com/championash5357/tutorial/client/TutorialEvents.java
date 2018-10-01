package com.championash5357.tutorial.client;

import com.championash5357.tutorial.gui.gui.GuiUpdatedInventory;
import com.championash5357.tutorial.init.TutorialBlocks.BlockRegistration;
import com.championash5357.tutorial.init.TutorialItems.ItemRegistration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class TutorialEvents {
	
	@SubscribeEvent
	public static void onFly(TickEvent.PlayerTickEvent event) {
		boolean fly = false;
		if(event.player.inventory.armorInventory.get(0) != null) {
			int f = EnchantmentHelper.getEnchantmentLevel(Tutorial.FLY, event.player.inventory.armorInventory.get(0));
			if(f != 0)
				fly = true;
		}
		if(event.player.isPotionActive(Tutorial.FLY_POTION))
			fly = true;
		if(fly || event.player.isCreative() || event.player.isSpectator()) {
			event.player.capabilities.allowFlying = true;
			event.player.fallDistance = 0.0f;
		} else {
			fly = false;
			event.player.capabilities.isFlying = false;
			event.player.capabilities.allowFlying = false;
		}
	}
	
	@SubscribeEvent
	public static void registerModels(final ModelRegistryEvent event) {
		final NonNullList<Item> items = NonNullList.<Item>create();
		items.addAll(BlockRegistration.ITEM_BLOCKS);
		items.addAll(ItemRegistration.ITEMS);
		
		for(Item item : items)
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@SubscribeEvent
	public static void openGui(GuiOpenEvent event) {
		if(event.getGui() instanceof GuiInventory) event.setGui(new GuiUpdatedInventory(Minecraft.getMinecraft().player));
	}
}