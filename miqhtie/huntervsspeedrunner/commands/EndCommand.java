package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EndCommand implements CommandExecutor {
    public EndCommand(Main plugin){
        plugin.getCommand("end").setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("Only players can run these commands!");
            return true;
        }
        if(!commandSender.hasPermission("hvs.end")){
            commandSender.sendMessage("You do not have permission to execute this command");
            return true;
        }
        if(!HVSManager.getGameBool()){
            commandSender.sendMessage("There is no game active right now.");
            return true;
        }

        HVSManager.reset(((Player) commandSender).getWorld());
        return false;
    }
}
