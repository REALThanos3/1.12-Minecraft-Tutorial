package com.championash5357.tutorial.render;

import com.championash5357.tutorial.entity.EntityRock;
import com.championash5357.tutorial.init.TutorialItems;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderingRegistry {
	public static void registerEntityRenders() {
		net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(EntityRock.class, new IRenderFactory<EntityRock>() {

			@Override
			public Render<? super EntityRock> createRenderFor(RenderManager manager) {
				return new RenderRock(manager);
			}
		});
	}
}
