package dev.taxmachine.simplehome.commands;

import dev.taxmachine.simplehome.SimpleHome;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHomeCommand implements CommandExecutor {

    public SetHomeCommand() {
        super();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) return true;
        if (strings.length == 0) {
            commandSender.sendRichMessage("<red>Specify the name of the home you want to set</red>");
            return true;
        }
        String homename = strings[0];
        World world = player.getWorld();
        try {
            SimpleHome.DB_MANAGER.addHome(player.getUniqueId(), world, homename, player.getX(), player.getY(), player.getZ(), player.getYaw(), player.getPitch());
            commandSender.sendRichMessage("Successfully added <light_purple>" + homename + "</light_purple> to your home list");
            return true;
        } catch (IllegalArgumentException exception) {
            commandSender.sendRichMessage("<red>" + exception.getMessage() + "</red>");
        }
        return false;
    }
}
