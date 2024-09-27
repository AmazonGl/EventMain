package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class firework extends Event {
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
                            Component.text("Новый год").color(NamedTextColor.GREEN)));
        }
    }

    @Override
    public void negativeEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                FireworkEffect effect = FireworkEffect.builder().withColor(Color.PURPLE).withFade(Color.ORANGE).withFade(Color.fromRGB(8073150)).with(FireworkEffect.Type.BURST).trail(false).flicker(true).build();
                Firework firework = (Firework)player.getWorld().spawnEntity(player.getPlayer().getLocation(), EntityType.FIREWORK);
                FireworkMeta fm = firework.getFireworkMeta();
                fm.addEffect(effect);
                fm.setPower(5);
                firework.setFireworkMeta(fm);
                firework.detonate();
            }
        }
    }
}