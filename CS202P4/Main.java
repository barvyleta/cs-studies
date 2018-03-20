/*Dominic Shreckengost  -  CS202  -  Program #4 Main Class  -  3/8/2016

This file implements the Main class, containing the interface with which the
user interacts with the program. 
*/

import java.io.FileNotFoundException;

public class Main extends UserInput {

    public static void main(String[] args) {
        Translator newTrans = null;
        try {
            newTrans = new Translator();
        } catch (FileNotFoundException e) {
            System.out.println("Filename to import not found!");
            System.out.println("Change filename path in Translator.java.");
            System.exit(-1);
        }
        newTrans.importData();

        String userInput;
        int intInput = 0;

        do {
            System.out.println("What would you like to translate?\nChoose from the list below:");
            System.out.println("1 - Nouns");
            System.out.println("2 - Travel Questions");
            System.out.println("3 - Travel Phrases");
            System.out.print("Enter your selection: ");
            intInput = input.nextInt();
            input.nextLine();

            while(intInput < 1 || intInput > 3) {
                    System.out.println("Select a valid option!");
                    System.out.print("Enter your selection: ");
                    intInput = input.nextInt();
                    input.nextLine();
            }
            newTrans.searchForTrans(intInput - 1);

            System.out.println("Would you like to search for another translation?");
            userInput = input.nextLine().toLowerCase();
            while(userInput.charAt(0) != 'y' && userInput.charAt(0) != 'n'){
                System.out.print("Please enter Y or N: ");
                userInput = input.nextLine().toLowerCase();
            }
            }while(userInput.charAt(0) == 'y');
        System.out.println("Exiting program...");
    }
}
