package com.github.gjacobr;
import java.util.*;

public class CalculateStats {
    private double wpm;
    private double accuracy;
    private String errors;

    public static double calculateWPM(int wordCount, double time){
        /* definitely works */
        return  wordCount/(time/60);

    }

    public static double calculateAccuracy(String input, String excerpt){
        /* If you add an extra character in the middle of it, it will count the rest of the input as incorrect */
        char[] input3 = input.toCharArray();
        int usersize = input3.length;
        char[] input4 = excerpt.toCharArray();
        int origsize = input4.length;
        int index;
        double countCorrect = 0;
        for (index = 0; index < usersize; index += 1) {
            //System.out.println("input3index " + input3[index] + " input4index " + input4[index] + "\n");

            if (input3[index] == input4[index]) {
                //System.out.println("W input3index " + input3[index] + " input4index " + input4[index] + "\n");
                countCorrect += 1.0;
            }
        }
        return (countCorrect / (double) origsize) * 100;
    }

    public void showErrors(String excerpt, String input){

        System.out.println("XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
    }
}
