package com.amazon;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
public abstract class Event {
    public abstract void positiveEffect();

    public abstract void negativeEffect();

    public void onEffect() {
        for (Player player : EventCommandMain.getInstance().getServer().getOnlinePlayers()) {
            //player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 10, 1);
        }
    }

    public void triggerEffects() {
        positiveEffect();
        negativeEffect();
        onEffect();
    }
}
