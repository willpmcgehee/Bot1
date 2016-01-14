package PlayerA1.Units;

import PlayerA1.Behavior.Fight;
import PlayerA1.Behavior.Nav;
import PlayerA1.Behavior.See;
import PlayerA1.Robot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

import java.util.Random;

/**
 * Created by wm2315 on 14/01/16.
 */
public class Turret extends Robot{

    public Turret(RobotController _rc){
        rc = _rc;
        nav = new Nav(rc,this);
        see = new See(rc,this);
        fight = new Fight(rc,this);
        rand = new Random(rc.getID());

    }

    public void turn()throws GameActionException{
        see.targetEnemies();
        fight.fight();
    }

}
