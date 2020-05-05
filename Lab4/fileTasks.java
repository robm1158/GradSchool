package Lab4;

/* 
Author by Rob Mullins

fileTasks here contain methods to create a file and check to see if it exists already. 
It also contains the method to write to an output file */

import java.io.*;

public class fileTasks{
  // This method creates a file if the file does not exist. If it
  // exisits it will not create it.

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

    /*This method is used to write the contents to a file. Catches errors
    as needed.*/ 
    public void writeFile(String fileName, String intTowrite){

        try {
            FileWriter myWriter = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(intTowrite);
            bw.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }


}