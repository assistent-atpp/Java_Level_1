package GeekBrains.Java.Lessons;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char [][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_0 = '0';
    public static final char DOT_X = 'X';
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        // игровой цикл
        initMap();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Победил человек.");
                break;
            }
            if (isMapFull(DOT_EMPTY)){
                System.out.println("Ничья.");
                break;
            }
            computerTurn();
            printMap();
            if (checkWin(DOT_0)){
                System.out.println("Победил компутер.");
                break;
            }
            if (isMapFull(DOT_EMPTY)){
                System.out.println("Ничья.");
                break;
            }
        }
        System.out.println("Игра закончена.");
    }
    // инициализация карты
    public static void initMap(){
        map = new char [SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                map [i][j] = DOT_EMPTY;
            }
        }
    }
    // вывод карты в консоль
    public static void printMap(){
        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
        System.out.println(); // перенос на строку ниже
        for (int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();   // перенос строк на карте
        }
        System.out.println();   // перенос курсора строкой ниже для разделения полей
    }
    // ход человека
    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    // проверка на правильность ввода координаты на карте
    public static boolean isCellValid (int x, int y){
        if (x < 0 || x > SIZE || y < 0 || y > SIZE){
            return false;
        }
        if (map [y][x] == DOT_EMPTY){
            return true;
        }
        return false;
    }
    // ход компа
    public static void computerTurn(){
        int x, y;
        do{
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компутер сходил в точку " + (x + 1) + " " + (y + 1));
        map [y][x] = DOT_0;
    }
    // метод для проверкиы победы для поля 3 х 3 (подсмотрено в интернете)
//    public static boolean checkWin (char symb){
//        boolean mainDiagonal = true;
//        boolean sideDiagonal = true;
//        boolean columns, lines;
//        for (int i = 0; i < SIZE; i++){
//            mainDiagonal = mainDiagonal & (map [i][i] == symb);         // главная диагональ
//            sideDiagonal = sideDiagonal & (map [i][2- i] == symb);      // побочная диагональ
//            columns = true;
//            lines = true;
//            for (int j = 0; j < SIZE; j++){
//                columns = columns & (map [i][j] == symb);               // столбцы
//                lines = lines & (map [j][i] == symb);                   // строки
//            }
//            if (columns || lines) return true;
//        }
//        if (mainDiagonal || sideDiagonal) return true;
//        return false;
//    }

    // метод для проверкиы победы для поля 3 х 3
    public static boolean checkWin (char symb){
        int mainDiagonalCounter = 0;
        int sideDiagonalCounter = 0;
        int horizontalCounter = 0;
        int verticalCounter = 0;
        for (int i = 0; i < SIZE; i++){
            if (map [i][i] == symb){
                mainDiagonalCounter++;
            } else {
                mainDiagonalCounter = 0;
            }
            if (map [i][SIZE - 1 - i] == symb){
                sideDiagonalCounter++;
            } else {
                sideDiagonalCounter = 0;
            }
            for (int j = 0; j < SIZE; j++){
                if (map [i][j] == symb){
                    horizontalCounter++;
                } else {
                    horizontalCounter = 0;
                }
                if (map [j][i] == symb){
                    verticalCounter++;
                } else {
                    verticalCounter = 0;
                }
            }
            if (horizontalCounter == SIZE || verticalCounter == SIZE){
                return true;
            }
        }
        if (mainDiagonalCounter == SIZE || sideDiagonalCounter == SIZE){
            return true;
        }
        return false;
    }

    // проверка заполненности карты
    public static boolean isMapFull (char DOT_EMPTY){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (map [i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
}
