package Lab2;
import java.io.*;
import java.util.Scanner;



class RMullinsLab2{

    public static void main(String[] args)throws IOException{
        recursiveHanoi test = new recursiveHanoi();
        ticTok time = new ticTok();
        int index =0;
        Long lasTime,avgTime,totalTime = (long)0;
        for(index =0; index <30;index++){
            System.out.println(index);
            Long start = time.tic();
            test.solve(4, 'A', 'C', 'B');
            lasTime = (time.toc()-start);
            System.out.println("time for this run "+lasTime);
            System.out.println("total time "+totalTime);
            totalTime = (totalTime + lasTime);
        }
        avgTime = totalTime/index;
        System.out.println("Total avg time: "+avgTime);
        Long start = time.tic();
        test.solve(4, 'A', 'C', 'B');
        System.out.println("Single run time "+(time.toc()-start));
    }




}