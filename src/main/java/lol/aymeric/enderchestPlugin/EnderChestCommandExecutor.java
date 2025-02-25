package lol.aymeric.enderchestPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderChestCommandExecutor implements CommandExecutor {
    private final EnderchestPlugin plugin;

    public EnderChestCommandExecutor(EnderchestPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        Inventory enderChestInventory = player.getEnderChest();
        player.openInventory(enderChestInventory);
        return true;
    }
}
