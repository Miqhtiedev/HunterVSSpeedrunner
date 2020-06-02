package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class QuitTeamCommand implements CommandExecutor {

    public QuitTeamCommand(Main plugin){
        plugin.getCommand("quitteam").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "Only players can run the command!");
            return true;
        }

        Player player = (Player) commandSender;
        if(HVSManager.getSpeedrunners().contains(player.getDisplayName())){
            ArrayList<String> al = HVSManager.getSpeedrunners();
            al.remove(player.getDisplayName());
            HVSManager.setSpeedrunners(al);
            player.sendMessage(ChatColor.GREEN + "You are no longer a speedrunner! Do " + ChatColor.YELLOW + "/hunter" + ChatColor.GREEN + " to become a hunter");
        }
        else if(HVSManager.getHunters().contains(player.getDisplayName())){
            ArrayList<String> al = HVSManager.getHunters();
            ArrayList<Player> al2 = HVSManager.getPlayerhunters();

            al.remove(player.getDisplayName());
            al.remove(player);

            player.sendMessage(ChatColor.GREEN + "You are no longer a hunter! Do " + ChatColor.YELLOW + "/speedrunner" + ChatColor.GREEN + " to become a speedrunner");
        }
        else{
            player.sendMessage(ChatColor.RED + "You are not a hunter OR speed runner");
        }


        return false;
    }
}
