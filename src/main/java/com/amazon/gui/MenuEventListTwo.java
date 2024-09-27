package com.amazon.gui;

import com.amazon.gui.util.Util;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class MenuEventListTwo {

    public static final MenuEventListTwo instance = new MenuEventListTwo();

    public final Inventory inventory = Bukkit.createInventory(null,45,"ВЫБОР ИВЕНТА");

    MenuEventListTwo(){

        inventory.setItem(10, Util.CreateItemStack(Material.BARRIER, "Бедная кирка", TextColor.color(NamedTextColor.BLUE), Arrays.asList(
                Component.text("Выбранный предмет игрока, будет удален.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(12, Util.CreateItemStack(Material.REDSTONE, "На грани", TextColor.color(NamedTextColor.RED), Arrays.asList(
                Component.text("У игрока остается 0.5 сердец.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(14, Util.CreateItemStack(Material.POWDER_SNOW_BUCKET, "Морозная кучка", TextColor.color(NamedTextColor.WHITE), Arrays.asList(
                Component.text("Под игроком появится рыхлый снег, 3x3x2 блока.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(16, Util.CreateItemStack(Material.CAVE_SPIDER_SPAWN_EGG, "''Лучший друг''", TextColor.color(NamedTextColor.AQUA), Arrays.asList(
                Component.text("Призывает пещерного паука.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text("При убийстве, дает эффект отравления на 20 секунд.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(28, Util.CreateItemStack(Material.ENDER_EYE, "Магический инвентарь", TextColor.color(NamedTextColor.GOLD), Arrays.asList(
                Component.text("В течении 30 секунд, у игрока будет").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text("перемешиваться весь инвентарь.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(30, Util.CreateItemStack(Material.TOTEM_OF_UNDYING, "Нужно отдохнуть", TextColor.color(NamedTextColor.YELLOW), Arrays.asList(
                Component.text("В течении 10 секунд, игрок не сможет").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text("двигаться и ломать блоки.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(32, Util.CreateItemStack(Material.GUNPOWDER, "Обернись", TextColor.color(NamedTextColor.GREEN), Arrays.asList(
                Component.text("Игроку будет призван звук, взрыва крипера.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(34, Util.CreateItemStack(Material.BEDROCK, "Разрушение всех кроватей", TextColor.color(NamedTextColor.DARK_RED), TextDecoration.OBFUSCATED, Arrays.asList(
                Component.text("Все кровати будут разрушены, в том числе и ваша.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false).decorate(TextDecoration.OBFUSCATED),
                Component.text(""),
                Component.text("Нажмите, чтобы выбрать ивент").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));

        inventory.setItem(36, Util.CreateItemStack(Material.YELLOW_DYE, "Назад", TextColor.color(NamedTextColor.LIGHT_PURPLE), Arrays.asList(
                Component.text("Предыдущая страница.").color(TextColor.color(NamedTextColor.GRAY)).decoration(TextDecoration.ITALIC, false),
                Component.text(""),
                Component.text("Нажмите, чтобы переключиться").color(TextColor.color(NamedTextColor.LIGHT_PURPLE)).decoration(TextDecoration.ITALIC, false)
        )));
    }
}
