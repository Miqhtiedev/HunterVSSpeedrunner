package miqhtie.huntervsspeedrunner;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class HVSManager {



    private static boolean gameActive;
    private static boolean hunterCanMove = true;
    private static boolean onePunchMan;

    private static long timeStartedMilis;

    private static ArrayList<String> hunters = new ArrayList<String>();
    private static ArrayList<String> speedrunners = new ArrayList<String>();

    private static ArrayList<Player> Playerhunters = new ArrayList<Player>();
    /*
    Getters
     */
    public static boolean getGameBool(){
        return gameActive;
    }
    public static boolean getOnePunchMan(){return onePunchMan;}
    public static ArrayList<String> getHunters(){
        return hunters;
    }
    public static ArrayList<String> getSpeedrunners(){
        return speedrunners;
    }
    public static ArrayList<Player> getPlayerhunters(){
        return Playerhunters;
    }
    public static boolean getHunterCanMove(){
        return hunterCanMove;
    }
    public static long getTimeStartedMilis(){
        return timeStartedMilis;
    }

    /*
    Setters
     */

    public static void setGameBool(Boolean bool){
        gameActive = bool;
    }
    public static void setOnePunchMan(Boolean bool){onePunchMan = bool;}
    public static void setHunters(ArrayList<String> list){
        hunters = list;
    }
    public static void setTimeStartedMilis(long time){timeStartedMilis = time;}
    public static void setSpeedrunners(ArrayList<String> list){
        speedrunners = list;
    }
    public static void setPlayerhunters(ArrayList<Player> list){
        Playerhunters = list;
    }
    public static void setHunterCanMove(boolean bool){
        hunterCanMove = bool;
    }


    /*
    Reset
     */

    public static void reset(World world){
        gameActive = false;
        hunterCanMove = true;
        onePunchMan = false;

        timeStartedMilis = 0;

        hunters.clear();
        speedrunners.clear();
        Playerhunters.clear();

        Tick.reset();

        world.getWorldBorder().reset();
    }

}
