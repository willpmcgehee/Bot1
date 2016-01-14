    package PlayerA1.Behavior;

    import PlayerA1.Robot;
    import battlecode.common.*;
    import battlecode.instrumenter.inject.System;
    import battlecode.server.Match;
    import com.thoughtworks.xstream.mapper.Mapper;

    /**
     * Created by wm2315 on 14/01/16.
     */
    public class Nav {

        private static RobotController rc;
        private static Robot robot;

        public Nav(RobotController _rc, Robot _robot){
            rc = _rc;
            robot = _robot;

        }

        public void flee() throws GameActionException {
            if(rc.isCoreReady()){
                if(robot.see.seenEnemies != null && robot.see.seenEnemies.length > 0){
                    robot.targetMoveLoc = robot.see.averageEnemyLoc();
                    robot.targetMoveLoc = new MapLocation((2 * rc.getLocation().x) - robot.targetMoveLoc.x, (2 * rc.getLocation().y) - robot.targetMoveLoc.y);
                    moveToTargetLoc();
                }
            }
        }

        public void moveRandom() throws GameActionException {
            if(rc.isCoreReady()){
                Direction moveDirection = Direction.values()[robot.rand.nextInt(8)];
                if (rc.canMove(moveDirection)) {
                    rc.move(moveDirection);
                }
            }

        }


        public void moveToTargetLoc() throws GameActionException{

                if(robot.targetMoveLoc != null){
                    Direction moveDirection = rc.getLocation().directionTo(robot.targetMoveLoc);
                    if(rc.canMove(moveDirection)){
                        rc.move(moveDirection);
                    }else{
                        moveRandom();
                    }
                }


        }




    }
