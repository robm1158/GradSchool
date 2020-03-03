/* This program takes in a txt file with postfix expressions. I will read them in and parse
them char by char evaluating each char. Depending on if it is an opperand or opperator.
If it is an apperand I will push the Letter to the stack class I made. If it is an opperator
I will follow certain rules laid out in the assignment to write commands to another file.*/

import java.io.*;
import java.util.Scanner;


/*Bellow is a stack class. This class contains the methods to push and pop with the constructor.
I will use this to hold the chars I parse from the input file.*/
class stackChar{

    private char[] container,copy;
    private int top, max_size, curr_size;

    public stackChar(int max){
        max_size = max;
        container = new char[max_size];
        top = -1;
    }

    public void push(char value){
        if (curr_size >= max_size){
            System.out.println("System overflow resize stack");
            resize(max_size*2);
        }
        curr_size++;
        container[++top] = value;


    }
    public char pop(){
        if (top >= 0){
            return(container[top--]);
        }
        else{
            throw new RuntimeException("Stack underflow!!");
        }
        
    }

    public int size(){
        return top;
    }
    
    public void clear(){
        for (int i = 0; i < top; i++)
            container[i] = (Character)null;
        top = -1;
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        else{
            return false;
        }
    }
    private void resize(int new_size){

        copy = new char[new_size];
        for(int i = 0; i < curr_size; i++){
            copy[i] = container[i];
        }
        container = new char[new_size];
        container = copy;
        max_size = new_size;
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
    private fileTasks write = new fileTasks();
    private stackChar stackHold = new stackChar(6);
    public int count = 0;
    private char letter;

    public void convert(String fileName, char someChar){
        
        letter = someChar;

/* Using an if statement instead of a switch statement mainly for ease of use and readability.
Dont think it really provices anything or takes away from anything.*/

        if ((int)(letter) != 0){
            System.out.println(letter);

            if(letter == '+'){
                
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName, "LD TEMP"+(int)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                }
                
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName, "LD TEMP"+(int)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName, "LD "+(char)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"AD TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName, "LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"AD "+ (char)(firstPop)+"\n");

                }
                System.out.println("size: " +stackHold.size());
                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
            }
            else if(letter == '-'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName, "LD TEMP"+(int)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) +"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop) +"\n" );
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"SB "+ (char)(firstPop)+"\n");

                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"SB "+ (char)(firstPop) +"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop)+"\n");

                    System.out.println("LD "+(char)(secPop)+"\n"+"SB TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop)+"\n");

                    System.out.println("LD "+(char)(secPop)+"\n"+"SB "+ (char)(firstPop)+"\n");
                }
                System.out.println("size: " +stackHold.size());

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");

            }
            else if(letter == '*'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                }
                
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD "+(int)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(int)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"ML TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"ML "+ (char)(firstPop)+"\n");
                }
                System.out.println("size: " +stackHold.size());

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
            }
            else if(letter == '/'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD "+(int)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(int)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"DV TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"DV "+ (char)(firstPop)+"\n");
                }
                
                System.out.println("size: " +stackHold.size());

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
                
            }
            /* Here I am implememnting my enhancment. I am including the $ which is a ^ in terms of math. */
            else if(letter == '$'){
                count++;
                char firstPop = stackHold.pop();
                char secPop = stackHold.pop();
                stackHold.push((char)(count));

                if(((int)(secPop) > 0 && (int)(secPop) <= 9) && ((int)(firstPop) > 0 && (int)(firstPop) <= 9)){
                    write.writeFile(fileName,"LD TEMP"+(int)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD TEMP"+(int)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                }
                else if((int)(secPop) > 0 && (int)(secPop) <= 9){
                    write.writeFile(fileName,"LD "+(int)(secPop)+"\n"+"EX "+ (char)(firstPop)+"\n" );
                    System.out.println("LD "+(int)(secPop)+"\n"+"EX "+ (char)(firstPop) +"\n");
                }
                else if((int)(firstPop) > 0 && (int)(firstPop) <= 9){
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"EX TEMP"+ (int)(firstPop)+"\n");
                }
                else{
                    write.writeFile(fileName,"LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop)+"\n");
                    System.out.println("LD "+(char)(secPop)+"\n"+"EX "+ (char)(firstPop)+"\n");
                }
                System.out.println("size: " +stackHold.size());

                write.writeFile(fileName, "ST TEMP"+count+"\n");
                System.out.println("ST TEMP"+count+"\n");
                
            }
            else if(Character.isLetter(letter)){
                System.out.println("pushing "+letter);
                stackHold.push((letter));
            }
            else{
                throw new RuntimeException("Not a letter or operator");
            }

        }
    }
}

/* Here is the main function to run the code. It also contains the routine needed to read the contents from
the file. It will also instantiate the methods needed to run the program. */
class RMullinsLab1{

    public static void main(String[] args)throws IOException{

        String fileNameOut,fileNameIn; 
        Scanner scanner =null;
        stackChar stringArray = new stackChar(8);
        stackChar reverseArray = new stackChar(8);
        
        try{
            scanner = new Scanner(System.in);
            System.out.print("Enter a file name for Output: ");
            fileNameOut = scanner.next();
            System.out.print("Enter a file name for Input: ");
            fileNameIn = scanner.next();
            
   
            postConvert test = new postConvert();
            fileTasks newFile = new fileTasks();

            newFile.createFile(fileNameOut);
            
            InputStream is = new FileInputStream(fileNameIn);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            int curr_char = 0;
    
            while ((curr_char = br.read()) != -1){
                
                if((char)(curr_char) != '\r' && (char)(curr_char) != '\n') {
                    stringArray.push((char)(curr_char));
                    test.convert(fileNameOut, (char)(curr_char));
                }
                else{
                    while(!stringArray.isEmpty()){
                        char letter = stringArray.pop();
                        reverseArray.push(letter);
                    }
                    while(!reverseArray.isEmpty()){
                        char letter = reverseArray.pop();
                        System.out.println(letter);
                        newFile.writeFile(fileNameOut, ""+letter);
                    }
                    newFile.writeFile(fileNameOut, "\n");
                    stringArray.clear();
                    test.count = 0;
                }
            }
            br.close();
    }
    catch (IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
        
    }
        if (scanner != null){
            scanner.close();
        }            
    }

}