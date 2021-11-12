package com.github.gjacobr;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.util.*;

public class CalculateStats {
    private double wpm;
    private double accuracy;
    private String errors;

    /* Kinds of errors
     * Mistyping a word (individual wrong characters)
     * Making a word too short/long
     *     - Make all characters after the last correct one incorrect and go to the next word **WILL ADD**
     * Adding an extra word
     *     - Adding an extra word on accident (e.g. hitting space too early and typing "err or" and continuing)
     *     - Optimally it should ignore the rest of the word and keep going instead of making the rest wrong
     *     - if there's an extra word in the wordCount, go through input string to find the first word that is shorter
     *          than the corresponding word in excerpt and then delete the word in input. If it reaches the end
     *          delete the last word. hopefully that fixes it.
     *     - I came up with a generous rule for if they really mess up the spaces, but I won't include it
     *          because they really just messed up typing a lot. (e.g. counting "fox" if they type
     *          "The qui ck b ro wnb fox") The first rule is already generous.
     * Missing a word **NOT ADDING**
     *     - Rule to not penalize if they forget a word in the middle of the test but typed the rest correctly. Too hard
     *          to implement so I won't include it lololololololollllll just read better
     *     - If the word count of input is lower than the output, loop through the input as normal, but once a word is
     *          not equal then loop from the current index in input to find the
     *          next word in input that is equal to a word from the excerpt and go to it. If no word is exactly equal,
     *          go to the next word that is equal in length. If the words aren't equal but just happen to be equal in
     *          length then you got the rest of the paragraph wrong /shrug
     */

    public static double calculateWPM(int wordCount, double time){
        /* definitely works */
        return  wordCount/(time/60);
    }

    public static double calculateAccuracy(String input, String excerpt){
        String[] excerptBySpace = excerpt.split(" ");
        int excerptWordCount = excerptBySpace.length;
        String[] inputBySpace = input.split(" ");
        int inputWordCount = inputBySpace.length;
        int countCorrect = 0;
        int excerptCharCount = 0;

        /* Finds the errors in each word */

        for(int i = 0; i < excerptBySpace.length; i++) {
            if(i>=inputBySpace.length) {break;}
            char[] inputWord = inputBySpace[i].toCharArray();
            char[] excerptWord = excerptBySpace[i].toCharArray();

            if(inputBySpace[i].length() < excerptBySpace[i].length()) {
                for (int j = 0; j < inputBySpace[i].length(); j++) {
                    excerptCharCount += 1;
                    if (inputWord[j] == excerptWord[j]) {
                        countCorrect += 1;
                    }
                }
                excerptCharCount += excerptBySpace[i].length() - inputBySpace[i].length();
            } else {
                if(inputBySpace[i].length() > excerptBySpace[i].length()){
                    excerptCharCount += inputBySpace[i].length() - excerptBySpace[i].length();
                }
                for (int j = 0; j < excerptBySpace[i].length(); j++) {
                    excerptCharCount += 1;
                    if (inputWord[j] == excerptWord[j]) {
                        countCorrect += 1;
                    }
                }
            }
            /* correct space */
            excerptCharCount+=1;
            countCorrect+=1;
        }
        /* an extra space is added */
        excerptCharCount-=1;
        countCorrect-=1;
        double count = (double) countCorrect;
        double excerptTotalChar = (double) excerptCharCount;
        double accuracy = (count / excerptTotalChar ) * 100;
        return accuracy;
    }

    public static String showErrors(String excerpt, String input){
        String[] excerptBySpace = excerpt.split(" ");
        String[] inputBySpace = input.split(" ");
        String output = "";

        /* Finds the errors in each word */

        for(int i = 0; i < excerptBySpace.length; i++) {
            if(i>=inputBySpace.length) {break;}
            char[] inputWord = inputBySpace[i].toCharArray();
            char[] excerptWord = excerptBySpace[i].toCharArray();
            if (inputBySpace[i].length() < excerptBySpace[i].length()) {
                for (int j = 0; j < inputBySpace[i].length(); j++) {
                    if (inputWord[j] == excerptWord[j]) {
                        output += inputWord[j];
                    } else {
                        output += ("**" + excerptWord[j] + "**");
                    }
                }
                //int lastIndex = inputBySpace[i].length();
                output +="**(";
                for(int lastIndex = inputBySpace[i].length(); lastIndex < excerptBySpace[i].length(); lastIndex++){
                    output += (excerptWord[lastIndex]);
                }
                output += ")**";
            } else {
                for (int j = 0; j < excerptBySpace[i].length(); j++) {
                    if (inputWord[j] == excerptWord[j]) {
                        output += inputWord[j];
                    } else {
                        output += ("~~"+inputWord[j]+"~~" + "**(" + excerptWord[j] + ")**");
                    }
                }
            }
            output += " ";
            System.out.println("output: " + output);
        }
        return output;
    }

}
