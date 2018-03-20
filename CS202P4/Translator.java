/*Dominic Shreckengost  -  CS202  -  Program #4 Translator Class  -  3/8/2016

This file implements the Translator class, which acts as the primary class the
user or client program will interact with.*/

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Translator extends UserInput{
    private Stack [] banks;
    private int numOfBanks = 3;
    private File toRead = new File(System.getProperty("user.dir"), "phrases_nouns_questions.txt");
    private Scanner fileIn;

/*Throws exception if the file to read from is not found.
Main will catch and exit accordingly.*/
    public Translator() throws FileNotFoundException {
        this.fileIn = new Scanner(this.toRead);
        this.banks = new Stack[this.numOfBanks];
        for (int i = 0; i < this.numOfBanks; ++i)
            this.banks[i] = new Stack();
    }

/*Imports data from the text file member declared above. The function removes
all punctuation from the input words/phrases and inputs them in lower case only.
Input text from file is separated by '\t' characters in the following order:
Integer declaring which stack the words/phrases belong to (among 0 - Nouns, 1 - Travel
Questions, and 2 - Travel Phrases), word/phrase in English, word/phrase in Spanish.
Function returns no value.*/
    public void importData(){
        StackNode toImport = new StackNode();
        String fileInput;
        String phrases [];

        int bankFlag;

        while(this.fileIn.hasNextLine()){
            fileInput = this.fileIn.nextLine();
            bankFlag = (fileInput.charAt(0) - '0');
            fileInput = fileInput.substring(2);
            phrases = fileInput.split("\t");

            for(int i = 0; i < 2; ++i){
                phrases[i] = phrases[i].toLowerCase();
                phrases[i] = phrases[i].replaceAll("\\p{Punct}+", "");
            }
            toImport.setPhrase(phrases[0], phrases[1]);
            this.banks[bankFlag].push(toImport);
        }
    }

/*Kicks off user's search for a translation, depending on the integer entered
to designate which Stack to search through. Prompts user whether they know
the exact word/phrase to search for - if so, they are prompted to enter the
word or phrase exactly; otherwise, they are prompted to enter a keyword.
Function returns no value.*/
    public void searchForTrans(int bankFlag){
        String userInput;

        System.out.print("Do you know the exact word of phrase? (Y/N)\n> ");
        userInput = input.nextLine().toLowerCase();
        while(userInput.charAt(0) != 'y' && userInput.charAt(0) != 'n'){
            System.out.print("Please enter Y or N: ");
            userInput = input.nextLine().toLowerCase();
        }
        if(userInput.charAt(0) == 'y'){
            System.out.println("Enter the word or phrase to search for.");
            userInput = input.nextLine().toLowerCase();
            this.banks[bankFlag].getTrans(userInput);
        }
        else {
            System.out.print("Enter a keyword:\n> ");
            userInput = input.nextLine().toLowerCase();
            this.banks[bankFlag].keywordSearch(userInput);
        }
    }

/*Displays all words and phrases, as well as which bank of words/phrases
it is found in. Not used in final program - used for testing purposes.*/
    public void displayAll(){
        for(int i = 0; i < this.numOfBanks; ++i) {
            System.out.println("In bank: " + i);
            this.banks[i].displayAll();
        }
    }
}
