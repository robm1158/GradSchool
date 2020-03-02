/* This program takes in a txt file with postfix expressions. I will read them in and parse
them char by char evaluating each char. Depending on if it is an opperand or opperator.
If it is an apperand I will push the Letter to the stack class I made. If it is an opperator
I will follow certain rules laid out in the assignment to write commands to another file.*/

import java.io.*;

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


/* postCOnvert will go through the logic of picking out the opperators and opperands.
If it is a +-* /$ it will look at the stack and pop it twice, and then write the command to file.
If it is an opperand it will get pushed to the stack right away.*/
class postConvert{
    public int convert(String s){
        int len,set = 0,count = 0;
        len = s.length();
        stack stackHold = new stack(len);
        for(int index = 0; index < len; index++){
            char letter = s.charAt(index);
/* Using an if statement instead of a switch statement mainly for ease of use and readability.
Dont think it really provices anything or takes away from anything.*/
            if(letter == '+'){
                count++;
                int firstPop = stackHold.pop();
                int secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
            }
            else if(letter == '-'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );

            }
            else if(letter == '*'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));
                System.out.println("LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
            }
            else if(letter == '/'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));
                System.out.println("LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                
            }
            else if(letter == '$'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                System.out.println("LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop) + "\n"+"ST TEMP"+count+"\n" );
                
            }
            else{
                //System.out.println("pushing "+letter);
                stackHold.push((letter));
            }
            
        }
        set = stackHold.pop();
        return set;
    }
}

/* Here is the main function to run the code. It also contains the routine needed to read the contents from
the file. It will also instantiate the methods needed to run the program. */
class RMullinsLab1{

    public static void main(String[] args)throws IOException{
        String input;
        postConvert test = new postConvert();
        File file = new File("PostfixMachineLangInput.txt"); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
        String st; 
        while ((st = br.readLine()) != null)
            
            System.out.println("Result: "+test.convert(st));
            System.out.println(st);
    }

}