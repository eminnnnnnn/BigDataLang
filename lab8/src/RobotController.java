public class RobotController extends Thread {
    private final Robot robot;
    private final Robot.LEGS leg;
    private int stepCount;

    public RobotController(Robot robot, Robot.LEGS leg, int stepCount) {
        this.robot = robot;
        this.leg = leg;
        this.stepCount = stepCount;
    }

    @Override
    public void run() {
//        synchronized (robot) {
            while (stepCount > 0) {
                switch (leg) {
                    case LEFT:
                        robot.goLeft();
                        break;
                    case RIGHT:
                        robot.goRight();
                        break;
                }
                stepCount--;
            }
//        }
    }
//    private final String algorithm;
//
//    public RobotController(Robot robot, String algorithm) {
//        this.robot = robot;
//        this.algorithm = algorithm;
//    }
//
//    @Override
//    public void run() {
//        String[] insns = algorithm.split("[;]\\s?");
//        synchronized (robot) {
//            for (String i : insns) {
//                if (i.equals("goLeft")) {
//                    robot.goLeft();
//                } else if (i.equals("goRight")) {
//                    robot.goRight();
//                }
//            }
//        }
//    }
}
