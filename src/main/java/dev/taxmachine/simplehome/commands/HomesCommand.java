package dev.taxmachine.simplehome.commands;

import dev.taxmachine.simplehome.SimpleHome;
import dev.taxmachine.simplehome.interfaces.Home;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomesCommand implements CommandExecutor {

    public HomesCommand() {
        super();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player player)) return true;
        List<Home> homes = SimpleHome.DB_MANAGER.getHomes(player.getUniqueId());
        String homesString = homes.stream().map(Home::getName).reduce("", (a, b) -> a + ", " + b);
        String msg = "Your homes: <light_purple>" + homesString + "</light_purple>";
        commandSender.sendRichMessage(msg);
        return false;
    }
}
