package PlayerA1.Units;

import PlayerA1.Behavior.Fight;
import PlayerA1.Behavior.Nav;
import PlayerA1.Behavior.See;
import PlayerA1.*;
import battlecode.common.*;

import java.util.Random;

/**
 * Created by wm2315 on 14/01/16.
 */
public class Soldier extends Robot{

    public Soldier(RobotController _rc){
        rc = _rc;
        nav = new Nav(rc,this);
        see = new See(rc,this);
        fight = new Fight(rc,this);
        rand = new Random(rc.getID());

    }

    public void turn() throws GameActionException{
        see.spotEnemies();
        see.targetEnemies();
        fight.fight();
        nav.flee();

    }

}
