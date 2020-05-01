
package Lab4;

import java.util.*;
import java.io.*;

public class createData{
    long seed = System.currentTimeMillis();
    private Random random = new Random(seed);
    private HashSet<Integer> classUniqueSet = new HashSet<Integer>();
    private ArrayList<Integer> classRandomSet = new ArrayList<Integer>();
    private ArrayList<Integer> classAscSet = new ArrayList<Integer>();
    private ArrayList<Integer> classDescSet = new ArrayList<Integer>();
    private List<Integer> orderList = new ArrayList<Integer>(); 

    public void generateRandomData(int min, int max, int size){
        ArrayList<Integer> set = new ArrayList<Integer>(size);

        int count = 0;

        while(count < size){
            int x = (random.nextInt(max - min) + min);

            set.add(x);
            count++;
        }
        //List<String> list = new ArrayList<String>(set); 
        classRandomSet = set;
    }

    public void generateAscOrderedData(int min, int max){
        ArrayList<Integer> set = new ArrayList<Integer>(max);

        for(int index = min; index <= max; index++){
            set.add(index);
        }
        classAscSet = set;
    }

    public void generateDescOrderedData(int min, int max){
        ArrayList<Integer> set = new ArrayList<Integer>(max);

        for(int index = max; index >= min; index--){
            set.add(index);
        }
        classDescSet = set;
    }

    // Inspired by http://www.instanceofjava.com/2016/08/random-number-generator-java-range.html
    public void generateUniqueData(int min, int max, int size){
        HashSet set = new HashSet<Integer>(size);

        while(set.size()<size){
            while(set.add(random.nextInt(max - min)+min) != true){
               // System.out.println(set);
            }
        }
        assert set.size() == size;
        //System.out.println(set);
        classUniqueSet = set;

    }
    public void orderUniqueData(){
        List<Integer> list = new ArrayList<Integer>(classUniqueSet); 
        Collections.sort(list);
        orderList = list;

    }

    public void printAllData(){
        System.out.println(classAscSet);
        System.out.println(classDescSet);
        System.out.println(classRandomSet);
        System.out.println(classUniqueSet);
        System.out.println(orderList);

    }

    public void generateFiles(){
        if(!classAscSet.isEmpty()){
            String fileName = "asc" + classAscSet.size() + ".txt";
            try {
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(fileName);
                for(int index = 0; index < classAscSet.size(); index++){
                    String data = Integer.toString(classAscSet.get(index));
                    myWriter.write(data+"\n");
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
        }
        if(!classDescSet.isEmpty()){
            String fileName = "desc" + classAscSet.size() + ".txt";

            try {
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(fileName);
                for(int index = 0; index < classDescSet.size(); index++){
                    String data = Integer.toString(classDescSet.get(index));
                    myWriter.write(data+"\n");
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }


        }
        if(!classRandomSet.isEmpty()){
            String fileName = "rand" + classAscSet.size() + ".txt";

            try {
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(fileName);
                for(int index = 0; index < classRandomSet.size(); index++){
                    String data = Integer.toString(classRandomSet.get(index));
                    myWriter.write(data+"\n");
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        if(!classUniqueSet.isEmpty()){
            String fileName = "randUniq" + classAscSet.size() + ".txt";

            try {
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(fileName);
                Iterator<Integer> i = classUniqueSet.iterator();

                while(i.hasNext()){                    
                    String data = Integer.toString(i.next());
                    myWriter.write(data+"\n");
                }  
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
  
        }
        if(!orderList.isEmpty()){
            String fileName = "orderedRand" + classAscSet.size() + ".txt";

            
            try {
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                  System.out.println("File created: " + myObj.getName());
                } else {
                  System.out.println("File already exists.");
                }
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            try {
                FileWriter myWriter = new FileWriter(fileName);

                for(int index = 0; index < orderList.size(); index++){
                    String data = Integer.toString(orderList.get(index));
                    myWriter.write(data+"\n");
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } 
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }

}