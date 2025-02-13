package gr.aueb.cf.FiveProjectsv7;



import java.util.Scanner;


public class Project4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][]table=new int [3][3];
        int currentplayer=1;

        while(true){
            printTable(table);
            System.out.println("player" + currentplayer + "go");
            System.out.println("give row 0<num>2");
            int row = scanner.nextInt();
            System.out.println("give col 0<num>2");
            int col = scanner.nextInt();
            if (row<0 ||row>2 || col<0||col>2){
                System.out.println("try again");
            continue;
            }
            if (table[row][col]!=0){
                System.out.println("give other position");
                continue;
            }
            table[row][col]=currentplayer;

            if (wins(table,currentplayer)) {
                printTable(table);
                System.out.println("player" + currentplayer + "wins");
                break;

            } else if (draw(table)){
                printTable(table);
                System.out.println("draw");
                break;
            }
            currentplayer=(currentplayer==1)?2:1;


        }


    }//psvm

    public static void printTable(int[][]table){
        System.out.println();
        System.out.println("A B C");
        for (int[] row:table){
            for (int el :row){
                System.out.print((el==0?"_":el) + " ");
            }
            System.out.println();
        }
    }

    public static boolean wins(int [][]table,int player) {
        for (int i=0;i<3;i++) {
            if ((table[i][0]==player && table[i][1]==player && table[i][2]==player ||
                    table[0][i]==player && table[1][i]==player && table[2][i]==player)){
                return true;
            }

        }

        if ((table[0][0]==player && table[1][1]==player && table[2][2]==player)||
                (table[0][2]==player && table[1][1]==player &&table[2][0]==player)) {
            return true;
        }
        return false;
    }

    public static boolean draw(int[][] table) {
        for (int []row:table) {
            for (int el:row){
                if(el==0){
                    return false;
                }
            }
        }
        return true;
    }


}//-