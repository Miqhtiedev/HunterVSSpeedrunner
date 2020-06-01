package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrackCommand implements CommandExecutor {

    public TrackCommand(Main plugin){
        plugin.getCommand("track").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can run this command!");
            return true;
        }

        if(!(HVSManager.getGameBool())){
          commandSender.sendMessage("There is no game started right now!");
          return true;
        }


        if(!HVSManager.getHunters().contains(((Player) commandSender).getDisplayName())){
            commandSender.sendMessage("You are not a hunter!");
            return true;
        }

        commandSender.sendMessage("Location of speed runners---");
        for(String string : HVSManager.getSpeedrunners()){
            for(Player p : Bukkit.getOnlinePlayers()){
                if(p.getDisplayName().equalsIgnoreCase(string)){
                    Location playerLocation = p.getLocation();
                    commandSender.sendMessage(string + "'s location: X:" + playerLocation.getBlockX() + " Z:" + playerLocation.getBlockZ());
                }
            }
        }



        return true;
    }
}
