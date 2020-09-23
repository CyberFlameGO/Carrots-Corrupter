package me.mrdev.carrotscorrupter;

import me.mrdev.carrotscorrupter.commands.CCCommand;
import me.mrdev.carrotscorrupter.listeners.PlayersListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class CarrotsCorrupter extends JavaPlugin {

    @Override
    public void onEnable() {
        new PlayersListeners(this);
        new CCCommand(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
