package net.mcwintercraft.wintercraft.entity;

import net.mcwintercraft.wintercraft.WinterCraft;
import net.minecraft.server.v1_10_R1.Entity;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;

import java.lang.reflect.Field;
import java.util.Map;

public enum EntityTypes {

    TURKEY("Turkey", 93, EntityTurkey.class),
    GHOSTBLOCK("GhostBlock", 21, EntityGhostBlock.class);

    private String name;
    private int id;
    private Class customClass;

    EntityTypes(String name, int id, Class<? extends Entity> customClass) {
        this.name = name;
        this.id = id;
        this.customClass = customClass;
    }

    public static void spawn(Entity entity, Location loc) {
        entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        ((CraftWorld)loc.getWorld()).getHandle().addEntity(entity);
    }

    public static Object getPrivateField(String fieldName, Class clazz, Object object) {

        Field field;
        Object o = null;

        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            o = field.get(object);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return o;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Class getCustomClass() {
        return customClass;
    }

    private void addToMaps(Class clazz, String name, int id) {
        ((Map)getPrivateField("c", net.minecraft.server.v1_10_R1.EntityTypes.class, null)).put(name, clazz);
        ((Map)getPrivateField("d", net.minecraft.server.v1_10_R1.EntityTypes.class, null)).put(clazz, name);
        ((Map)getPrivateField("f", net.minecraft.server.v1_10_R1.EntityTypes.class, null)).put(clazz, id);
        WinterCraft.instance.debug("Custom entity " + name + " has been registered!");
    }

    private void removeFromMaps(Class clazz, String name, int id) {
        ((Map)getPrivateField("c", net.minecraft.server.v1_10_R1.EntityTypes.class, null)).remove(name, clazz);
        ((Map)getPrivateField("d", net.minecraft.server.v1_10_R1.EntityTypes.class, null)).remove(clazz, name);
        ((Map)getPrivateField("f", net.minecraft.server.v1_10_R1.EntityTypes.class, null)).remove(clazz, id);
        WinterCraft.instance.debug("Custom entity " + name + " has been unregistered!");
    }

    public void register(String name, int id, Class<? extends Entity> customClass) {
        addToMaps(customClass, name, id);
    }

    public void unregister(String name, int id, Class customClass) {
        removeFromMaps(customClass, name, id);
    }
}
