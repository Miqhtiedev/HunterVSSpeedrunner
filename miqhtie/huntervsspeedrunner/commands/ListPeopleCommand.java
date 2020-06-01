package miqhtie.huntervsspeedrunner.commands;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class ListPeopleCommand implements CommandExecutor {



    public ListPeopleCommand(Main plugin){
        plugin.getCommand("listpeople").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> hunters = HVSManager.getHunters();
        ArrayList<String> speedRunners = HVSManager.getSpeedrunners();

        if(hunters.size() != 0){
            commandSender.sendMessage("---HUNTERS---");
            for(String x : hunters){
                commandSender.sendMessage(x);
            }
        }
        if(speedRunners.size() != 0){
            commandSender.sendMessage("---SPEEDRUNNERS---");
            for(String x : speedRunners){
                commandSender.sendMessage(x);
            }
        }


        return true;
    }

}
