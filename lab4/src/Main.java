import Lab41.Lab41;
import Lab42.Lab42;
import Lab43.Lab43;
import Lab44.Lab44;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int labNum = scanner.nextInt();
        switch (labNum) {
            case 1:
                Lab41.lab4_1();
                break;
            case 2:
                Lab42.lab4_2();
                break;
            case 3:
                Lab43.lab4_3();
                break;
            case 4:
                Lab44.lab4_4();
                break;
            default:
                break;
        }
    }
}