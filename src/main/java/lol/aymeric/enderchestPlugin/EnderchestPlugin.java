package lol.aymeric.enderchestPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class EnderchestPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("EnderChestPlugin has been enabled");

        this.getCommand("ec").setExecutor(new EnderChestCommandExecutor(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("The EnderChestPlugin has been disabled");
    }
}
