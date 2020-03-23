/*
Author by Rob Mullins

Below is the main function that will impliment the recursive and
iter version of the TOH here we will also gather times to run an 
analysis these methods.
*/

//package Lab2;
import java.io.*;
import java.util.Scanner;
import Lab2.*;


class RMullinsLab2{

    public static void main(String[] args)throws RuntimeException{

        String fileNameOut; 
        Scanner scanner = null;

        try{
            scanner = new Scanner(System.in);
            System.out.print("Enter a file name for Output: ");
            fileNameOut = scanner.next();
            Lab2.fileTasks newFile = new fileTasks();
            newFile.createFile(fileNameOut);
            Lab2.fileTasks write = new fileTasks();


            Long sumRecTime = (long)0, sumIterTime = (long)0;
            int index =0;
            for(index =0; index <30;index++){
                Lab2.recursiveHanoi runRec = new recursiveHanoi();
                Long singleRecTime = runRec.solve(3, 'A', 'C', 'B',fileNameOut);
                sumRecTime = singleRecTime + sumRecTime;
                write.writeFile(fileNameOut, "Total time was " + singleRecTime + "ns with " + 4 + " disks \n") ;
            }
            write.writeFile(fileNameOut, "Recursive avg time " + sumRecTime/index+ "ns\n\n\n") ;
            System.out.println("Recursive avg time " + sumRecTime/index + "ns\n\n\n");

            int iter = 0;
            for(iter =0; iter <30;iter++){
                Lab2.iterHanoi runIter = new iterHanoi(4,fileNameOut);
                Long singleIterTime = runIter.solve(3);
                sumIterTime = singleIterTime + sumIterTime;
                write.writeFile(fileNameOut, "Total time was " + singleIterTime + "ns with " + 4 + " disks \n") ;
            }
            System.out.println("Iter hanoi time " + sumIterTime/iter);
            write.writeFile(fileNameOut, "Iter avg time " + sumIterTime/iter + "ns\n\n\n") ;


        }
        catch(RuntimeException exception){
            System.out.println("An error occurred.");
            exception.printStackTrace();

        }
        
        if (scanner != null){
            scanner.close();
        }

    }

}