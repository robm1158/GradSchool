/* This program takes in a txt file with postfix expressions. I will read them in and parse
them char by char evaluating each char. Depending on if it is an opperand or opperator.
If it is an apperand I will push the Letter to the stack class I made. If it is an opperator
I will follow certain rules laid out in the assignment to write commands to another file.*/

import java.io.*;
import java.util.Scanner;
/*Bellow is a stack class. This class contains the methods to push and pop with the constructor.
I will use this to hold the chars I parse from the input file.*/
class stack{

    private char[] hold;
    private int top,x;

    public stack(int max){

        x = max;
        hold = new char[x];
        top = -1;
    }
    public void push(char value){
        hold[++top] = value;

    }
    public char pop(){
        return(hold[top--]);
    }

}
class fileTasks{
    public void createFile(String s){
        try {
            File myObj = new File(s);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public void writeFile(String fileName, String stringToWrite){
        try {
            FileWriter myWriter = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(stringToWrite);
            //myWriter.write(stringToWrite);
            bw.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }


}


/* postCOnvert will go through the logic of picking out the opperators and opperands.
If it is a +-* /$ it will look at the stack and pop it twice, and then write the command to file.
If it is an opperand it will get pushed to the stack right away.*/
class postConvert{
    public void convert(String s){
        int len,set = 0,count = 0;
        len = s.length();
        fileTasks write = new fileTasks();
        stack stackHold = new stack(len);
        for(int index = 0; index < len; index++){
            char letter = s.charAt(index);
/* Using an if statement instead of a switch statement mainly for ease of use and readability.
Dont think it really provices anything or takes away from anything.*/
            if(letter == '+'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile("Output.txt", "LD TEMP"+(int)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile("Output.txt", "LD TEMP"+(int)(secPop)+"\n"+"AD "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"AD "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile("output.txt", "LD "+(char)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                    System.out.println("LD "+(char)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else{
                    write.writeFile("Output.txt", "LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );

                }

            }
            else if(letter == '-'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile("Output.txt", "LD TEMP"+(int)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile("Output.txt","LD TEMP"+(int)(secPop)+"\n"+"SB "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");

                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"SB "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");

                    System.out.println("LD "+(char)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else{
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");

                    System.out.println("LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }

            }
            else if(letter == '*'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile("Output.txt","LD TEMP"+(int)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile("Output.txt","LD "+(int)(secPop)+"\n"+"ML "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(int)(secPop)+"\n"+"ML "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else{
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
            }
            else if(letter == '/'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile("Output.txt","LD TEMP"+(int)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile("Output.txt","LD "+(int)(secPop)+"\n"+"DV "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                    System.out.println("LD "+(int)(secPop)+"\n"+"DV "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else{
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                
            }
            /* Here I am implememnting my enhancment. I am including the $ which is a ^ in terms of math. */
            else if(letter == '$'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile("Output.txt","LD TEMP"+(int)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile("Output.txt","LD "+(int)(secPop)+"\n"+"EX "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                    System.out.println("LD "+(int)(secPop)+"\n"+"EX "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                else{
                    write.writeFile("Output.txt","LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                }
                
            }
            else{
                //System.out.println("pushing "+letter);
                stackHold.push((letter));
            }
            
        }
    }
}

/* Here is the main function to run the code. It also contains the routine needed to read the contents from
the file. It will also instantiate the methods needed to run the program. */
class RMullinsLab1{

    public static void main(String[] args)throws IOException{
        postConvert test = new postConvert();
        fileTasks newFile = new fileTasks();
        newFile.createFile("Output.txt");
        File file = new File("PostfixMachineLangInput.txt"); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String st; 
        while ((st = br.readLine()) != null){
            System.out.println("Result for "+st);
            newFile.writeFile("Output.txt", "\n"+st+"\n");
            test.convert(st);
            //System.out.println();
        }
        br.close();
            
            
    }

}