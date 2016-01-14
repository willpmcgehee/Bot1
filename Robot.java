package PlayerA1;

import PlayerA1.Behavior.*;
import java.util.Random;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

/**
 * Created by wm2315 on 14/01/16.
 */
public abstract class Robot {

    public Random rand;
    protected static RobotController rc;
    public static Nav nav;
    public static See see;
    public static Fight fight;
    public MapLocation targetMoveLoc;
    public MapLocation targetShootLoc;

    public abstract void turn() throws GameActionException;


}
