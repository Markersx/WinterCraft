package net.mcwintercraft.wintercraft.entity;

import net.minecraft.server.v1_10_R1.*;
import org.bukkit.Location;

public class EntityGhostBlock extends EntityFallingBlock {

    public EntityGhostBlock(World world, Block block, Location loc) {
        super(world);
        this.world.setTypeAndData(new BlockPosition(this), block.getBlockData(), 3);
        this.i = true;
        this.setSize(0.98F, 0.98F);
        this.a(new BlockPosition(this));
        setNoGravity(true);
        setInvulnerable(true);
    }
}
