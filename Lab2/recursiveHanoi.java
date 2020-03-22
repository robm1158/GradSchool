/*
Author by Rob Mullins

Bellow is a stack class. This class contains the methods to push, pop, resize, size, and 
isEmpty with the constructor. I will use this to hold the ints I need to keep track of.
*/

package Lab2;

public class recursiveHanoi{
    

    public void solve(int num, char fromRod, char toRod, char spareRod){
        //Here we have the base case where you just move it once.

        if(num == 1){
            System.out.println("Move disk 1 from rod " +  fromRod + " to rod " + toRod);
        }
        else{
            solve(num-1, fromRod, spareRod,toRod);
           // System.out.println("Move disk " + num + " from rod " +  fromRod + " to rod " + toRod); 
            solve(num-1, spareRod, toRod, fromRod); 

        }


    }

}