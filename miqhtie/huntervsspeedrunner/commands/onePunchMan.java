package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class onePunchMan implements CommandExecutor {

    public onePunchMan(Main plugin){
        plugin.getCommand("onepunch").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(HVSManager.getGameBool()){
            commandSender.sendMessage(ChatColor.RED + "Game already active!");
        }
        if(HVSManager.getOnePunchMan()){
            HVSManager.setOnePunchMan(false);
            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle(ChatColor.RED + "ONE PUNCH MAN!", ChatColor.DARK_RED + "DEACTIVATED.", 1, 20, 1);
            }
        }
        else{
            HVSManager.setOnePunchMan(true);
            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle(ChatColor.RED + "ONE PUNCH MAN", ChatColor.DARK_RED + "ACTIVATED.", 1, 20, 1);
            }
        }

        return true;
    }
}
