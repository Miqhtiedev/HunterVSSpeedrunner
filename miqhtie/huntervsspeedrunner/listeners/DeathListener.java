package miqhtie.huntervsspeedrunner.listeners;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

public class DeathListener implements Listener {
    private Main plugin;
    public DeathListener(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void DeathListener(PlayerDeathEvent event){
        if(HVSManager.getSpeedrunners().contains(event.getEntity().getDisplayName())){
            event.getEntity().setGameMode(GameMode.SPECTATOR);

            ArrayList<Player> Playerhunters = HVSManager.getPlayerhunters();
            ArrayList<String> Speedrunners = HVSManager.getSpeedrunners();

            Speedrunners.remove(event.getEntity().getDisplayName());
            HVSManager.setSpeedrunners(Speedrunners);
//            event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
            Bukkit.broadcastMessage(ChatColor.RED + event.getEntity().getDisplayName() + " HAS BEEN MURDERED!");

            if(HVSManager.getSpeedrunners().size() == 0){
                Bukkit.broadcastMessage(ChatColor.GREEN + "HUNTERS WIN! Disabling plugin!");
                Bukkit.getPluginManager().disablePlugin(plugin);
            }
        }
    }
}
