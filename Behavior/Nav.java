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

        public void moveEast() throws GameActionException {

            if(rc.canMove(Direction.EAST)){
                rc.move(Direction.EAST);
            }

        }

        public void moveWest() throws GameActionException {

            if(rc.canMove(Direction.WEST)){
                rc.move(Direction.WEST);
            }

        }

        public void moveNorth() throws GameActionException {

            if(rc.canMove(Direction.NORTH)){
                rc.move(Direction.NORTH);
            }

        }

        public void moveSouth() throws GameActionException {

            if(rc.canMove(Direction.SOUTH)){
                rc.move(Direction.SOUTH);
            }

        }

        public void moveNorthEast() throws GameActionException {

            if(rc.canMove(Direction.NORTH_EAST)){
                rc.move(Direction.NORTH_EAST);
            }

        }

        public void moveNorthWest() throws GameActionException {

            if(rc.canMove(Direction.NORTH_WEST)){
                rc.move(Direction.NORTH_WEST);
            }

        }

        public void moveSouthEast() throws GameActionException {

            if(rc.canMove(Direction.SOUTH_EAST)){
                rc.move(Direction.SOUTH_EAST);
            }

        }

        public void moveSouthWest() throws GameActionException {

            if(rc.canMove(Direction.SOUTH_WEST)){
                rc.move(Direction.SOUTH_WEST);
            }

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
