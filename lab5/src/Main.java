import Lab51.Lab51;
import Lab52.Lab52;
import Lab53.Lab53;
import Lab54.Lab54;
import Lab55.Lab55;
import Lab56.Lab56;
import Lab57.Lab57;
import Lab58.Lab58;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int labNum = scanner.nextInt();
        switch (labNum) {
            case 1:
                Lab51.lab5_1();
                break;
            case 2:
                Lab52.lab5_2();
                break;
            case 3:
                Lab53.lab5_3();
                break;
            case 4:
                Lab54.lab5_4();
                break;
            case 5:
                Lab55.lab5_5();
                break;
            case 6:
                Lab56.lab5_6();
                break;
            case 7:
                Lab57.lab5_7();
                break;
            case 8:
                Lab58.lab5_8();
                break;
            default:
                break;
        }
    }

}