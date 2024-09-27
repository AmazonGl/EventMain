package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BreakAllBed extends Event {
    public static boolean PicUpBed = true;

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
                            Component.text("Разрушение всех кроватей").color(NamedTextColor.DARK_RED)));
            player.playSound(player, Sound.ENTITY_ENDER_DRAGON_AMBIENT,100,2);
        }
    }

    @Override
    public void negativeEffect() {
        PicUpBed = false;
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            player.getInventory().remove(Material.RED_BED);
            World world = Bukkit.getWorld("world");
            Location center = new Location(world, 36, 56, 36);
            int radius = 100;
            for (int x = center.getBlockX() - radius; x <= center.getBlockX() + radius; x++) {
                for (int y = center.getBlockY() - radius; y <= center.getBlockY() + radius; y++) {
                    for (int z = center.getBlockZ() - radius; z <= center.getBlockZ() + radius; z++) {
                        Block block = world.getBlockAt(x, y, z);
                        if (block.getType() == Material.RED_BED) {
                            block.setType(Material.AIR);
                        }
                    }
                }
            }
        }
    }
}
