package dev.taxmachine.simplehome;

import com.google.gson.Gson;
import dev.taxmachine.simplehome.interfaces.Config;
import dev.taxmachine.simplehome.interfaces.Home;
import dev.taxmachine.simplehome.utils.PathUtils;
import org.bukkit.World;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DbManager {
    private Config config;
    public DbManager() {
        config = new Config();
        config.players = new HashMap<>();
    }
    public void saveConfig() {
        String jsonStr = new Gson().toJson(config);
        String path = PathUtils.join(".", "homes.json");
        File configFile = new File(path);
        try {
            configFile.createNewFile();
            FileWriter fw = new FileWriter(path);
            fw.write(jsonStr);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadConfig() {
        String path = PathUtils.join(".", "homes.json");
        File configFile = new File(path);
        if (!configFile.exists()) return;
        try {
            Scanner scanner = new Scanner(configFile);
            StringBuilder jsonStr = new StringBuilder();
            while (scanner.hasNextLine()) jsonStr.append(scanner.nextLine());
            config = new Gson().fromJson(jsonStr.toString(), Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPlayerEntry(UUID uuid) {
        config.addPlayer(uuid);
    }

    public void addHome(UUID uuid, World world, String name, double x, double y, double z) {
        config.addHome(uuid, new Home(name, world, x, y, z));
    }

    public Home getHome(UUID uuid, String name) {
        return config.getHome(uuid, name);
    }

    public List<Home> getHomes(UUID uuid) {
        return config.players.get(uuid.toString());
    }

    public void removeHome(UUID uuid, String name) {
        config.removeHome(uuid, name);
    }

    public void setHomeLimit(int limit) {
        config.setHomeLimit(limit);
    }

    public Config getConfig() {
        return config;
    }
}
