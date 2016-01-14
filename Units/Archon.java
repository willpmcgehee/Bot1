package PlayerA1.Units;

import PlayerA1.Behavior.*;
import battlecode.common.*;
import PlayerA1.*;
import battlecode.instrumenter.inject.System;

import java.util.Random;

/**
 * Created by wm2315 on 14/01/16.
 */
public class Archon extends Robot{

    public Archon(RobotController _rc){
        rc = _rc;
        nav = new Nav(rc,this);
        see = new See(rc,this);
        rand = new Random(rc.getID());

    }

    public void turn() throws GameActionException{


        see.spotEnemies();
        spawn(RobotType.SOLDIER);
        if(see.seenEnemies.length == 0){
            nav.moveRandom();
        }else {
            nav.flee();
        }



    }

    public boolean spawn(RobotType robotType)throws GameActionException{
        if(rc.isCoreReady() && rc.hasBuildRequirements(robotType))
        {
            int i = 0;
            do{
                Direction buildDir = Direction.values()[rand.nextInt(8)];
                if(rc.canBuild(buildDir, robotType)){
                    rc.build(buildDir, robotType);
                    return true;
                }
                i++;
            }while(i > 3);
        }
        return false;
    }

}
