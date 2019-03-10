package com;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class represents a program which counts the words, different words
 * characters, different characters and lines in a text file.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 29.03.2018
 */
public class Counter{

    /**
     * This method counts the number of characters in the file and the number of different characters
     * with name {@code filename}. It throws IOException if the file does
     * not exist
     * @param filename the name of the file
     */
    public static void countCharacters(String filename){

        BufferedInputStream bis = null;
        TreeMap<Integer, Boolean> freq = new TreeMap<Integer, Boolean>();
        try{
            bis = new BufferedInputStream(new FileInputStream(filename));
            int next;
            int cnt = 0;
            while((next = bis.read()) != -1){
                if(!freq.containsKey(next)){
                    freq.put(next, true);
                }
                cnt++;
            }
            bis.close();
            System.out.println(cnt + " characters (" + freq.size() + " different characters)");

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method counts the number of words in the file and the number of different words
     * and the number of lines in the file with name {@code filename}. It throws IOException if the file does
     * not exist
     * @param filename the name of the file
     */
    public static void countWordsAndLines(String filename){

        BufferedReader bufferedReader = null;
        TreeMap<String, Boolean> freq = new TreeMap<String, Boolean>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
            String line = "";
            int cnt = 0;
            int numLines = 0;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(" ");
                cnt += words.length;
                numLines++;
                for(int i = 0; i < words.length; i++){
                    if(!freq.containsKey(words[i])){
                        freq.put(words[i], true);
                    }
                }
            }
            bufferedReader.close();
            System.out.println(cnt + " words (" + freq.size() + " different words)");
            System.out.println(numLines + " lines");
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        if(args.length < 1){
            System.err.println("File name not specified!");
            System.exit(0);
        }

        String filename = args[0];

        countCharacters(filename);
        countWordsAndLines(filename);
    }
}