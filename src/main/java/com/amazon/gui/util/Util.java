package com.amazon.gui.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Util {

    public static ItemStack CreateItemStack (Material material, String name, TextColor color) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        Component displayname = Component.text(name).color(color);
        meta.displayName(displayname);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack CreateItemStack (Material material, String name, TextColor color, List<TextComponent> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        Component displayname = Component.text(name).color(color).decoration(TextDecoration.ITALIC, false);
        meta.displayName(displayname);
        //List<Component> textLore = new ArrayList<>();
//        for (String line : lore) {
//             textLore.add(Component.text(line));
//        }
//        for (TextComponent line : lore) {
//            if (line == null || line.isEmpty()) {
//                textLore.add(Component.text("").color(color));
//            } else {
//                textLore.add(Component.text(line).color(color));
//            }
//            textLore.add(line);
//        }
        meta.lore(new ArrayList<>(lore));
        //meta.lore(textLore);

        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack CreateItemStack (Material material, String name, TextColor color, TextDecoration textDecoration, List<TextComponent> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();
        Component displayname = Component.text(name).color(color).decoration(TextDecoration.ITALIC, false).decorate(textDecoration);
        meta.displayName(displayname);
        meta.lore(new ArrayList<>(lore));

        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
