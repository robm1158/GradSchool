package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class decodedFileManipulation {
    File fileName;
    private char[] c = new char[200];
    private String s = "";
    Lab3.hashTable hasht = new hashTable();


    public decodedFileManipulation(String file, Lab3.hashTable ht){
        fileName = new File(file);
        hasht = ht;

    }

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

