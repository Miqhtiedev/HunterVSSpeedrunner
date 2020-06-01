package miqhtie.huntervsspeedrunner;

import miqhtie.huntervsspeedrunner.commands.*;
import miqhtie.huntervsspeedrunner.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private final JavaPlugin plugin = this;

    @Override
    public void onEnable(){

        HVSManager hvsManager = new HVSManager();

        System.out.println("-------------------------");
        System.out.println("HUNTER VS SPEEDRUNNER ENABLED");
        System.out.println("-------------------------");


        new ListPeopleCommand(this);
        new HunterCommand(this);
        new SpeedrunnerCommand(this);
        new StartCommand(this);
        new TeamatesCommand(this);

        new MoveListener(this);
        new DeathListener(this);
        new TrackCommand(this);
        new DamageListener(this);

        Tick tick = new Tick(this);
        tick.runTaskTimer(plugin, 0, 1);
    }

    @Override
    public void onDisable(){
        System.out.println("-------------------------");
        System.out.println("HUNTER VS SPEEDRUNNER DISABLED");
        System.out.println("-------------------------");
    }



}
