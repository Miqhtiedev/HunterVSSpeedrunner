package miqhtie.huntervsspeedrunner.listeners;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener{
    public DamageListener(Main plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            if(HVSManager.getHunters().contains(((Player) event.getEntity()).getDisplayName()) && HVSManager.getHunters().contains(((Player) event.getDamager()).getDisplayName())){
                event.setCancelled(true);
            }
            if(HVSManager.getSpeedrunners().contains(((Player) event.getEntity()).getDisplayName()) && HVSManager.getSpeedrunners().contains(((Player) event.getDamager()).getDisplayName())){
                event.setCancelled(true);
            }
        }
    }
}
