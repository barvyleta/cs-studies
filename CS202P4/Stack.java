/*Dominic Shreckengost  -  CS202  -  Program #4 Stack Class  -  3/8/2016

This file implements the Stack class, used by the Translator to house the
English and Spanish phrases to be imported, stored, and searched.*/

public class Stack {
    private int topIndex;
    private Block head;

    public Stack(){
        this.topIndex = 0;
        this.head = null;
    }

/*Pushes a StackNode on top of the Stack. If the current Block is full,
function creates a new Block to push the StackNode onto. If the StackNode
reference toPush is null, function returns false; otherwise, once the push
is complete, function returns true.*/
    public boolean push(StackNode toPush){
        if(toPush == null)
            return false;

        if(this.head == null)
            this.head = new Block();

        if(this.head.push(toPush));
        else{
            Block temp = new Block();
            temp.setNext(this.head);
            this.head = temp;
            this.head.push(toPush);
        }
        ++this.topIndex;
        return true;
    }

/*Function displays the top of the Stack. Not used in final program - only during testing.*/
    public void displayHead(){
        System.out.println("The current top of the stack is: ");
        if(head.displayTop());
        else
            head.getNext().displayTop();
    }

/*Function displays contents of entire Stack. Not used in final program - only during testing.*/
    public void displayAll(){
        if(this.topIndex < 5)
            this.head.displayAll();
        else{
            Block temp = this.head;
            while(temp != null){
                temp.displayAll();
                temp = temp.getNext();
            }
        }
    }

/*Function takes in a String and searches the entire Stack for a matching phrase.
For each match found, that entry is displayed and the return value of that Block's
getTrans() call is added to retval. The number of matches is displayed to declare
to the user how many matches were found, if there were any. Returns no value.*/
    public void getTrans(String userInput){
        Block temp = this.head;
	int retval = 0;

        while(temp != null){
	    retval += temp.getTrans(userInput);
            temp = temp.getNext();
	}

        if(retval == 1)
            System.out.println(retval + " match found!");
	else
	    System.out.println(retval + " matches found!");
    }


/*Function takes in a String and searches the entire Stack for an English phrase
containing the passed-in String as a substring. For each match found, that entry
is displayed and the return value of that Block's getTrans() call is added to
retval. The number of matches is displayed to declare to the user how many matches
were found, if there were any. Returns no value.*/
    public void keywordSearch(String toFind){
        Block temp = this.head;
	int retval = 0;

        while(temp != null){
	    retval += temp.keywordSearch(toFind);
            temp = temp.getNext();
	}

        if(retval == 1)
            System.out.println(retval + " match found!");
	else
	    System.out.println(retval + " matches found!");
    }
}
