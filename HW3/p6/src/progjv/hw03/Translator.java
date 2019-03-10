package progjv.hw03;

/**
 * This interface contains one method: translate method, which translates a word from one language to another
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 30.03.2018
 */
public interface Translator{
    /**
     * This method translates a word from one language to another. 
     * The languages depend on the class that implements this interface
     * @param sourceWord the word which will be translated
     * @return the translated word
     */
    String translate(String sourceWord);
}