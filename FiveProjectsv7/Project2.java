package gr.aueb.cf.FiveProjectsv7;


import java.util.Arrays;

public class Project2 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = maxSumSubarray(arr);
        System.out.println("max subbarray sum :" + result[0]);
        for (int i = result[1]; i<=result[2]; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] maxSumSubarray(int[]arr) {
        int maxSum=Integer.MIN_VALUE;
        int tempSum=0;
        int start=0;
        int tempstart=0;
        int end=0;
        for (int i =0; i< arr.length; i++) {
            tempSum=tempSum+arr[i];
            if (tempSum>maxSum) {
                maxSum=tempSum;
                start=tempstart;
                end=i;
            }

            if (tempSum<0) {
                tempSum=0;
                tempstart=i+1;
            }
        }
        return new int[] {maxSum,start,end};


    }
}







