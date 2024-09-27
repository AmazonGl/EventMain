package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class MoveItem extends Event {

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
                            Component.text("Любимая рука").color(NamedTextColor.WHITE)));
            player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP,100,2);
        }
    }

    @Override
    public void negativeEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                new BukkitRunnable() {
                    int sec = 1;

                    @Override
                    public void run() {
                        if (sec>6) {
                            this.cancel();
                            return;
                        }
                        ItemStack selectedItem = player.getInventory().getItemInMainHand();
                        ItemStack offHandItem = player.getInventory().getItemInOffHand();
                        if (selectedItem.getType().isAir() && offHandItem.getType().isAir()) {
                            return;
                        }
                        if (selectedItem.getType().isAir()) {
                            return;
                        }

                        if (selectedItem.getType().isAir()) {
                            player.getInventory().setItemInOffHand(selectedItem);
                            player.getInventory().remove(selectedItem);
                        }

                        if (!offHandItem.getType().isAir()) {
                            player.getInventory().setItemInMainHand(offHandItem);
                        }
                        player.getInventory().setItemInOffHand(selectedItem);
                        player.getInventory().setItemInMainHand(offHandItem);
                        sec++;
                    }
                }.runTaskTimer(EventCommandMain.getInstance(),0L,200L);
            }
        }
    }
}
