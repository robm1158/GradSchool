
// Rob Mullins
// This class converts clear text data to binary using a hash table or
// look up table. 

package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class decodedFileManipulation {

    // Class vars 

    File fileName;
    private char[] c = new char[500];
    private String s = "";
    Lab3.hashTable hasht = new hashTable();

    // Constructor used to set filename and hash table to use.

    public decodedFileManipulation(String file, Lab3.hashTable ht){
        fileName = new File(file);
        hasht = ht;

    }

    // This function reads in the clear text and stores it as a
    // char array. To traverse and use in the look up table.

    public void inputDecodedData(){
        try{
            Scanner scan = new Scanner(fileName);
            while(scan.hasNextLine()){
                String temp = scan.nextLine();
                s += temp;
            }
            c = s.toCharArray();

        }
        catch(IOException e){
            e.getStackTrace();
        }

        System.out.println(c);
    }

    // This function uses the look up table to print the clear
    // text in binary. It checks to make sure what it is reading
    // is a letter and not a special char. This also ensures all
    // chars are capital as that it is what its comparing.

    public void convertToBinary(){
        String binaryString = "";
        for(int index = 0; index < c.length; index ++){
            if(Character.isLetter(c[index])){
                binaryString += hasht.getbinary(Character.toUpperCase(c[index]));

            }
        }
        System.out.println(binaryString);
    
    }

}

