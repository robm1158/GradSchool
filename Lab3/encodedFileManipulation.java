// Rob Mullins
// This class is used to take in encoded data and store it in a stack
// that will hold the data as a char array. This class also hold the
// ability to traverse the tree and convert a letter into its binary
// form.

package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class encodedFileManipulation {

    // Class vars to use through out file
    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.encodedData>(15);
    private int currentFileIndex = 0;

    // Constructor setting file name to read and the general stack

    public encodedFileManipulation(String file,genericStack<Lab3.encodedData> temp){
        fileName = new File(file);
        gs = temp;

    }

    // Main function of the class reading in encoded data and pushing it into a stack.
    // This function returns the stack created

    public genericStack<Lab3.encodedData> inputEncodedData(genericStack<Lab3.encodedData> gsEncodedData){
        Lab3.encodedData ed = new Lab3.encodedData();
        int counter = 0;

        try{
            Scanner scan = new Scanner(fileName);
            while(scan.hasNextLine()){
                counter = scan.next().length() + counter;
            }

        }
        catch(IOException e){
            e.getStackTrace();
        }
        try{
            Scanner scan = new Scanner(fileName);
            while(scan.hasNextLine()){
                ed.c = scan.next().toCharArray();
                //System.out.println("here");
                System.out.println(ed.c);
                gs.push(ed.c);
            }
        }
        catch(IOException e){
            e.getStackTrace();
        }
        reverseEncodedData();
        return gs;

    }

    // Utility function used to get the stack of encoded data.
    
    public genericStack<Lab3.encodedData> getEncodedData(){
        return gs;
    }

    // Function used to decode the data. Impliments a recursive funtion
    // to treverse the tree and print out the corrisponding letter.

    public String decodeData(char[] data, Lab3.huffmanNode ht){
        currentFileIndex = 0;
        String decoded = "";
        while(currentFileIndex < data.length){
            decoded += searchTree(data, ht);
        }
        System.out.println(decoded);
        return decoded;
    }

    // Recursive solution to treversing the tree to print out clear text
    // letter. If the binary string is corrupted it will print it out
    // into the solution. 

    public String searchTree( char[] data, Lab3.huffmanNode node){
        Lab3.huffmanNode next = null;
        if (node.right == null && node.left == null){
            return node.s;
        } else if(data[currentFileIndex] == '0'){
            next = node.left;
        } else if(data[currentFileIndex] == '1'){
            next = node.right;
        } else if(currentFileIndex >= data.length){
            return "CURRUPTED DATA";
        }
        if( next == null){
            return node.s;
        } else {
            currentFileIndex++;
            return searchTree(data, next);
        }
    }

    // Utility function used to revese the order of the stack.

    private void reverseEncodedData(){

        Lab3.genericStack tempgs = new genericStack<Lab3.encodedData>(gs.size());
        while(gs.size() >= 0){
            tempgs.push(gs.pop());
        }
        gs = tempgs;

    }

}