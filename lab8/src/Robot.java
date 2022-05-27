public class Robot {
    enum LEGS {
        LEFT,
        RIGHT
    };
    public Robot() {}

    public void goLeft() {
        System.out.println("LEFT {Thread #" + Thread.currentThread().getId() + "}");
    }

    public void goRight() {
        System.out.println("RIGHT {Thread #" + Thread.currentThread().getId() + "}");
    }
}
