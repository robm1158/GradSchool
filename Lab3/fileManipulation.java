package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;


public class fileManipulation {
    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);

    public fileManipulation(String file,genericStack<Lab3.huffmanNode> temp){
        fileName = new File(file);
        gs = temp;

    }

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

    public void print(){
        Lab3.huffmanNode hn = new Lab3.huffmanNode();
        while(gs.size() >= 0){
            hn = (Lab3.huffmanNode)gs.pop();
            System.out.println("Out of the generic: " + hn.s);
            System.out.println("Out of the generic: " + hn.data);
        }

    }

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

    public void setHuffmanStack(genericStack<Lab3.huffmanNode> gshn){
        gs = gshn;
    }
 
    public void binaryPrint(Lab3.huffmanNode hn, String s){
        //Lab3.huffmanNode hn = new Lab3.huffmanNode();
        //hn = (Lab3.huffmanNode)gs.pop();
        if(hn.left == null && hn.right == null && !hn.s.isEmpty()){
            System.out.println(hn.s + ": " + hn.data + ": "+ s);
            return;
        }


        binaryPrint(hn.left,s + "0");
        binaryPrint(hn.right,s + "1");

    }

    public void inputEncodedData(genericStack<Lab3.encodedData> gsEncodedData){
        Lab3.encodedData ed = new Lab3.encodedData();

        try{
            Scanner scan = new Scanner(fileName);
            int counter = 0;
            while(scan.hasNextLine()){
                counter = scan.next().length() + counter;     
            }
            System.out.println(counter);
            while(counter >= 0){
                ed.c = scan.next().charAt(counter);
                gs.push(ed.c);
                counter--;

            }
        }
        catch(IOException e){
            e.getStackTrace();
        }

    }

    public void reverseHuffNode(){

        Lab3.genericStack tempgs = new genericStack<Lab3.huffmanNode>(gs.size());
        while(gs.size() >= 0){
            tempgs.push(gs.pop());
        }
        gs = tempgs;

    }

    public void reverseEncodedData(){

    }
    

} 