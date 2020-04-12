package Lab3;

import java.io.*;
import java.util.Scanner;


public class fileRead {
    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);

    public fileRead(String file){
        fileName = new File(file);



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
                    System.out.println(hn.s);
                    System.out.println(hn.data);
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
        while(gs.size() > 0){
            hn = (Lab3.huffmanNode)gs.pop();
            System.out.println("Out of the generic: " + hn.s);
            System.out.println("Out of the generic: " + hn.data);
        }

    }
}