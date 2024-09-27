package com.amazon;

import com.amazon.event.BedBreak;
import com.amazon.event.BreakAllBed;
import com.amazon.event.ReplaceOre;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ActionListener implements Listener {

    public static NamespacedKey namespacedKey = new NamespacedKey(EventCommandMain.getInstance(), "cavespider");

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof CaveSpider) {
            if (event.getEntity().getPersistentDataContainer().has(namespacedKey, PersistentDataType.STRING)) {
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 10));
            }
        }

    }

    @EventHandler
    public void onBreakOre(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block b = event.getBlock();
        if (ReplaceOre.canBreak == false) {
            if (b.getType() == Material.EMERALD_ORE || b.getType() == Material.GOLD_BLOCK) {
                event.setCancelled(true);
                b.setType(Material.STONE);
            }

        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block b = event.getBlock();
        if (BedBreak.canBreak == false) {
            if (!EventCommandMain.exclusions.contains(player.getUniqueId()) && player.getGameMode() == GameMode.SURVIVAL) {
                if (b.getType() == Material.RED_BED) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.RED + "Ты не можешь сломать кровать, в данный момент идёт ивент");
                }
            }
        }
    }

    @EventHandler
    public void delBed(PlayerPickupItemEvent event) {
        ItemStack item = event.getItem().getItemStack();
            if (BreakAllBed.PicUpBed == false) {
                if (item.getType() == Material.RED_BED) {
                    event.setCancelled(true);
                }
            }
    }
}
