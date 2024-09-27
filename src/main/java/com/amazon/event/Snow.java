package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.entity.Player;

public class Snow  extends Event {
    @Override
    public void positiveEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            player.showTitle(
                    Title.title(
                            Component.text().color(TextColor.color(0x808080))
                                    .append(Component.text("! ").decoration(TextDecoration.OBFUSCATED, true))
                                    .append(Component.text("Ивент").color(TextColor.color(0xF0F020)))
                                    .append(Component.text(" !").color(TextColor.color(0x808080)).decoration(TextDecoration.OBFUSCATED, true))
                                    .build(),
                            Component.text("Морозная кучка").color(NamedTextColor.WHITE)));
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,100,2);
        }
    }

    @Override
    public void negativeEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                Location playerLocation = player.getLocation();
                for (int y = -1; y >= -2; y--) {
                    for (int x = -1; x <= 1; x++) {
                        for (int z = -1; z <= 1; z++) {
                            Location blockLocation = playerLocation.clone().add(x, y, z);
                            if (blockLocation.getBlock().getType() != Material.BEDROCK) {
                                blockLocation.getBlock().setType(Material.POWDER_SNOW);
                            }
                        }
                    }
                }
            }
        }
    }
}
