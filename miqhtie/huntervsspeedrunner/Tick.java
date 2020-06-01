package miqhtie.huntervsspeedrunner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Tick extends BukkitRunnable {

    private int ticks = 0;
    private int seconds = 0;
    private int minutes = 0;

    private boolean done = false;

    Main plugin;
    public Tick(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(HVSManager.getGameBool()){

            if(System.currentTimeMillis() - HVSManager.getTimeStartedMilis() >= 60000){
                if(!done){
                    HVSManager.setHunterCanMove(true);

                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.sendTitle(ChatColor.RED + "HUNTERS!", ChatColor.DARK_RED + "HAVE BEEN RELEASED.", 1, 20, 1);
                    }
                    done = true;
                }

            }

        }

    }
}
