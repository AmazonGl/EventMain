package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ReplaceOre extends Event {

    public static boolean canBreak = true;

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
                            Component.text("Удачная руда").color(NamedTextColor.DARK_AQUA)));
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,100,2);
        }
    }

    @Override
    public void negativeEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                canBreak = false;
                Bukkit.getServer().getScheduler().runTaskLater(EventCommandMain.getInstance(), () -> {
                    canBreak = true;
                }, 600L);
            }
        }
    }
}
