package PlayerA1.Behavior;

import PlayerA1.Robot;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.Team;

/**
 * Created by wm2315 on 14/01/16.
 */
public class Fight {

    private static RobotController rc;
    private static Robot robot;
    private Team opponent;

    public Fight(RobotController _rc, Robot _robot) {
        rc = _rc;
        robot = _robot;
        opponent = rc.getTeam().opponent();
    }

    public boolean fight() throws GameActionException{
        if(robot.see.attackableEnemies.length > 0){
            if(rc.isWeaponReady() && rc.isCoreReady()){
                double minHealth = 999999;
                RobotInfo target = null;
                for(RobotInfo i: robot.see.attackableEnemies){
                    if(i.health < minHealth){
                        minHealth = i.health;
                        target = i;
                    }
                }
                robot.targetShootLoc = target.location;
                if(rc.canAttackLocation(robot.targetShootLoc)){
                    rc.attackLocation(robot.targetShootLoc);
                    return true;
                }
            }
        }
        return false;
    }


}
