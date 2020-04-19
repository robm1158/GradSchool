package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class encodedFileManipulation {
    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.encodedData>(15);

    public encodedFileManipulation(String file,genericStack<Lab3.encodedData> temp){
        fileName = new File(file);
        gs = temp;

    }

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
                //System.out.println(ed.c);
                gs.push(ed.c);
            }

        }
        catch(IOException e){
            e.getStackTrace();
        }
        reverseEncodedData();
        return gs;

    }
    
    public genericStack<Lab3.encodedData> getEncodedData(){
        return gs;
    }

    private void reverseEncodedData(){

        Lab3.genericStack tempgs = new genericStack<Lab3.encodedData>(gs.size());
        while(gs.size() >= 0){
            tempgs.push(gs.pop());
        }
        gs = tempgs;

    }

}