package com.championash5357.tutorial.world.dimension;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent;

public class ChunkGeneratorTutorial implements IChunkGenerator {
	
	private final World world;
	private final boolean generateStructures;
	private final Random rand;
	
	public ChunkGeneratorTutorial(World world, boolean generateStructures, long seed) {
		this.world = world;
		this.generateStructures = generateStructures;
		this.rand = new Random(seed);
	}
	
	@Override
	public Chunk generateChunk(int x, int z) {
		this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer chunkprimer = new ChunkPrimer();
		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
		Biome[] biome = this.world.getBiomeProvider().getBiomes((Biome[])null, x * 16, z * 16, 16, 16);
		byte[] abyte = chunk.getBiomeArray();
		
		for(int i = 0; i < abyte.length; ++i) abyte[i] = (byte)Biome.getIdForBiome(biome[i]);
		chunk.resetRelightChecks();
		
		return chunk;
	}

	@Override
	public void populate(int x, int z) {
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		Biome biome = this.world.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}

}
