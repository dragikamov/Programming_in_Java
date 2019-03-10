package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a program which copies content from one file to another file.
 * More information can be found in the documentation of the methods
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 29.03.2018
 */
public class Copy{

    private static Scanner in = new Scanner(System.in);

    /**
     * This method copies file {@code f1} to {@code f2}. It depends whether {@code f2}
     * is a directory or a file. If it is a directory, then {@code f1} is copied inside
     * {@code f2}. If it is a file, then the contents of {@code f1} are copied into
     * {@code f2}.
     * @param f1 
     * @param f2
     * @throws IOException
     * @return {@code true} if copying is successful
     */
    public static boolean copy(File f1, File f2){

        File outputFile = null;

        if(f2.isDirectory()){
            outputFile = new File(f2.getName() + "/" + f1.getName());
        } else {
            outputFile = new File(f2.getName());
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(f1);
            fos = new FileOutputStream(outputFile);
            
            byte[] buf = new byte[1024];
            int bytesRead;
            System.out.println("Copying " + f1.getName() + " to " + outputFile.getPath());
            while((bytesRead = fis.read(buf)) != -1){
                fos.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * Prompts the user for two filenames. filename1 must be a file and must exist. filename2 
     * can be a directory too. If filename2 is a directory then, filename1 is copied into that
     * directory. If filename2 is a file, then the content of filename1 is copied into filename2
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException{

        String filename1 = "";
        String filename2 = "";
        System.out.println("Please enter the name of the first file:");
        filename1 = in.next();
        File f1 = new File(filename1);
        if(!f1.exists()){
            throw new FileNotFoundException(filename1 + " does not exist!");
        }
        if(!f1.isFile()){
            System.err.println("This file is not a file!");
            System.exit(1);
        }
        System.out.println("Please enter the name of the second file/directory:");
        filename2 = in.next();
        File f2 = new File(filename2);
        if(!f2.exists()){
            throw new FileNotFoundException(filename2 + " does not exist!");
        }

        if(copy(f1, f2)){
            System.out.println("Copying successful!");
        } else {
            System.err.println("Copying unsuccessful!");
        }
    }
}