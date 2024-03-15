package dev.taxmachine.simplehome.commands;

import dev.taxmachine.simplehome.SimpleHome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DelHomeCommand implements CommandExecutor {
    public DelHomeCommand() {
        super();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof org.bukkit.entity.Player player)) return true;
        if (strings.length == 0) {
            commandSender.sendRichMessage("<red>Specify the name of the home you want to delete</red>");
            return true;
        }
        String homename = strings[0];
        try {
            SimpleHome.DB_MANAGER.removeHome(player.getUniqueId(), homename);
            commandSender.sendRichMessage("Successfully deleted <light_purple>" + homename + "</light_purple> from your home list");
            return true;
        } catch (IllegalArgumentException exception) {
            commandSender.sendRichMessage("<red>" + exception.getMessage() + "</red>");
        }
        return false;
    }
}
