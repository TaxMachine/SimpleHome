package dev.taxmachine.simplehome.commands;

import dev.taxmachine.simplehome.SimpleHome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SetHomeLimitCommand implements CommandExecutor {

    public SetHomeLimitCommand() {
        super();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            commandSender.sendRichMessage("<red>Specify the new home limit</red>");
            return true;
        }
        try {
            int newLimit = Integer.parseInt(strings[0]);
            SimpleHome.DB_MANAGER.setHomeLimit(newLimit);
            commandSender.sendRichMessage("Successfully set the home limit to <light_purple>" + newLimit + "</light_purple>");
            return true;
        } catch (NumberFormatException exception) {
            commandSender.sendRichMessage("<red>Invalid number</red>");
        }
        return false;
    }
}
