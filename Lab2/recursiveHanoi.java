/*
Author by Rob Mullins

Below is the recursive implimentation of the TOH problem.
Here the base case is of course when the number of disks gets to 1
we continue to move the rods back and forth recursively
*/
package Lab2;

public class recursiveHanoi{
    
    public void solve(int num, char fromRod, char toRod, char spareRod){
        //Here we have the base case where you just move it once.

        if(num == 1){
            System.out.println("Move disk 1 from rod " +  fromRod + " to rod " + toRod);
        }
        else{
            // Here we will recursively call the solve function to go down
            // from here it will count down the disks
            solve(num-1, fromRod, spareRod,toRod);
            solve(num-1, spareRod, toRod, fromRod); 

        }

    }

}