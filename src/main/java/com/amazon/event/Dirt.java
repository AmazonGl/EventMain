package com.amazon.event;

import com.amazon.Event;
import com.amazon.EventCommandMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Dirt extends Event {
    @Override
    public void positiveEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (EventCommandMain.exclusions.contains(player.getUniqueId())) {
                player.getInventory().addItem(new ItemStack(Material.DIAMOND, 10));
            }
        }
    }

    @Override
    public void negativeEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                player.sendActionBar(ChatColor.GOLD + "У вас есть 3 секунды, чтобы сохранить вещи!");
                Bukkit.getServer().getScheduler().runTaskLater(EventCommandMain.getInstance(), () -> {
                        player.sendActionBar(ChatColor.RED + "Весь инвентарь был заполнен землей!");
                    for (int i = 0; i < 36; i++) {
                        player.getInventory().setItem(i, new ItemStack(Material.DIRT, 1));
                    }
                },40L);
            }
        }
    }
}
