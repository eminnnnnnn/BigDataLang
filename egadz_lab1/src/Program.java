import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int MAX_TASK = 4;
        String[] tasks = new String[] {
            "Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.",
            "Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы и вывода результата на консоль.",
            "Ввести с консоли n целых чисел и поместить их в массив. Вывести на консоль числа, кратные 5 и 7.",
            "Ввести с консоли n целых чисел и поместить их в массив. Вывести на консоль элементы, расположенные методом пузырька по убыванию модулей."
        };

        System.out.println("List of tasks:");
        for (int i = 0; i < MAX_TASK; i++) {
            System.out.printf("\t%d. %s\n", i+1, tasks[i]);
        }

        System.out.print("Number (for exit input 0): ");
        int taskNumber = scanner.nextInt();
        while (taskNumber != 0) {
            switch (taskNumber) {
                case 1:
                    lab1();
                    break;
                case 2:
                    lab2(args);
                    break;
                case 3:
                    lab3();
                    break;
                case 4:
                    lab4();
                    break;
            }
            System.out.println();
            System.out.print("Number (for exit input 0): ");
            taskNumber = scanner.nextInt();
            System.out.println();
        }
        System.out.println("Exit.");
//        lab1();
//        lab2(args);
//        lab3();
//        lab4();
    }

    // Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.
    public static void lab1() {
        String truePasswd = "v3ry_str0ng_p4sswd_y0u_c4nt_h4ck";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input password: ");
        String inPasswd = scanner.next();

        boolean isTruePasswd = inPasswd.equals(truePasswd);
        System.out.println(isTruePasswd ? "Signed in successfully!" : "Wrong password!");
    }

    // Создать программу ввода целых чисел как аргументов командной строки, подсчета их суммы и вывода результата
    // на консоль.
    public static void lab2(String[] args) {
        // filling an array
        ArrayList<Integer> inputNums = new ArrayList<>();
        for (String arg : args) {
            try {
                int argNum = Integer.parseInt(arg);
                inputNums.add(argNum);
            } catch (NumberFormatException e) {
                System.out.printf("%s : The argument \"%s\" isn't numerical!\n", e.getMessage(), arg);
            }
        }

        // count the sum
        int sum = 0;
        for (int num : inputNums) {
            sum += num;
        }
        System.out.printf("The sum of all numbers is %d\n", sum);
    }

    public static ArrayList<Integer> scanIntArray() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputNums = new ArrayList<>();

        System.out.print("Input amount of numbers: ");
        int inputNumsSize = scanner.nextInt();

        System.out.println("Input " + inputNumsSize + " numbers:");
        for (int i = 0; i < inputNumsSize; i++) {
            inputNums.add(scanner.nextInt());
        }

        return inputNums;
    }

    // Ввести с консоли n целых чисел и поместить их в массив. Вывести на консоль числа, кратные 5 и 7.
    public static void lab3() {
        ArrayList<Integer> inputNums = scanIntArray();

        System.out.print("Multiples of 5 and 7: ");
        for (int num : inputNums) {
            if ((num % 5 == 0) && (num % 7 == 0)) {
                System.out.print(num + " ");
            }
        }

        System.out.println();
    }

    // Ввести с консоли n целых чисел и поместить их в массив. Вывести на консоль элементы, расположенные методом
    // пузырька по убыванию модулей.
    public static void lab4() {
        ArrayList<Integer> inputNums = scanIntArray();

        for (int i = 0; i < inputNums.size(); i++) {
            for (int j = 0; j < inputNums.size(); j++) {
                int leftElem = inputNums.get(i);
                int rightElem = inputNums.get(j);
                if (Math.abs(leftElem) > Math.abs(rightElem)) {
                    inputNums.set(j, leftElem);
                    inputNums.set(i, rightElem);
                }
            }
        }

        System.out.print("Sorted array: ");
        for (int num : inputNums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
