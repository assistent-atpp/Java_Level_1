package GeekBrains.Java.Lessons.HomeWorkLesson1;

import java.io.Console;
import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
        // задание 2
        byte byteVal = 127;
        short shortVal = -32768;
        int intVal = 2147483647;
        long longVal = 1000000L;
        float floatVal = 5.12f;
        double doubleVal = -3.3453;
        boolean booleanVal = true;
        // по заданию 3
        System.out.println(floatCalculation(1.45f, 4.63f, 33.64f, 2.25f));
        // по заданию 4
        System.out.println(checkSumm(0,10));
        // по заданию 5
        signNumberConsole(-4);
        // по заданию 6
        System.out.println(signNumberReturn(5));
        // по заданию 7
        stringName("Василий");
        // по заданию 8
        defineLeapYear(2000);
    }
    // задание 3
    public static float floatCalculation(float a, float b, float c, float d){
        return a * (b + (c/d));
    }
    // задание 4
    public static boolean checkSumm (int numberOne, int numberTwo){
        if (numberOne + numberTwo >= 10 && numberOne + numberTwo <= 20){
            return true;
        } else {
            return false;
        }
    }
    // задание 5
    public static void signNumberConsole (int number){
        if (number >= 0){
            System.out.println("число положительное");
        } else{
            System.out.println("число отрицательное");
        }
    }
    // задание 6
    public static boolean signNumberReturn (int number){
        if (number < 0){
            return true;
        } else {
            return false;
        }
    }
    // задание 7
    public static void stringName (String name){
        System.out.println("Привет, " + name + "!");
    }
    // задание 8
    public static void defineLeapYear (int numberYear){
        if (numberYear % 4 == 0 && numberYear % 400 == 0){
            System.out.println("Этот год високосный");
        }
        if (numberYear % 400 != 0 && numberYear % 100 == 0){
            System.out.println("Этот год невисокосный");
        }
    }
}
