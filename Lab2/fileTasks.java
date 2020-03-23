package Lab2;

/* 
Author by Rob Mullins

fileTasks here contain methods to create a file and check to see if it exists already. 
It also contains the method to write to an output file */

import java.io.*;

public class fileTasks{
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
    public Long writeFile(String fileName, String stringToWrite){
        Lab2.ticToc time = new ticToc();

        try {
            Long start = time.tic();
            FileWriter myWriter = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(stringToWrite);
            bw.close();
            Long end = time.toc();
            return (end-start);
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return (long)0;
          }
    }


}