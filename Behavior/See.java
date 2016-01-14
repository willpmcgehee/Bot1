package PlayerA1.Behavior;

import PlayerA1.Robot;
import battlecode.common.*;


/**
 * Created by wm2315 on 14/01/16.
 */
public class See {

    private static RobotController rc;
    private static Robot robot;
    private Team opponent;
    public RobotInfo[] seenZombies;
    public RobotInfo[] seenOpponent;
    public RobotInfo[] seenEnemies;
    public RobotInfo[] attackableZombies;
    public RobotInfo[] attackableOpponent;
    public RobotInfo[] attackableEnemies;


    public See(RobotController _rc, Robot _robot){
        rc = _rc;
        robot = _robot;
        opponent = rc.getTeam().opponent();

    }

    public void spotEnemies() throws GameActionException{

        seenZombies = rc.senseNearbyRobots(rc.getType().sensorRadiusSquared,Team.ZOMBIE);
        seenOpponent = rc.senseNearbyRobots(rc.getType().sensorRadiusSquared,opponent);
        seenEnemies = joinRobotInfo(seenZombies,seenOpponent);



    }

    public void targetEnemies() throws GameActionException{
        attackableZombies = rc.senseNearbyRobots(rc.getType().attackRadiusSquared,Team.ZOMBIE);
        attackableOpponent = rc.senseNearbyRobots(rc.getType().attackRadiusSquared,opponent);
        attackableEnemies = joinRobotInfo(attackableZombies,attackableOpponent);


    }

    public MapLocation averageEnemyLoc() throws GameActionException{

        if(seenEnemies.length == 0 || seenEnemies == null){
            return rc.getLocation();
        }else{
            int x = 0;
            int y = 0;
            for(RobotInfo i:robot.see.seenEnemies){
                x+=i.location.x;
                y+=i.location.y;
            }
            Math.round(x/=robot.see.seenEnemies.length);
            Math.round(y/=robot.see.seenEnemies.length);
            return new MapLocation(x,y);
        }


    }




    /*HELPER METHODS*/
    private static RobotInfo[] joinRobotInfo(RobotInfo[] zEnemies, RobotInfo[] oEnemies){

        RobotInfo[] out = new RobotInfo[zEnemies.length + oEnemies.length];
        int i = 0;
        for(RobotInfo j:zEnemies){
            out[i] = j;
            i++;
        }
        for(RobotInfo j:oEnemies){
            out[i] = j;
            i++;
        }
        return out;
    }
}
