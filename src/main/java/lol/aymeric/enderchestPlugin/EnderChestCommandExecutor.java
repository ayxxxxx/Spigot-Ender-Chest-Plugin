package lol.aymeric.enderchestPlugin;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
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

        try {
            Inventory enderChestInventory = player.getEnderChest();
            player.openInventory(enderChestInventory);

            TextComponent successMessage = new TextComponent("Successfully opened Ender Chest, ");
            successMessage.setBold(true);

            TextComponent playerName = new TextComponent(player.getName());

            successMessage.addExtra(playerName);
            player.spigot().sendMessage(successMessage);
            return true;
        } catch (Exception e) {
            TextComponent failureMessage = new TextComponent("Failed to open Ender Chest.");
            failureMessage.setBold(true);
            player.spigot().sendMessage(failureMessage);
            return false;
        }
    }
}
