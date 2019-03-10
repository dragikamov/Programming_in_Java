package progjv.hw03;

import java.util.Scanner;

import terzikj.hw03.FrenchEnglishTranslator;
import terzikj.hw03.GermanEnglishTranslator;

/**
 * This class is a driver test program for the translator interface and 
 * the german and french translator classes. It initializes two translators
 * and then prompts the user for words to translate.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 30.03.2018  
 */
public class DictConsole{

    private Translator germanTranslator;
    private Translator frenchTranslator;

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        DictConsole dict = new DictConsole();
        dict.setTranslator(new GermanEnglishTranslator());
        dict.setTranslator(new FrenchEnglishTranslator());
        dict.run();
    }

    /**
     * Sets the translator. If {@code translator} is an instance of
     * GermanEnglishTranslator, the {@code this.germanTranslator} is set,
     * otherwise the {@code this.frenchTranslator} is set
     * @param translator the translator which is set to either german or french.
     */
    public void setTranslator(Translator translator){
        if(translator instanceof GermanEnglishTranslator){
            germanTranslator = translator;
        } else {
            frenchTranslator = translator;
        }
    }

    /**
     * @return the german translator
     */
    public Translator getGermanTranslator(){
        return this.germanTranslator;
    }

    /**
     * @return the french translator
     */
    public Translator getFrenchTranslator(){
        return this.frenchTranslator;
    }

    /**
     * Loop method which prompts the user for words to be translated.
     */
    private void run(){

        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Type (g) for German, (f) for French:");
            String op = in.nextLine();
            String foreignWord = "";
            String englishWord = "";
            switch(op){
                case "g":
                    System.out.println("Enter german word:");
                    foreignWord = in.nextLine();
                    englishWord = getGermanTranslator().translate(foreignWord);
                    System.out.println(englishWord);
                    break;
                default:
                    System.out.println("Enter french word:");
                    foreignWord = in.nextLine();
                    englishWord = getFrenchTranslator().translate(foreignWord);
                    System.out.println(englishWord);
            }
        }
    }
}