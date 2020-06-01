package miqhtie.huntervsspeedrunner.listeners;

import miqhtie.huntervsspeedrunner.HVSManager;
import miqhtie.huntervsspeedrunner.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    public MoveListener(Main plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void MoveEvent(PlayerMoveEvent event){

        if(HVSManager.getSpeedrunners().contains(event.getPlayer().getDisplayName())){
            return;
        }

        else if(HVSManager.getGameBool() && !(HVSManager.getHunterCanMove())){
            event.setCancelled(true);
        }
    }

}
