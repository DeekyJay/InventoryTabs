package com.kqp.inventorytabs.tabs.provider;

import java.util.HashSet;
import java.util.Set;

import com.kqp.inventorytabs.tabs.tab.ChestTab;
import com.kqp.inventorytabs.tabs.tab.Tab;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

/**
 * Provides tabs for barrels.
 */
public class BarrelTabProvider extends BlockTabProvider {
    private final Set<Identifier> barrelBlocks = new HashSet<>();

    public void addBarrelBlock(Block block) {
        barrelBlocks.add(Registry.BLOCK.getId(block));
    }

    public void addBarrelBlock(Identifier blockId) {
        barrelBlocks.add(blockId);
    }

    public void removeBarrelBlockId(Identifier blockId) {
        barrelBlocks.remove(blockId);
    }

    public Set<Identifier> getBarrelBlockIds() {
        return this.barrelBlocks;
    }

    @Override
    public boolean matches(World world, BlockPos pos) {
        Block block = world.getBlockState(pos).getBlock();

        return barrelBlocks.contains(Registry.BLOCK.getId(block));
    }

    @Override
    public Tab createTab(World world, BlockPos pos) {
        return new ChestTab(Registry.BLOCK.getId(world.getBlockState(pos).getBlock()), pos);
    }
}
