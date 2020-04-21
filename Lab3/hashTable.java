// Rob Mullins
// Creates a hash table to store data of the char and
// its corrisponding binary code from the tree.

package Lab3;

public class hashTable {

    // class vars

    char[] letters = new char[100];
    String[] binaryLetters = new String[100];

    // simple function to set the char in the array at its
    // ascii location

    public void setLetterInArray(char c){

        letters[(int)c] = c;

    }

    // sets the corrisponding binary at the same location
    // as the ascii char it goes with

    public void setBinaryInArray(char c, String s ){

        binaryLetters[(int)c] = s;

    }

    // Gets the binary result from the array and requested
    // char

    public String getbinary(char c){
        String number;
        number = binaryLetters[(int)c];
        return number;
    }

    // Prints the entire arrays

    public void printArray(){
        for(int index = 0; index < letters.length; index++){

            System.out.println(letters[index] + ": " + binaryLetters[index]);

        }
    }

}