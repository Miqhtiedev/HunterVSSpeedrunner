package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
public class TeamatesCommand implements CommandExecutor {

    public TeamatesCommand(Main plugin) {
        plugin.getCommand("teamates").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can run this command!");
            return true;
        }

        if (!(HVSManager.getGameBool())) {
            commandSender.sendMessage(ChatColor.RED + "There is no HVS game going on at the moment!");
            return true;
        }

        Player player = (Player) commandSender;

        if (HVSManager.getSpeedrunners().contains(player.getDisplayName())) {
            player.sendMessage(ChatColor.AQUA + "Speedrunner's Locations---");
            for (String string : HVSManager.getSpeedrunners()) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getDisplayName().equalsIgnoreCase(string)) {
                        Location playerLocation = p.getLocation();
                        commandSender.sendMessage(ChatColor.GREEN + string + "'s location: X:" + playerLocation.getBlockX() + " Z:" + playerLocation.getBlockZ());
                    }
                }
            }


        } else if (HVSManager.getHunters().contains(player.getDisplayName())) {
            player.sendMessage(ChatColor.RED + "Hunters's Locations---");
            for (String string : HVSManager.getHunters()) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getDisplayName().equalsIgnoreCase(string)) {
                        Location playerLocation = p.getLocation();
                        commandSender.sendMessage(ChatColor.DARK_RED + string + "'s location: X:" + playerLocation.getBlockX() + " Z:" + playerLocation.getBlockZ());
                    }
                }
            }

        }
        return true;
    }
}