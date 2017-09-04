package com.championash5357.tutorial.render;

import com.championash5357.tutorial.entity.EntityModdedIronGolem;
import com.championash5357.tutorial.entity.EntityRock;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderingRegistry {
	public static void registerEntityRenders() {
		net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(EntityRock.class, new IRenderFactory<EntityRock>() {

			@Override
			public Render<? super EntityRock> createRenderFor(RenderManager manager) {
				return new RenderRock(manager);
			}
		});
		net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler(EntityModdedIronGolem.class, new IRenderFactory<EntityModdedIronGolem>() {

			@Override
			public Render<? super EntityModdedIronGolem> createRenderFor(RenderManager manager) {
				return new RenderModdedIronGolem(manager);
			}
		});
	}
}
