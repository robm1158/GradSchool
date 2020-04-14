package Lab3;

import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;


public class fileManipulation {
    File fileName;
    private Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);

    public fileManipulation(String file){
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
                 //   System.out.println(hn.s);
                   // System.out.println(hn.data);
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

    public void sortData(){
        Lab3.genericStack tgs = new genericStack<Lab3.huffmanNode>(10);
        Lab3.huffmanNode hn = new Lab3.huffmanNode();
        Lab3.huffmanNode thn = new Lab3.huffmanNode();
  
        while(!gs.isEmpty()){
            hn = (Lab3.huffmanNode)gs.pop();
            int tmp = hn.data;
            try{
                
                System.out.println("Above inner loop");
                boolean exitLopp = false;
                while(!exitLopp){
                    if(!tgs.isEmpty()){
                        thn = (Lab3.huffmanNode)tgs.pop();
                        if(thn.data < tmp){
                            this.gs.push(thn);
                        }
                        else{
                            exitLopp = true;
                            tgs.push(thn);
                        }
                    }
                    else{
                        exitLopp = true;

                    }
                }
                
            }
            catch(EmptyStackException e){
                e.printStackTrace();
            }
            System.out.println("push to temp stack " + tmp);

            tgs.push(hn);
        }
        
    }
}