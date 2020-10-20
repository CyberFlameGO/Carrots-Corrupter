package me.mrdev.carrotscorrupter.commands;


import me.mrdev.carrotscorrupter.CarrotsCorrupter;
import me.mrdev.carrotscorrupter.listeners.PlayersListeners;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CCCommand implements CommandExecutor {

    public CCCommand(CarrotsCorrupter plugin) {
        plugin.getCommand("cc").setExecutor(this); // /cc command
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Execute this command as a player!"); //only executable as player, not console/commandblock/whatever
            return false;
        }else {
            Player player = (Player)sender
            player.getInventory().addItem(PlayersListeners.getCarrotCorrupter()); //gives player carrot corrupter
            player.sendMessage(ChatColor.GOLD + "You have received the Carrot Corrupter!"); //notifies player that they've received item.
        }
        return true;
    }
}
