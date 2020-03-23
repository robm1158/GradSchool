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

    public static void main(String[] args)throws IOException{
        Lab2.ticToc time = new ticToc();
        Lab2.recursiveHanoi test = new recursiveHanoi();
        Lab2.iterHanoi testIter = new iterHanoi(4);

        //Long lasTime,avgTime,totalTime = (long)0;
        Long start = time.tic();
        testIter.solve(4);
        Long end = time.toc();
        System.out.println(end-start);

    }

}