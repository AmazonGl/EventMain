package com.amazon;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExclusionsCommand extends AbstractCommand {

    public static NamespacedKey namespacedKey = new NamespacedKey(EventCommandMain.getInstance(), "exclusions");
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player && !sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "У вас нету прав для этого");
            return true;
        }

        if (args.length == 2) {
            Player player = Bukkit.getPlayer(args[1]);
            if (player == null) return true;
            if (args[0].equals("add") && !EventCommandMain.exclusions.contains(player.getUniqueId())) {
                EventCommandMain.exclusions.add(player.getUniqueId());
                player.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, "");
            } else if (args[0].equals("remove")) {
                boolean remove = EventCommandMain.exclusions.remove(player.getUniqueId());
                if (remove) {
                    player.getPersistentDataContainer().remove(namespacedKey);
                }
            }
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 1) {
            ArrayList<String> alias = new ArrayList<>();
            alias.add("add");
            alias.add("remove");
            ArrayList<String> refundable = new ArrayList<>();

            String lastWord = args[args.length - 1];
            Player senderPlayer = sender instanceof Player ? (Player) sender : null;

            for (String s : alias) {
                if (senderPlayer != null && StringUtil.startsWithIgnoreCase(s, lastWord)) {
                    refundable.add(s);
                }
            }

            return refundable;
        }
        return null;
    }
}
