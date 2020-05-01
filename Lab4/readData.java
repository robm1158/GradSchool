package Lab4;
import java.io.*;
import java.util.Scanner;

public class readData {
    
    File fileName;

    public readData(String file){
        fileName = new File(file);
    }

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