/*Dominic Shreckengost  -  CS202  -  Program #4 Block Class  -  3/8/2016

This file implements the Block class which is utilized by the Stack class.
It creates blocks of StackNodes in which String data representing each phrase
to translate is stored.
 */
public class Block {
    final private int BLOCK_SIZE = 5;
    private StackNode[] data;
    private int blockSize;
    private Block next;

    public Block() {
        this.data = null;
        this.blockSize = 0;
    }

/*Pushes a StackNode into the current Block if the current Block is not full and
returns true if so. If the current Block is full or the StackNode toPush is a null
reference, function returns false.*/
    public boolean push(StackNode toPush) {
        if (toPush == null || this.blockSize >= this.BLOCK_SIZE)
            return false;

        else if (this.blockSize == 0) {
            this.data = new StackNode[this.BLOCK_SIZE];
            for (int i = 0; i < this.BLOCK_SIZE; ++i)
                this.data[i] = new StackNode();
        }
        this.data[blockSize] = new StackNode(toPush);
        ++this.blockSize;
        return true;
    }

/*Sets the next Block reference to the reference at toNext. Returns no value.*/
    public void setNext(Block toNext){
        this.next = toNext;
    }

/*Returns a reference to the next Block at the current Block's next reference.*/
    public Block getNext(){
        return this.next;
    }

/*Displays the StackNode data at the top index of the current Block, returning
true if the current blockSize is greater than zero. Returns false otherwise.
Function not used in final program - used for testing purposes.*/
    public boolean displayTop(){
        if(this.blockSize <= 0)
            return false;

        this.data[this.blockSize - 1].display();
        return true;
    }

/*Displays all data in the current Block. Returns no value.
Function not used in the final program - used for testing purposes.*/
    public void displayAll(){
        for(int i = this.blockSize - 1; i >= 0; --i)
            this.data[i].display();
    }

/*Searches the StackNodes in the Block for the String toFind, adding up the
number of matches found if  String exists in the current Block.
Function returns the count of matches found.*/
    public int getTrans(String toFind){
	int retval = 0;
        for(int i = 0; i < this.blockSize; ++i)
            retval += this.data[i].getTrans(toFind);
        return retval;
    }

/*Searches the StackNodes in the Block for an English phrase containing the
passed-in String toFind, adding up the number of times the String occurs in 
Strings in the StackNodes of the Block.
Function returns the count of matches found.*/
    public int keywordSearch(String toFind){
	int retval = 0;
        for(int i = 0; i < this.blockSize; ++i)
            retval += this.data[i].keywordSearch(toFind);
        return retval;
    }
}
