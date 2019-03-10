package terzikj.hw03;

/**
 * This class represents a dictionary entry. It contains the same word in english and german language
 * @author Dushan Terzikj 30001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 30.03.2018
 */
public class DictEntry{

    private String englishWord;
    private String foreignWord;

    /* Constructors */

    /**
     * Default constructors. Sets all member variables to empty strings
     */
    public DictEntry(){
        englishWord = foreignWord = "";
    }

    /**
     * Parametrized constructor.
     * @param englishWord 
     * @param foreignWord
     */
    public DictEntry(String englishWord, String foreignWord){
        this.englishWord = englishWord;
        this.foreignWord = foreignWord;
    }

    /* Getters and Setters */

    /**
     * @return english word
     */
    public String getEnglishWord(){
        return this.englishWord;
    }

    /**
     * @return german word
     */
    public String getForeignWord(){
        return this.foreignWord;
    }

    /**
     * Sets the english word
     * @param englishWord the new english word to be set
     */
    public void setEnglishWord(String englishWord){
        this.englishWord = englishWord;
    }

    /**
     * Sets the german word
     * @param foreignWord the new german word to be set
     */
    public void setForeignWord(String foreignWord){
        this.foreignWord = foreignWord;
    }

    /* Service and helper methods */

    /**
     * Overriden method.
     * @return String representation of the dictionary entry
     */
    @Override
    public String toString() {
        return this.foreignWord + "  -- " + this.englishWord;
    }

    /**
     * Overriden method
     * Checks whether the {@code obj} is equal to {@code this}.
     * @param obj the object which is compared to {@code this}
     * @return {@code true} if {@code obj} is equal to {@code this}
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(!(obj instanceof DictEntry)){
            return false;
        }

        DictEntry dictEntry = (DictEntry)obj;
        return dictEntry.englishWord.equals(this.englishWord) 
        && dictEntry.foreignWord.equals(this.foreignWord);
    }
}