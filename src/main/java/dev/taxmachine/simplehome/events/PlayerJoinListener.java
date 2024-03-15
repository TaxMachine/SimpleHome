package dev.taxmachine.simplehome.events;

import dev.taxmachine.simplehome.SimpleHome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        SimpleHome.DB_MANAGER.addPlayerEntry(event.getPlayer().getUniqueId());
        SimpleHome.LOGGER.info("Added player entry for " + event.getPlayer().getName());
    }
}
