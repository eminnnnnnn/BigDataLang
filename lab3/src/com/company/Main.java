package com.company;

import com.company.lab31.Lab31;
import com.company.lab32.Lab32;
import com.company.lab33.Lab33;
import com.company.lab34.Lab34;
import com.company.lab35.Lab35;
import com.company.lab36.Lab36;
import com.company.lab37.Lab37;
import com.company.lab38.Lab38;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int labNum = scanner.nextInt();
        switch (labNum) {
            case 1:
                Lab31.lab_1();
                break;
            case 2:
                Lab32.lab_2();
                break;
            case 3:
                Lab33.lab_3();
                break;
            case 4:
                Lab34.lab_4();
                break;
            case 5:
                Lab35.lab_5();
                break;
            case 6:
                Lab36.lab_6();
                break;
            case 7:
                Lab37.lab_7();
                break;
            case 8:
                Lab38.lab_8();
                break;
            default:
                break;
        }
    }

}