package com.championash5357.tutorial.client;

import com.championash5357.tutorial.enchantment.EnchantmentFly;
import com.championash5357.tutorial.entity.EntityRegistry;
import com.championash5357.tutorial.gui.DualFurnaceGuiHandler;
import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.init.TutorialFluids;
import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.potion.PotionFly;
import com.championash5357.tutorial.potion.PotionTypeRegistry;
import com.championash5357.tutorial.proxy.CommonProxy;
import com.championash5357.tutorial.recipe.DualFurnaceRecipes;
import com.championash5357.tutorial.render.RenderingRegistry;
import com.google.common.base.Predicate;
import com.google.gson.JsonObject;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Tutorial {
	
	@Instance(Reference.MOD_ID)
	public static Tutorial instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Enchantment FLY = new EnchantmentFly(Rarity.VERY_RARE, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
	public static final Potion FLY_POTION = new PotionFly();
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TutorialFluids.register();
		TutorialBlocks.init();
		TutorialBlocks.register();
		TutorialItems.init();
		TutorialItems.register();
		ForgeRegistries.ENCHANTMENTS.register(FLY);
		ForgeRegistries.POTIONS.register(FLY_POTION);
		PotionTypeRegistry.registerPotionTypes();
		RenderingRegistry.registerEntityRenders();
		OreDictionary.registerOre("furnace", Blocks.FURNACE);
		OreDictionary.registerOre("furnace", TutorialBlocks.dual_furnace);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.register();
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new DualFurnaceGuiHandler());
		MinecraftForge.EVENT_BUS.register(new TutorialEvents());
		EntityRegistry.registerEntities();
		GameRegistry.addSmelting(Items.LEATHER_HELMET, new ItemStack(TutorialItems.fly_helmet), 20.0f);
		GameRegistry.addSmelting(Items.LEATHER_CHESTPLATE, new ItemStack(TutorialItems.fly_chestplate), 20.0f);
		GameRegistry.addSmelting(Items.LEATHER_LEGGINGS, new ItemStack(TutorialItems.fly_leggings), 20.0f);
		GameRegistry.addSmelting(Items.LEATHER_BOOTS, new ItemStack(TutorialItems.fly_boots), 20.0f);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		
	}
}