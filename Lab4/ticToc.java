/*
Author by Rob Mullins

Bellow is a timeing class. We have two methods tic and toc
(names copied from Matlab timing function). These methods take the time
in nano second. I use tic to take the start time and toc to take the end
time.
*/

package Lab4;

public class ticToc {

    public Long tic(){
        long startTime = System.nanoTime();
        return startTime;
    }

    public Long toc() {
        long endTime = System.nanoTime();
        return endTime;
    }
}