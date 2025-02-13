package gr.aueb.cf.FiveProjectsv7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Project3 {
    public static void main(String[] args) {
        String filepath = "C:/tmp/project3.txt";
        int [][] charArray=new int [128][2];

        for (int i=0;i<128;i++){
            charArray[i][0]=i;
            charArray[i][1]=0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            int ch;

            while ((ch=reader.read()) !=-1) {
                if (isnotWhitespace(ch) && !Character.isWhitespace(ch)) {
                    charArray[ch][1]++;
                }
            }
            for(int i=0;i<128;i++){
                if (charArray[i][1]>0){
                    System.out.printf("'%c' (%d): %d%n", i, i, charArray[i][1]);
                }
            }

        } catch (IOException e )   {
            System.err.println("error" + e.getMessage());
        }

    }

    public static boolean isnotWhitespace(int ch) {
        return (ch>=65 && ch <=90) || (ch>=97 && ch<=122);
    }

}















