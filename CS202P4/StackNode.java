/*Dominic Shreckengost  -  CS202  -  Program #4 StackNode Class  -  3/8/2016

This file implements the StackNode class, which holds the actual String data
for the English phrase to search by, and its corresponding translation.
*/
public class StackNode {
    private String phrase;
    private String translation;

    public StackNode(){
        this.phrase = null;
        this.translation = null;
    }

    public StackNode(String phraseIn, String transIn){
        this.phrase = phraseIn;
        this.translation = transIn;
    }

    public StackNode(StackNode source){
        this(source.phrase, source.translation);
    }

/*Sets the phrases associated with a StackNode. Returns no value.*/
    public void setPhrase(String englishPhrase, String transPhrase){
        this.phrase = englishPhrase;
        this.translation = transPhrase;
    }

/*Displays a StackNode's String data. If either the English phrase or Spanish
translation phrase are null references, the function returns false. Otherwise,
the data is displayed and the function returns true.*/
    public boolean display(){
        if(this.phrase == null || this.translation == null)
            return false;
        System.out.println("English: " + this.phrase);
        System.out.println("Spanish: " + this.translation);
        System.out.println();
        return true;
    }

/*Compares a passed-in String to the English phrase in the StackNode. If there
is a match, function displays the StackNode's contents and returns 1. Otherwise,
function returns 0.*/
    public int getTrans(String searchPhrase){
        if(this.phrase.equalsIgnoreCase(searchPhrase)) {
            this.display();
            return 1;
        }
	return 0;
    }

/*Function compares a passed in String to all substrings of equal length within
the StackNode's phrase String. If a match is found, function displays the contents
of the StackNode and returns 1. Otherwise, it returns 0.*/
    public int keywordSearch(String searchPhrase){
        for(int i = 0; i <= (this.phrase.length() - searchPhrase.length()); ++i){
            if(this.phrase.regionMatches(i, searchPhrase, 0, searchPhrase.length())) {
                this.display();
                return 1;
            }
        }
        return 0;
    }
}
