/*
Author by Rob Mullins

Below is the main function that will impliment the recursive and
iter version of the TOH here we will also gather times to run an 
analysis these methods.
*/


import java.util.Scanner;

import javax.management.RuntimeErrorException;

import Lab2.*;


class RMullinsLab2{

    public static void main(String[] args)throws RuntimeException{

        String fileNameOut; 
        Scanner scanner = null;

        try{

            // below is how I create the files to gather my data based on user input
            // for file name
            scanner = new Scanner(System.in);
            System.out.print("Enter a file name for Output: ");
            fileNameOut = scanner.next();
            Scanner number = new Scanner(System.in);
            System.out.println("Enter a disk number to try: ");
            // Here we intialize the Number of disks you want to test
            int num = number.nextInt();
            Lab2.fileTasks newFile = new fileTasks();
            newFile.createFile(fileNameOut);
            Lab2.fileTasks write = new fileTasks();
            String dataRecFile = "dataRec"+fileNameOut;
            String dataIterFile = "dataIte"+fileNameOut;
            write.createFile(dataRecFile);
            write.createFile(dataIterFile);

            // I set the sum of the reucrsive and iterative times to 0
            // so that i can add them to one another later
            Long sumRecTime = (long)0, sumIterTime = (long)0;
            int index =0;

            // Make sure disk is > 0 as it wouldnt make sense otherwise
    
            if(num >=1){

                // Taking the sum average of 30 runs with N disks using the
                // recursive method
                for(index =0; index <30;index++){
                    Lab2.recursiveHanoi runRec = new recursiveHanoi();
                    Long singleRecTime = runRec.solve(num, 'A', 'C', 'B',fileNameOut);
                    sumRecTime = singleRecTime + sumRecTime;
                    write.writeFile(fileNameOut, "Total time was " + singleRecTime + "ns with " + num + " disks \n") ;
                    write.writeFile(dataRecFile, singleRecTime+"\n");
                }
                write.writeFile(fileNameOut, "Recursive avg time " + sumRecTime/index+ "ns\n\n\n") ;
                System.out.println("Recursive avg time " + sumRecTime/index + "\n");

                // Taking the sum average of 30 runs with N disks using the
                // iterative method
                int iter = 0;
                for(iter =0; iter <30;iter++){
                    Lab2.iterHanoi runIter = new iterHanoi(num,fileNameOut);
                    Long singleIterTime = runIter.solve(num);
                    sumIterTime = singleIterTime + sumIterTime;
                    write.writeFile(fileNameOut, "Total time was " + singleIterTime + "ns with " + num + " disks \n");
                    write.writeFile(dataIterFile, singleIterTime+"\n");
                }
                System.out.println("Iter avg time " + sumIterTime/iter+ "\n");
                write.writeFile(fileNameOut, "Iter avg time " + sumIterTime/iter + "ns\n") ;

            }
            // Error handeling below as well as managing files
            else{
                scanner.close();
                throw new RuntimeErrorException(null, "Must be > 1");
            }
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