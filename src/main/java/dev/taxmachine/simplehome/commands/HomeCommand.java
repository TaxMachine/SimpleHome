package dev.taxmachine.simplehome.commands;

import dev.taxmachine.simplehome.SimpleHome;
import dev.taxmachine.simplehome.interfaces.Home;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeCommand implements CommandExecutor {

    public HomeCommand() {
        super();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) return true;
        if (strings.length == 0) {
            commandSender.sendRichMessage("<red>Specify the home you want to teleport to</red>");
            return false;
        }
        String homename = strings[0];
        try {
            Home home = SimpleHome.DB_MANAGER.getHome(player.getUniqueId(), homename);
            Location location = new Location(Bukkit.getWorld(home.world), home.x, home.y, home.z, home.yaw, home.pitch);
            player.teleport(location);
            commandSender.sendRichMessage("Successfully teleported to <light_purple>" + homename + "</light_purple>");
            return true;
        } catch (IllegalArgumentException exception) {
            commandSender.sendRichMessage("<red>" + exception.getMessage() + "</red>");
        }
        return false;
    }
}
