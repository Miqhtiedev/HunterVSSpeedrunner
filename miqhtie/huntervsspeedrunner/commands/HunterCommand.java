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

public class HunterCommand implements CommandExecutor {

   HVSManager hvsManager;

    public HunterCommand(Main plugin)
    {
        plugin.getCommand("hunter").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> hunters = HVSManager.getHunters();
        ArrayList<String> speedRunners = HVSManager.getSpeedrunners();

        ArrayList<Player> Playerhunters = HVSManager.getPlayerhunters();

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

        Playerhunters.add(player);
        HVSManager.setPlayerhunters(Playerhunters);
        hunters.add(player.getDisplayName());
        HVSManager.setHunters(hunters);
        Bukkit.broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " is now a hunter!");
        return true;
    }

}
