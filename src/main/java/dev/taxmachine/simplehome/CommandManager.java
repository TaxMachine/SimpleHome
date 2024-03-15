package dev.taxmachine.simplehome;

import dev.taxmachine.simplehome.commands.*;
import org.bukkit.command.CommandExecutor;

import java.util.HashMap;

public class CommandManager {
    public static HashMap<String, CommandExecutor> commands = new HashMap<>();

    static {
        commands.put("home", new HomeCommand());
        commands.put("sethome", new SetHomeCommand());
        commands.put("homes", new HomesCommand());
        commands.put("sethomelimit", new SetHomeLimitCommand());
        commands.put("delhome", new DelHomeCommand());
    }
}
