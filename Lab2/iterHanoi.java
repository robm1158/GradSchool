/*
Author by Rob Mullins

Below is the iter version of the TOH problem. Though more
involved than the recursive method, still not bad. Here we have
a few methods. The constructor intializes the three stacks
we will use through out. It also auto populates the source rod
from biggest on bottom to smallest on top. I intialize the 
rods to be small as the stack method can re-size on the fly.
The moveDisk method is used to move the actual disks from rod
to rod and push them to the perspective stacks. The solve method
is what impliments the moveDisk function. It also is what maintains
the logic of what goes where.
*/
package Lab2;
import java.lang.Math;

import javax.management.RuntimeErrorException;

public class iterHanoi{

    // Create private fields for the class to use
    private stackInt source = new stackInt(4);
    private stackInt desto = new stackInt(4);
    private stackInt spare = new stackInt(4);
    private Lab2.fileTasks write = new fileTasks();
    private Lab2.ticToc time = new ticToc();
    private Long sumWrite = (long)0, totalWrite = (long)0;
    private String fileName;

    public iterHanoi(int size, String fileNameOut) {
        fileName = fileNameOut;
        //initialize with bigger rods on first
        for (int iter = size; iter >= 1;iter--){
            source.push(iter);
        }

    }
    public void writeToScreen( char fromRod, char toRod, int disk){
        System.out.println("Move disk "+disk +  " from "+fromRod+" to "+toRod);
    }

    //This method will do the pushing of the disks to different rods

    public Long moveDisk(stackInt sour, stackInt dest, char so, char des){
        Long start = time.tic();

        
        int rodSoTop = sour.pop();
        int rodDesTop = dest.pop();

        if(rodSoTop == -1 && rodDesTop == -1){
            // Check to see if both are empty thus n= 0
            throw new RuntimeErrorException(null, "All rods are empty");
        }
        else{
        
            // Error checking for empty rods
            if( rodSoTop == -1){
                sour.push(rodDesTop);
                sumWrite = write.writeFile(fileName, "Move disk " + rodDesTop + 
                " from rod " +  des + " to rod " + so + "\n") + sumWrite;
            }
            // Error checking for empty rods
            else if(rodDesTop == -1){
                dest.push(rodSoTop);
                sumWrite = write.writeFile(fileName, "Move disk " + rodSoTop + 
                " from rod " +  so + " to rod " + des + "\n") + sumWrite;
            }
            // If source rod has a disk bigger than desto rod push
            else if(rodSoTop > rodDesTop){
                sour.push(rodSoTop);
                sour.push(rodDesTop);
                sumWrite = write.writeFile(fileName, "Move disk " + rodDesTop + 
                " from rod " +  des + " to rod " + so + "\n") + sumWrite;
            }
            // If desto rod has a top disk bigger than source rod push
            else if(rodSoTop < rodDesTop){
                dest.push(rodDesTop);
                dest.push(rodSoTop);
                sumWrite = write.writeFile(fileName, "Move disk " + rodSoTop + 
                " from rod " +  so + " to rod " + des + "\n") + sumWrite;
            }
            // Some off case that could break it
            else{
                throw new RuntimeErrorException(null, "Could not move rods");

            }
        }
        Long end = time.toc();
        return (end-start);
            
    }

    public Long solve(int num){
        // We know this to be true so I will use this to my advantage
        
        int totalMoves = (int)(Math.pow(2, num) - 1);

        // Using 's' for source, 'd' for destination and 'a' for aux(spare)
        char s = 'S', d = 'D', a = 'A',tmp;

        // Switch a and d if there are an even number of disks

        if(num % 2 == 0){
            tmp = d;
            d = a;
            a = tmp;
        }

        for(int index = 1; index <= totalMoves; index++){
            if(index%3 == 1){
                totalWrite = moveDisk(source,desto,s,d) + totalWrite;
            }
            else if(index%3 == 2){
                totalWrite = moveDisk(source, spare, s, a) + totalWrite;
            }
            else if(index%3 == 0){
                totalWrite = moveDisk(spare, desto, a, d) + totalWrite;
            }
            else{
                throw new RuntimeErrorException(null, "Could not move rods");
            }
        }
        totalWrite = (totalWrite - sumWrite);
        return totalWrite;

    }




}