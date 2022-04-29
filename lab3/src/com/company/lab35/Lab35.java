package com.company.lab35;

public class Lab35 {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    lab_5
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Создать приложение, удовлетворяющее требованиям, приведенным в задании. Аргументировать
    принадлежность классу каждого создаваемого метода и корректно переопределить для каждого
    класса методы equals(), hashCode(), toString().

    Создать объект класса Простая дробь, используя класс Число. Методы: вывод на экран,
    сложение, вычитание, умножение, деление.
     */
    public static void lab_5() {
        Fraction fractionA = new Fraction(3, 4);
        Fraction fractionB = new Fraction(5, 8);
        System.out.println(fractionA + " + " + fractionB + " = " + fractionA.sum(fractionB));
        System.out.println(fractionA + " - " + fractionB + " = " + fractionA.sub(fractionB));
        System.out.println(fractionA + " * " + fractionB + " = " + fractionA.mul(fractionB));
        System.out.println(fractionA + " / " + fractionB + " = " + fractionA.div(fractionB));
    }

}
