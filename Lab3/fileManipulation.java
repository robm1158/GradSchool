// Rob Mullins
// The class used to take in a freq table and begin to parse it.
// Here we inoput the sorted data into the huffman node.
// We then push the node onto the stack. We also use the sort
// function to sort the stack with the lowest freq to be the
// first to be removed from the stack.




package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class fileManipulation {

    // Setting up class vars to use through out the class

    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);
    private Lab3.hashTable ht = new hashTable();

    // Constructor to intialize the file and stack

    public fileManipulation(String file,genericStack<Lab3.huffmanNode> temp){
        fileName = new File(file);
        gs = temp;

    }

    // This function will input the data to the stack reading line by line.It will start
    // by taking in the data and setting each node with the read in line and push to the stack.

    public void inputFileData(){

        try{

            Scanner scan = new Scanner(fileName).useDelimiter("\\s*-\\s*|\\s*\\R+");

            while(scan.hasNextLine()){

    
                if(scan.hasNextLine()){
                    Lab3.huffmanNode hn = new Lab3.huffmanNode();
                    
                    hn.s = scan.next();
                    hn.data = scan.nextInt();
                    hn.left = null;
                    hn.right = null;
                    gs.push(hn);
                }
                else{
                    scan.close();
                }
            }
        }
        catch(IOException e){
            e.getStackTrace();
        }

    }

    // This function will print each node. Utility function not used.

    public void print(){
        Lab3.huffmanNode hn = new Lab3.huffmanNode();
        while(gs.size() >= 0){
            hn = (Lab3.huffmanNode)gs.pop();
            System.out.println("Out of the generic: " + hn.s);
            System.out.println("Out of the generic: " + hn.data);
        }

    }

    // This function will sort the stack of huffman nodes with the
    // lowset freq on top of the stack meaning the lowest will 
    // be the first to be popped off.

    public genericStack<Lab3.huffmanNode> sortData(){
        Lab3.genericStack tgs = new genericStack<Lab3.huffmanNode>(10);
        Lab3.huffmanNode hn = new Lab3.huffmanNode();
        Lab3.huffmanNode thn = new Lab3.huffmanNode();
  
        while(!gs.isEmpty()){
            hn = (Lab3.huffmanNode)gs.pop();
            int tmp = hn.data;
            try{
                
                boolean exitLoop = false;
                while(!exitLoop){
                    if(!tgs.isEmpty()){
                        thn = (Lab3.huffmanNode)tgs.pop();
                        if((thn.data < tmp)){
                            
                            this.gs.push(thn);
                        }
                        else{
                            exitLoop = true;
                            tgs.push(thn);
                        }
                    }
                    else{
                        exitLoop = true;

                    }
                }
                
            }
            catch(EmptyStackException e){
                e.printStackTrace();
            }

            tgs.push(hn);
        }
        gs = tgs;
        return gs;
    }

    // Simple utility function to set a stack of huffman nodes.

    public void setHuffmanStack(genericStack<Lab3.huffmanNode> gshn){
        gs = gshn;
    }

    // Print the stack of huffman nodes with the corrisponding 
    // path value. A recursive funtion to print out the huffman node
    // also in pre-order.
 
    public Lab3.hashTable binaryPrint(Lab3.huffmanNode hn, String s){

        if(hn.left == null && hn.right == null && !hn.s.isEmpty()){
            System.out.println(hn.s + ": " + hn.data + ": "+ s);
            ht.setLetterInArray(hn.s.charAt(0));
            ht.setBinaryInArray(hn.s.charAt(0), s);
        }
        else{
            binaryPrint(hn.left,s + "0");
            binaryPrint(hn.right,s + "1");
        }
        return ht;

    }

    // Function to reverse the order of the huffman node stack. This is used to 
    // ensure the lowest freq is on top. Also a utility function.

    public void reverseHuffNode(){

        Lab3.genericStack tempgs = new genericStack<Lab3.huffmanNode>(gs.size());
        while(gs.size() >= 0){
            tempgs.push(gs.pop());
        }
        gs = tempgs;

    }

} 