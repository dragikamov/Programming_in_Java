package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * This class represents a program which accepts 2-3 parameters. First two parameters
 * are the source and the destination directories' name. If no third parameter is 
 * specified then all the files from the source directory are copied to the destination
 * directory. If a third parameter is specified, then it is considered as a file extension,
 * therefore, copying all the files only with that file extension. The program keeps the 
 * directory structure.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 29.03.2018
 */
public class CopyAll{

    /**
     * This method copies a file with name {@code src} to a file with name
     * {@code dest}. It uses {@code InputStream} and {@code OutputStream} to copy 
     * the files.
     * @param src the name file which is copied
     * @param dest the name of the file to which is pasted
     * @throws IOException 
     */
    public static void copy(String src, String dest) throws IOException{

        File srcFile = new File(src);
        File destFile = new File(dest);
        InputStream is = null;
        OutputStream os = null;

        System.out.println("Copying file " + srcFile.getName() + " to " + destFile.getPath());
        try{

            is = new FileInputStream(srcFile);
            os = new FileOutputStream(destFile);

            byte[] buf = new byte[1024];

            int bytesRead;
            while((bytesRead = is.read(buf)) > 0){
                fos.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
        System.out.println("Successfully copied!");
    }

    /**
     * This is a helper method which returns the file extension of a file
     * {@code f}.
     * @param f the file whose extension is returned
     * @return the file extension, null if there is no extension
     */
    public static String getExtension(File f){

        String filename = f.getName();
        int i = filename.lastIndexOf(".");
        if(i > 0){
            return filename.substring(i+1);
        }
        return null;
    }

    /**
     * This method lists a current directory. First it recursively lists any other directories
     * in the current directory and then copies all the files which match the {@code extension}
     * If {@code extension} is null it copies all the files using {@code copy()}.
     * @param src the name of the source file
     * @param dest the name of the destination file
     * @param extension 
     * @throws IOException 
     */
    public static void listFiles(String src, String dest, String extension) throws IOException{

        File srcdir = new File(src);
        System.out.println("Entering " + srcdir.getPath());
        File[] files = srcdir.listFiles();
        for(File f : files){
            if(f.exists() && f.isDirectory()){
                File destdir = new File(dest + "/" + f.getName());
                if(!destdir.exists()){
                    try{
                        destdir.mkdir();
                    } catch(SecurityException e){
                        e.printStackTrace();
                    }
                }
                listFiles(src + "/" + f.getName(), dest + "/" + f.getName(), extension);
            }
        }

        for(File f : files){
            if(f.exists() && !f.isDirectory()){
                if(extension == null){
                    copy(src + "/" + f.getName(), dest + "/" + f.getName());
                } else {
                    String ext = getExtension(f);
                    if(ext != null && ext.equals(extension)){
                        copy(src + "/" + f.getName(), dest + "/" + f.getName());
                    }
                }
            }
        }
    }

    /**
     * Checks whether two files exist
     * @param srcdir
     * @param destdir
     * @return {@code true} if both files exists, {@code false} otherwise
     */
    public static boolean isValid(String srcdir, String destdir){

        File srcFile = new File(srcdir);
        File destFile = new File(destdir);
        if(srcFile.exists() && srcFile.isDirectory() && destFile.exists() && destFile.isDirectory()){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        
        String srcdir = "";
        String destdir = "";
        String extension = "";
        if(args.length < 2){
            System.err.println("Not enough arguments!");
            System.exit(1);
        }
        if(args.length >= 2){
            srcdir = args[0];
            destdir = args[1];
            /* Since we are running using ant build.xml, default arguments containt $
            If the default arguments are passed, we have no valid directory names */
            if(srcdir.contains("$") || destdir.contains("$")){
                System.err.println("Not enough arguments!");
                System.exit(1);
            }
            if(args.length > 2){
                extension = args[2];
            }
            if(extension.equals("") || extension.contains("$")){
                extension = null;
            }
        }

        if(isValid(srcdir, destdir)){
            listFiles(srcdir, destdir, extension);
            System.out.println("Files copied successfully!");
        } else {
            System.out.println("Source or destination file do not exist");
        }
            
    }
}