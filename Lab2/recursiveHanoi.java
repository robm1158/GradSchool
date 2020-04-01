/*
Author by Rob Mullins

Below is the recursive implimentation of the TOH problem.
Here the base case is of course when the number of disks gets to 1
we continue to move the rods back and forth recursively
*/
package Lab2;

public class recursiveHanoi{
    private Lab2.fileTasks write = new fileTasks();
    private Long writeTime = (long)0;
    
    public Long solve(int num, char fromRod, char toRod, char spareRod, String fileName){
        //Here we have the base case where you just move it once.
        Lab2.ticToc time = new ticToc();
        
        Long start = time.tic();
        if(num == 1){
            // Adding up the time it takes to write to file to subtract later
            writeTime = write.writeFile(fileName, "Move disk 1 from rod " +  fromRod + " to rod " + toRod + "\n") + writeTime;
        }
        else{
            // Here we will recursively call the solve function to go down
            // from here it will count down the disks
            solve(num-1, fromRod, spareRod,toRod,fileName);
            writeTime = (write.writeFile(fileName, "Move disk " + num + " from rod " +  fromRod + " to rod " + toRod + "\n")) + writeTime;
            solve(num-1, spareRod, toRod, fromRod,fileName); 

        }
        Long end = time.toc();
        Long total = (end - start) - (writeTime);
        return total;

    }

}