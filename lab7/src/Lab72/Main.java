package Lab72;

import java.util.Scanner;

/*
    В тексте после k-го символа вставить заданную подстроку.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходный текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите подстроку, которую нужно вставить: ");
        String substr = scanner.nextLine();

        System.out.print("Введите номер k символа, после которого вставить подстроку: ");
        int kNum = Integer.parseInt(scanner.nextLine());

        String replacedText = text.replaceFirst("^.{"+kNum+"}", "$0" + substr);

        System.out.println(replacedText);
    }
}