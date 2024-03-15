package dev.taxmachine.simplehome;

import com.google.gson.Gson;
import dev.taxmachine.simplehome.commands.*;
import dev.taxmachine.simplehome.events.PlayerJoinListener;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

public final class SimpleHome extends JavaPlugin {

    public static DbManager DB_MANAGER;
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        LOGGER = LoggerFactory.getLogger(SimpleHome.class);
        DB_MANAGER = new DbManager();
        DB_MANAGER.loadConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        for (Map.Entry<String, CommandExecutor> entry : CommandManager.commands.entrySet()) {
            Objects.requireNonNull(getCommand(entry.getKey())).setExecutor(entry.getValue());
            LOGGER.info("Registered command: " + entry.getKey());
        }
    }

    @Override
    public void onDisable() {
        DB_MANAGER.saveConfig();
    }
}
