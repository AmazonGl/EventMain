package com.amazon.box;

import com.amazon.AbstractCommand;
import com.amazon.EventCommandMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class start extends AbstractCommand {

    private EventCommandMain main;
    public start(EventCommandMain main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (sender instanceof Player && !sender.isOp()) {
            sender.sendMessage(ChatColor.GREEN + "У вас нету прав для этого");
            return true;
        } else if (cmd.getName().equalsIgnoreCase("start")) {
            new time(main).startCountdown();
            sender.sendMessage(ChatColor.AQUA + "Вы запустили бедроковую коробку!");
            return true;
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }

}
