package com.championash5357.tutorial.init;

import com.championash5357.tutorial.client.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TutorialMusic {
	
	public static SoundEvent perspectives;
	
	public static void registerSounds() {
		perspectives = registerSound("perspectives");
	}
	
	private static SoundEvent registerSound(String soundName) {
		final SoundEvent sound = new SoundEvent(new ResourceLocation(Reference.MOD_ID, soundName)).setRegistryName(new ResourceLocation(Reference.MOD_ID, soundName));
		ForgeRegistries.SOUND_EVENTS.register(sound);
		return sound;
	}
}
