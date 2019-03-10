package com.main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class contains a main method. The program reads characters
 * from a file called 'file.txt' and counts the frequency of every
 * letter. 
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 28.03.2018
 */
public class Main{

    public static void main(String[] args){

        int[] freq = new int[26];
        Arrays.fill(freq, 0);

        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            fis = new FileInputStream("file.txt");
            bis = new BufferedInputStream(fis);
            int c;
            while((c = bis.read()) != -1){
                char ch = (char)c;
                if(Character.isLetter(ch)){
                    Character.toLowerCase(ch);
                    freq[(int)(ch-'a')]++;
                }
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 

        for(int i = 0; i < 26; i++){
            System.out.println(freq[i]);
        }
    }
}