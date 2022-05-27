/*
    Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет
    ходить. За движение каждой его ноги отвечает отдельный поток. Шаг выражается в
    выводе в консоль LEFT или RIGHT.
*/

public class Lab82 {
    public static void main(String[] args) {
        Robot robot = new Robot();

//        Thread controller1 = new RobotController(robot, "goLeft; goLeft; goRight; goLeft");
//        Thread controller2 = new RobotController(robot, "goRight; goLeft; goLeft");
//        Thread controller3 = new RobotController(robot, "goRight; goRight; goRight");

        Thread controller1 = new RobotController(robot, Robot.LEGS.LEFT, 15);
        Thread controller2 = new RobotController(robot, Robot.LEGS.RIGHT, 18);

        controller1.start();
        controller2.start();
    }
}
