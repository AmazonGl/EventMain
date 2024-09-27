package com.amazon;

import com.amazon.box.start;
import com.amazon.gui.EventMenuOneCMD;
import com.amazon.gui.EventMenuTwoCMD;
import com.amazon.gui.MenuEvents;
import com.amazon.item.Pickaxe3x3;
import com.amazon.item.PickaxeListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public final class EventCommandMain extends JavaPlugin {
    public static EventCommandMain instance;
    public static ArrayList<UUID> exclusions = new ArrayList();
    public ArrayList<Player> vanished = new ArrayList<>();

    public void onEnable() {
        instance = this;
        new EventRandomCommand().register(this, "eventrandom");
        new ExclusionsCommand().register(this, "exclusion");
        new EventCommand().register(this, "event");
        new EventMenuOneCMD().register(this,"e");
        new EventMenuTwoCMD().register(this,"e2");
        getCommand("start").setExecutor(new start(this));
        Bukkit.getPluginManager().registerEvents(new ActionListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PickaxeListener(), this);
        Bukkit.getPluginManager().registerEvents(new MenuEvents(),this);
    }

    public void onDisable() {

    }

    public static EventCommandMain getInstance() {
        return instance;
    }
}
