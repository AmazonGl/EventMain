package com.amazon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().getPersistentDataContainer().has(ExclusionsCommand.namespacedKey, PersistentDataType.STRING) && !EventCommandMain.exclusions.contains(event.getPlayer().getUniqueId())) {
            EventCommandMain.exclusions.add(event.getPlayer().getUniqueId());
        }
    }
}
