package net.mcwintercraft.wintercraft.entity;

import com.google.common.collect.Sets;
import net.mcwintercraft.wintercraft.WinterCraft;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import net.minecraft.server.v1_10_R1.*;
import org.bukkit.craftbukkit.v1_10_R1.event.CraftEventFactory;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class EntityTurkey extends EntityChicken {

    private static final Set<Item> bF;
    private ArrayList<ItemStack> drops = new ArrayList<>();
    private boolean forceDrops;
    private ItemStack rawTurkey;
    private ItemStack cookedTurkey;
    private ItemStack turkeyFeather;
    private ItemStack turkeyEgg;


    public EntityTurkey(World world) {
        super(world);
        this.setSize(0.4F, 0.7F);
        this.bD = this.random.nextInt(6000) + 18000;
        this.a(PathType.WATER, 0.0F);
        this.setCustomName(ChatColor.GOLD + "Turkey");
        this.setCustomNameVisible(true);
        rawTurkey = ItemStacks.RAW_TURKEY.getItem();
        cookedTurkey = ItemStacks.COOKED_TURKEY.getItem();
        turkeyFeather = ItemStacks.TURKEY_FEATHER.getItem();
        turkeyEgg = ItemStacks.TURKEY_EGG.getItem();
    }

    static {
        bF = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    }

    @Override
    protected void r() {
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalPanic(this, 1.4D));
        this.goalSelector.a(2, new PathfinderGoalBreed(this, 1.0D));
        this.goalSelector.a(3, new PathfinderGoalTempt(this, 1.0D, false, bF));
        this.goalSelector.a(4, new PathfinderGoalAvoidTarget(this, EntityHuman.class, 8.0F, 2.2D, 2.2D));
        this.goalSelector.a(5, new PathfinderGoalAvoidTarget(this, EntityWolf.class, 8.0F, 2.2D, 2.2D));
        this.goalSelector.a(6, new PathfinderGoalFollowParent(this, 1.1D));
        this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 6.0F));
        this.goalSelector.a(9, new PathfinderGoalRandomLookaround(this));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.maxHealth).setValue(7.0D);
        this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.4D);
    }

    @Override
    public void n() {
        if (this.isChickenJockey()) {
            this.persistent = !this.isTypeNotPersistent();
        }

        super.n();
        this.bB = this.bx;
        this.bz = this.by;
        this.by = (float) ((double) this.by + (double) (this.onGround ? -1 : 4) * 0.3D);
        this.by = MathHelper.a(this.by, 0.0F, 1.0F);
        if (!this.onGround && this.bC < 1.0F) {
            this.bC = 1.0F;
        }

        this.bC = (float) ((double) this.bC * 0.9D);
        if (!this.onGround && this.motY < 0.0D) {
            this.motY *= 0.6D;
        }

        this.bx += this.bC * 2.0F;
        if (!this.world.isClientSide && !this.isBaby() && !this.isChickenJockey() && --this.bD <= 0) {
            this.a(SoundEffects.aa, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.forceDrops = true;
            this.a(CraftItemStack.asNMSCopy(turkeyEgg), 0.0F);
            this.forceDrops = false;
            this.bD = this.random.nextInt(6000) + 18000;
        }

    }

    @Override
    public float ci() {
        return this.isBaby() ? (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.7F : (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.9F;
    }

    @Override
    public void D() {
        SoundEffect soundeffect = this.G();
        if (soundeffect != null) {
            this.a(soundeffect, this.ch(), this.ci());
            new BukkitRunnable() {
                @Override
                public void run() {
                    a(soundeffect, 1, ci());
                }
            }.runTaskLater(WinterCraft.instance, 10);
        }
    }

    @Override
    public EntityItem a(net.minecraft.server.v1_10_R1.ItemStack itemstack, float f) {
        if(itemstack.count != 0 && itemstack.getItem() != null) {
            if(!this.forceDrops) {
                if (itemstack.doMaterialsMatch(CraftItemStack.asNMSCopy(rawTurkey))) {
                    itemstack = CraftItemStack.asNMSCopy(rawTurkey);
                }
                if (itemstack.doMaterialsMatch(CraftItemStack.asNMSCopy(cookedTurkey))) {
                    itemstack = CraftItemStack.asNMSCopy(cookedTurkey);
                }
                if (itemstack.doMaterialsMatch(CraftItemStack.asNMSCopy(turkeyFeather))) {
                    itemstack = CraftItemStack.asNMSCopy(turkeyFeather);
                }
                drops.add(CraftItemStack.asBukkitCopy(itemstack));
                return null;
            } else {
                EntityItem entityitem = new EntityItem(this.world, this.locX, this.locY + (double)f, this.locZ, itemstack);
                entityitem.q();
                this.world.addEntity(entityitem);
                return entityitem;
            }
        } else {
            return null;
        }
    }

    @Override
    public void die(DamageSource damagesource) {
        if(!this.aV) {
            Entity entity = damagesource.getEntity();
            EntityLiving entityliving = this.bZ();
            if(this.bc >= 0 && entityliving != null) {
                entityliving.b(this, this.bc);
            }

            if(entity != null) {
                entity.b(this);
            }

            this.aV = true;
            this.getCombatTracker().g();
            if(!this.world.isClientSide) {
                int i = 0;
                if(entity instanceof EntityHuman) {
                    i = EnchantmentManager.h((EntityLiving)entity);
                }

                if(this.isDropExperience() && this.world.getGameRules().getBoolean("doMobLoot")) {
                    boolean flag = this.lastDamageByPlayerTime > 0;
                    this.a(flag, i, damagesource);
                    CraftEventFactory.callEntityDeathEvent(this, this.drops);
                    WinterCraft.instance.debug("Called Drops");
                    this.drops = new ArrayList<>();
                } else {
                    CraftEventFactory.callEntityDeathEvent(this);
                    WinterCraft.instance.debug("Not Called Drops");
                }
            }

            this.world.broadcastEntityEffect(this, (byte) 3);
        }

    }

    public void a(SoundEffect soundeffect, float f, float f1) {
        if (!this.isSilent()) {
            this.world.a(null, this.locX, this.locY, this.locZ, soundeffect, this.bC(), f, f1);
        }
    }

}
