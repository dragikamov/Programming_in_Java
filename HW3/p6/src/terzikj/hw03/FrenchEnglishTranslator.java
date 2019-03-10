package terzikj.hw03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import progjv.hw03.Translator;

/**
 * This class represents a french-english translator. Contains a set of dictionary entries.
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 30.03.2018 
 */
public class FrenchEnglishTranslator implements Translator{

    private HashMap<String, DictEntry> data;

    /**
     * Default constructor. Initializes the dictionary hashmap entries and reads
     * them from a text file.
     */
    public FrenchEnglishTranslator(){

        data = new HashMap<String, DictEntry>();
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader("fr2en.txt"));
            String line = "";
            while((line = bReader.readLine()) != null){
                String[] words = line.split("--");
                for(int i = 0; i < words.length; i++){
                    words[i] = words[i].trim();
                }
                DictEntry newDictEntry = new DictEntry(words[1], words[0]);
                data.put(newDictEntry.getForeignWord(), newDictEntry);
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check {@code translate()} inside interface {@code Translator}
     */
    @Override
    public String translate(String sourceWord) {
        if(data.containsKey(sourceWord)){
            return data.get(sourceWord).getEnglishWord();
        } else {
            return null;
        }
    }
}