package PlayerA1;

import PlayerA1.Units.Archon;
import PlayerA1.Units.Soldier;
import PlayerA1.Units.Turret;
import battlecode.common.*;

public class RobotPlayer {

    static RobotController rc;
    private static Robot robot;

    public static void run(RobotController _rc) {

        rc = _rc;

        try{

            //Assign Robot

            switch (rc.getType()){
                case ARCHON: robot = new Archon(rc);
                    break;
                case SOLDIER: robot = new Soldier(rc);
                    break;
                case TURRET: robot = new Turret(rc);
                    break;
                default:
                    throw new GameActionException(GameActionExceptionType.CANT_DO_THAT,
                            "Can't identify robot");
            }

            while(true){
                robot.turn();
                Clock.yield();


            }

        }catch (GameActionException e){
            e.printStackTrace();
        }

    }
}
