package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SpeedrunnerCommand implements CommandExecutor {


    public SpeedrunnerCommand(Main plugin){
        plugin.getCommand("speedrunner").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        ArrayList<String> hunters = HVSManager.getHunters();
        ArrayList<String> speedRunners = HVSManager.getSpeedrunners();

        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can run this command!");
            return true;
        }
        else if(HVSManager.getGameBool()){
            commandSender.sendMessage(ChatColor.RED + "The game is already started!!!");
            return true;
        }
        Player player = (Player) commandSender;

        if(hunters.contains(player.getDisplayName()) || speedRunners.contains(player.getDisplayName())){
            player.sendMessage(ChatColor.RED + "You have already chosen who you are!");
            return true;
        }

        speedRunners.add(player.getDisplayName());
        HVSManager.setSpeedrunners(speedRunners);


        Bukkit.broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " is now a speedrunner!");


        return false;
    }
}
