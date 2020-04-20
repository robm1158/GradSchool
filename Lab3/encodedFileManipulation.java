package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class encodedFileManipulation {
    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.encodedData>(15);
    private int currentFileIndex = 0;
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

    public String decodeData(char[] data, Lab3.huffmanNode ht){
        currentFileIndex = 0;
        String decoded = "";
        while(currentFileIndex < data.length){
            decoded += f(data, ht);
        }
        System.out.println(decoded);
        return decoded;
    }

    public String f( char[] data, Lab3.huffmanNode node){
        Lab3.huffmanNode next = null;
        if (node.right == null && node.left == null){
            return node.s;
        } else if(data[currentFileIndex] == '0'){
            next = node.left;
        } else if(data[currentFileIndex] == '1'){
            next = node.right;
        } else if(currentFileIndex >= data.length){
            return "***";
        }
        if( next == null){
            return node.s;
        } else {
            currentFileIndex++;
            return f(data, next);
        }
    }

    private void reverseEncodedData(){

        Lab3.genericStack tempgs = new genericStack<Lab3.encodedData>(gs.size());
        while(gs.size() >= 0){
            tempgs.push(gs.pop());
        }
        gs = tempgs;

    }

}