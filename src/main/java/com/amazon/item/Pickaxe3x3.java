package com.amazon.item;

import com.amazon.AbstractCommand;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class Pickaxe3x3 extends AbstractCommand {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack itemStack = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§7Кирка §63x3");
            itemMeta.setLore(Arrays.asList("§6Копает 3 на 3 блока"));
            itemStack.setItemMeta(itemMeta);
            itemStack.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
            player.getInventory().addItem(itemStack);
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }
}
