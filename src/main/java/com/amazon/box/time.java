package com.amazon.box;

import com.amazon.EventCommandMain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.util.Ticks;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class time implements Listener {
    private EventCommandMain main;
    public time(EventCommandMain main) {
        this.main = main;
    }

    public void startCountdown() {
        new BukkitRunnable() {

            int number = 10;

            @Override
            public void run() {
                if (number > 0) {
                    if (number == 10) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.showTitle(
                                    Title.title(
                                            Component.text("Приготовтесь!").color(TextColor.color(0xF0F000)),
                                            Component.text("С вас лайк и подписка").color(TextColor.color(0xF0F016)),
                                            Title.Times.times(Ticks.duration(10), Ticks.duration(25), Ticks.duration(25))));
                            player.playSound(player, Sound.UI_BUTTON_CLICK,100,1);
                        }
                    }
                    if (number == 5) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.YELLOW + "Игра начнётся через 5 секунд!");
                            player.showTitle(
                                    Title.title(
                                            Component.text("5").color(TextColor.color(0xF0F030)),
                                            Component.text(""),
                                            Title.Times.times(Ticks.duration(0), Ticks.duration(25), Ticks.duration(0))));
                            player.playSound(player, Sound.UI_BUTTON_CLICK,100,1);
                        }
                    }
                    if (number == 4) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.YELLOW + "Игра начнётся через 4 секунды!");
                            player.showTitle(
                                    Title.title(
                                            Component.text("4").color(TextColor.color(0xF0F030)),
                                            Component.text(""),
                                            Title.Times.times(Ticks.duration(0), Ticks.duration(25), Ticks.duration(0))));
                            player.playSound(player, Sound.UI_BUTTON_CLICK,100,1);
                        }
                    }
                    if (number == 3) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.YELLOW + "Игра начнётся через 3 секунды!");
                            player.showTitle(
                                    Title.title(
                                            Component.text("3").color(TextColor.color(0xF0F030)),
                                            Component.text(""),
                                            Title.Times.times(Ticks.duration(0), Ticks.duration(25), Ticks.duration(0))));
                            player.playSound(player, Sound.UI_STONECUTTER_TAKE_RESULT,100,1);
                        }
                    }
                    if (number == 2) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.YELLOW + "Игра начнётся через 2 секунды!");
                            player.showTitle(
                                    Title.title(
                                            Component.text("2").color(TextColor.color(0xF0F030)),
                                            Component.text(""),
                                            Title.Times.times(Ticks.duration(0), Ticks.duration(25), Ticks.duration(0))));
                            player.playSound(player, Sound.UI_STONECUTTER_TAKE_RESULT,100,1);
                        }
                    }
                    if (number == 1) {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.sendMessage(ChatColor.YELLOW + "Игра начнётся через 1 секунду!");
                            player.showTitle(
                                    Title.title(
                                            Component.text("1").color(TextColor.color(0xF0F030)),
                                            Component.text(""),
                                            Title.Times.times(Ticks.duration(0), Ticks.duration(25), Ticks.duration(0))));
                            player.playSound(player, Sound.UI_STONECUTTER_TAKE_RESULT,100,1);
                        }
                    }
                    number--;
                } else {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.showTitle(
                                Title.title(
                                        Component.text("Игра началась").color(TextColor.color(0xF0F034)),
                                        Component.text("Удачи!").color(TextColor.color(0xF0F024)),
                                        Title.Times.times(Ticks.duration(0), Ticks.duration(25), Ticks.duration(25))));
                        player.playSound(player, Sound.ITEM_GOAT_HORN_SOUND_2, 100, 1.9F);
                        player.setGameMode(GameMode.SURVIVAL);
                        ItemStack itemStack = new ItemStack(Material.WOODEN_PICKAXE);
                        player.getInventory().addItem(itemStack);
                        cancel();
                    }
                }
            }
        }.runTaskTimer(main,0L, 20L);
    }
}
