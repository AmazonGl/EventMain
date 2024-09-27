package com.amazon;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EventCommand extends AbstractCommand {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player && !sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "У вас нету прав для этого");
            return true;
        }

        for (EnumEvent value : EnumEvent.values()) {
            if (args[0].equals(value.name())) {
                value.getEvent().positiveEffect();
                value.getEvent().negativeEffect();
                value.getEvent().onEffect();
            }
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
            if (args.length == 1 && sender.isOp()) {
                ArrayList<String> alias = new ArrayList<>();
                for (EnumEvent value : EnumEvent.values()) {
                    alias.add(value.name());
                }

                ArrayList<String> refundable = new ArrayList<>();

                String lastWord = args[args.length - 1].toLowerCase();
                Player senderPlayer = sender instanceof Player ? (Player) sender : null;

                for (String s : alias) {
                    if (senderPlayer != null && s.toLowerCase().contains(lastWord)) {
                        refundable.add(s);
                    }
                }

                return refundable;
            }
            return null;
    }
}