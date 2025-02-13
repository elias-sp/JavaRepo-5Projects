package gr.aueb.cf.FiveProjectsv7;

import java.util.Scanner;


public class Project5 {
    static Scanner scanner = new Scanner(System.in);
    static boolean[][] theatre = new boolean[30][12];

    public static void main(String[] args) {
        int choice = 0;
        char column = ' ';
        int row = 0;
       do {
            printMenu();
            choice = getOneInt();
            doOnChoice(choice,column, row);
        }
        while (ischoiceValid(choice) == true);
    }

    public static void printMenu() {
        System.out.println("Insert 1-3 for choice");
        System.out.println("1. book seat");
        System.out.println("2. cancel seat");
        System.out.println("3. print seats");
        System.out.println("4. exit");
    }

    public static boolean ischoiceValid(int choice) {
        return choice >= 1 && choice <= 4;
    }

    public static int getOneInt() {
        return scanner.nextInt();
    }

    public static void doOnChoice(int choice, char column, int row) {

        switch (choice) {
            case 1:
                book(column, row);

                break;
            case 2:
                cancel(column, row);
                break;
            case 3:
                printArray(theatre);
                break;
            case 4:
                System.out.println("quitting...");
                break;
            default:
                System.out.println("error in choice");
                break;
        }
    }

    public static void book(char column, int row) {

        System.out.println("Give column A-L");
        int columnValue=getOneChar();
        System.out.println("Give row 1-30");
        row = getOneInt()-1;
        if (theatre[row][columnValue]==false) {
        theatre[row][columnValue]=true;
            System.out.println("seat booked");
        } else
            System.out.println("seat is booked already");
    }

    public static int getOneChar() {
            char column = scanner.next().charAt(0);
            int columnValue = Character.getNumericValue(column);
            return columnValue - 10;
    }

    private static void cancel(char column, int row) {
        System.out.println("Give column A-L to cancel");
        int columnValue=getOneChar();
        System.out.println("Give row 1-30 to cancel");
        row = getOneInt()-1;
        if (theatre[row][columnValue]==true) {
            theatre[row][columnValue]=false;
            System.out.println("seat canceled");
        } else System.out.println("seat not found booked");
    }

    public static void printArray(boolean theatre[][]) {

        for (boolean [] row : theatre) {
            for (boolean el : row){
                System.out.print(el==false? "empty " : "BOOKED ");
            }
            System.out.println();
        }

    }

}
