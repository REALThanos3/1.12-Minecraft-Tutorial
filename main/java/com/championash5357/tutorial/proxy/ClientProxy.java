package com.championash5357.tutorial.proxy;

import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.init.TutorialItems;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void register() {
		TutorialBlocks.registerRenders();
		TutorialItems.registerRenders();
	}
}
