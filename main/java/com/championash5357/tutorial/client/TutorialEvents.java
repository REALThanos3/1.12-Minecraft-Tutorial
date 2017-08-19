package com.championash5357.tutorial.client;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TutorialEvents {
	
	@SubscribeEvent
	public void onFly(TickEvent.PlayerTickEvent event) {
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
}