package com.amazon.item;

import com.amazon.event.ReplaceOre;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.stream.Collectors;

public class PickaxeListener implements Listener {
    private static Material[] disabledBlock;

    static {
        disabledBlock = new Material[]{Material.BEDROCK};
    }
    Map<UUID, BlockFace> playerBlockFace = new HashMap<>();
    Map<UUID, List<Block>> playerBlocks = new HashMap<>();

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
            if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                playerBlockFace.put(event.getPlayer().getUniqueId(), event.getBlockFace());
            }
    }

    @EventHandler
    public void onMine(BlockBreakEvent event) {
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        Player player = event.getPlayer();
        Block block = event.getBlock();
        UUID playerId = player.getUniqueId();
        if (item == null) {
            return;
        }
        if (!item.getType().equals(Material.DIAMOND_PICKAXE)) {
            return;
        }
        if (!item.hasItemMeta()) {
            return;
        }
        if (!item.getEnchantments().containsKey(Enchantment.DIG_SPEED)) {
            return;
        }
        if (!item.getItemMeta().hasLore()) {
            return;
        }
        if (!item.getItemMeta().getLore().contains("§6Копает 3 на 3 блока")) {
            return;
        }
        if (ReplaceOre.canBreak == false) {
            return;
        }

        if (player.isSneaking()) {
            return;
        }

        BlockFace blockface = playerBlockFace.get(playerId);
        List<Block> blocks = new ArrayList<>();

        if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
            blocks.add(block.getRelative(BlockFace.EAST));
            blocks.add(block.getRelative(BlockFace.WEST));
            blocks.add(block.getRelative(BlockFace.NORTH));
            blocks.add(block.getRelative(BlockFace.SOUTH));
            blocks.add(block.getRelative(BlockFace.SOUTH_WEST));
            blocks.add(block.getRelative(BlockFace.SOUTH_EAST));
            blocks.add(block.getRelative(BlockFace.NORTH_WEST));
            blocks.add(block.getRelative(BlockFace.NORTH_EAST));
        }
        if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
            blocks.add(block.getRelative(BlockFace.UP));
            blocks.add(block.getRelative(BlockFace.DOWN));
            blocks.add(block.getRelative(BlockFace.NORTH));
            blocks.add(block.getRelative(BlockFace.SOUTH));
            blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
            blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
            blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.NORTH));
            blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.SOUTH));
        }
        if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
            blocks.add(block.getRelative(BlockFace.UP));
            blocks.add(block.getRelative(BlockFace.DOWN));
            blocks.add(block.getRelative(BlockFace.EAST));
            blocks.add(block.getRelative(BlockFace.WEST));
            blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
            blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
            blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
            blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
        }
        for (Block b : blocks) {
            if (!(Arrays.stream(disabledBlock).collect(Collectors.toList())).contains(b.getType())) {
                b.breakNaturally();
            }

        }
        playerBlocks.put(playerId, blocks);
    }
}
