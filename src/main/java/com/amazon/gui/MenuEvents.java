package com.amazon.gui;

import com.amazon.EnumEvent;
import com.amazon.gui.util.ColorUril;
import com.amazon.gui.util.Util;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;


public class MenuEvents implements Listener {

    @EventHandler
    public void onClickMenuOne(InventoryClickEvent event) {
        if (event.getInventory() == MenuEventListOne.instance.inventory) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null) {
                String itemname = ((TextComponent) event.getCurrentItem().getItemMeta().displayName()).content();
                Player player = (Player) event.getWhoClicked();

                if (itemname.equals("Горячая штучка") && event.getSlot() == 10) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &6Горячая штучка");
                    EnumEvent.LAVA.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Любимая рука") && event.getSlot() == 12) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &fЛюбимая рука");
                    EnumEvent.MOVEITEM.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Смещение во времени") && event.getSlot() == 14) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &bСмещение во времени");
                    EnumEvent.SPIN.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("БУМ") && event.getSlot() == 16) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &cБУМ");
                    EnumEvent.BOOM.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Новый год") && event.getSlot() == 28) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &aНовый год");
                    EnumEvent.FIREWORK.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Большая дыра") && event.getSlot() == 30) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &9Большая дыра");
                    EnumEvent.VOID.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Удачная руда") && event.getSlot() == 32) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &3Удачная руда");
                    EnumEvent.REPLACEORE.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Зрение +3000%") && event.getSlot() == 34) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &2Зрение +3000%");
                    EnumEvent.PUMPKIN.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Далее") && event.getSlot() == 44) {
                    player.openInventory(MenuEventListTwo.instance.inventory);
                    player.playSound(player, Sound.UI_BUTTON_CLICK , 10, 1);
                    event.getInventory().close();
                }
            }
        }
    }

    @EventHandler
    public void onClickMenuTwo(InventoryClickEvent event) {
        if (event.getInventory() == MenuEventListTwo.instance.inventory) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null) {
                String itemname = ((TextComponent) event.getCurrentItem().getItemMeta().displayName()).content();
                Player player = (Player) event.getWhoClicked();

                if (itemname.equals("Бедная кирка") && event.getSlot() == 10) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &9Бедная кирка");
                    EnumEvent.REMOVEITEM.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("На грани") && event.getSlot() == 12) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &cНа грани");
                    EnumEvent.DAMAGE.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Морозная кучка") && event.getSlot() == 14) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &fМорозная кучка");
                    EnumEvent.SNOW.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("''Лучший друг''") && event.getSlot() == 16) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &b''Лучший друг''");
                    EnumEvent.SPIDER.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Магический инвентарь") && event.getSlot() == 28) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &6Магический инвентарь");
                    EnumEvent.MOVEINVENTORY.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Нужно отдохнуть") && event.getSlot() == 30) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &eНужно отдохнуть");
                    EnumEvent.STOPMOVE.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Обернись") && event.getSlot() == 32) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &aОбернись");
                    EnumEvent.FAKECREEPER.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Разрушение всех кроватей") && event.getSlot() == 34) {
                    ColorUril.sendActionBar(player,"&7Вы запустили ивент: &4Разрушение всех кроватей");
                    EnumEvent.BREAKALLBED.getEvent().triggerEffects();
                    event.getInventory().close();
                }

                if (itemname.equals("Назад") && event.getSlot() == 36) {
                    player.openInventory(MenuEventListOne.instance.inventory);
                    player.playSound(player, Sound.UI_BUTTON_CLICK , 10, 1);
                    event.getInventory().close();
                }
            }
        }
    }
}
