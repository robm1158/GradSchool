/* 
Author by Rob Mullins

This program takes in a txt file with postfix expressions. I will read them in and parse
them char by char evaluating each char. Depending on if it is an opperand or opperator.
If it is an apperand I will push the Letter to the stack class I made. If it is an opperator
I will follow certain rules laid out in the assignment to write commands to another file.*/

import java.io.*;
import java.util.Scanner;

/* Here is the main function to run the code. It also contains the routine needed to read the contents from
the file. It will also instantiate the methods needed to run the program. */
public class RMullinsLab1{

    public static void main(String[] args)throws IOException{

        String fileNameOut,fileNameIn; 
        Scanner scanner =null;
        stackChar stringArray = new stackChar(8);
        stackChar reverseArray = new stackChar(8);
        
        try{
            // Scanning and taking in input via terminal
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

            //Checking if file is empty
            //Reading the file in char by char
            while ((curr_char = br.read()) != -1){

                
                if((char)(curr_char) != '\r' && (char)(curr_char) != '\n') {
                    stringArray.push((char)(curr_char));
                    test.convert(fileNameOut, (char)(curr_char));
                }
                else{
                    char letter;
                    while(!stringArray.isEmpty()){
                        letter = stringArray.pop();
                        reverseArray.push(letter);
                    }
                    while(!reverseArray.isEmpty()){
                        letter = reverseArray.pop();
                        newFile.writeFile(fileNameOut, ""+letter);
                    }
                    newFile.writeFile(fileNameOut,"\n------------------------------\n");
                    stringArray.clear();
                    test.count = 0;
                }
            }
            if(curr_char == -1){
                System.out.println("Empty File/ Done reading file");
            }
            br.close();
    }
    catch (IOException e){

        //Throws excepting if some wierd file reading error occurs

        System.out.println("An error occurred.");
        e.printStackTrace();
        
    }
        if (scanner != null){
            scanner.close();
        }            
    }

}