package com.amazon;

import com.amazon.event.*;
import com.amazon.event.Void;

import java.util.Random;

public enum EnumEvent {
    DIRT(new Dirt()),
    LAVA(new Lava()),
    DAMAGE(new Damage()),
    BOOM(new Boom()),
    MOVEITEM(new MoveItem()),
    MOVEINVENTORY(new MoveInventory()),
    STOPMOVE(new StopMove()),
    PUMPKIN(new Pumpkin()),
    SPIDER(new Spider()),
    SNOW(new Snow()),
    BEDBREAK(new BedBreak()),
    REMOVEITEM(new RemoveItem()),
    VOID(new Void()),
    REPLACEORE(new ReplaceOre()),
    SPIN(new Spin()),
    FIREWORK(new firework()),
    FAKECREEPER(new fakecreeper()),
    BREAKALLBED(new BreakAllBed());

    private final Event event;

    EnumEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }

    public static EnumEvent getRandomEvent() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
