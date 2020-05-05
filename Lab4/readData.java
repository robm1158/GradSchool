/*
Author by Rob Mullins

Bellow is a class to read the data in from a file given.
It then places the data one by one into an int[] array.
Once this is done it returns the array of read in data.

*/

package Lab4;

import java.io.*;
import java.util.Scanner;

public class readData {
    // Below is the intital global class vars along with the
    // constructor to set the file name.
    File fileName;

    public readData(String file){
        fileName = new File(file);
    }

    // Main method to read in data from the filename placed
    // from constructor. It reads in int by int and puts it in
    // an int[] array. Returns the int array. Catches errors
    // from reading in files.

    public int[] readInData() throws Exception{
        BufferedReader br2 = new BufferedReader(new FileReader(fileName));
        int total = 0;
        String st2;
        while ((st2 = br2.readLine()) != null){
            total++;
        }

        int[] array = new int[total];
        BufferedReader br = new BufferedReader(new FileReader(fileName)); 
        
        String st;
        int count = 0;
        while ((st = br.readLine()) != null){
            array[count] = Integer.parseInt(st);
            count++;
        }
        br.close();
        return array;
        
    }
}