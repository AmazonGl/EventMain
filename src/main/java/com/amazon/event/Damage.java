package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.util.Ticks;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Damage extends Event {
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
                            Component.text("На грани").color(TextColor.color(0xFF0000))));
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,100,2);
        }
    }

    @Override
    public void negativeEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                player.setHealth(1);
            }
        }
    }

    @Override
    public void onEffect() {
        super.onEffect();
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (EventCommandMain.exclusions.contains(player.getUniqueId())) {
            }
        }
    }
}
