package me.hrdu_.hovercard.hovercard;

import me.hrdu_.hovercard.hovercard.heal.Heal;
import org.bukkit.plugin.java.JavaPlugin;

public final class HoverCard extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("Doctor").setExecutor(new Heal());
    }

    @Override
    public void onDisable() {

    }

}


