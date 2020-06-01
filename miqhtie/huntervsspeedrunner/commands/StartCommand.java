package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import miqhtie.huntervsspeedrunner.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    public StartCommand(Main plugin){
        plugin.getCommand("start").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "Only players can run this command!");
            return true;
        }

        if(HVSManager.getGameBool()){
            commandSender.sendMessage(ChatColor.RED + "Game already active");
            return true;
        }

        if(HVSManager.getHunters().size() == 0 || HVSManager.getSpeedrunners().size() == 0){
            commandSender.sendMessage(ChatColor.RED + "There is not enough hunter and(or) speedrunners");
            return true;
        }

        Player player = (Player) commandSender;

        Utils.createWorldBorder(player, (double) 1000);
        HVSManager.setGameBool(true);

        for(Player p : HVSManager.getPlayerhunters()){
            p.teleport(p.getWorld().getSpawnLocation());
        }

        HVSManager.setHunterCanMove(false);
        HVSManager.setTimeStartedMilis(System.currentTimeMillis());

        Bukkit.broadcastMessage(ChatColor.GREEN + "The HVS game has started!");

        Bukkit.dispatchCommand(commandSender, "advancement revoke @a everything");

        return true;
    }
}
