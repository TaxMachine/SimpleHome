package dev.taxmachine.simplehome.interfaces;

import org.bukkit.World;

public class Home {
    public String name;
    public String world;
    public double x, y, z;
    public float yaw, pitch;

    public Home(String name, World world, double x, double y, double z, float yaw, float pitch) {
        this.name = name;
        this.world = world.getName();
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public String getName() {
        return name;
    }

    public String getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }
}
