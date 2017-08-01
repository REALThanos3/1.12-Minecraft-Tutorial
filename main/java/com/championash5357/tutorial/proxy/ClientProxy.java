package com.championash5357.tutorial.proxy;

import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.init.TutorialItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void register() {
		TutorialBlocks.registerRenders();
		TutorialItems.registerRenders();
	}
}
