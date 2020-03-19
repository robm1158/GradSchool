package Lab2;
import java.io.*;
import java.util.Scanner;



class RMullinsLab2{

    public static void main(String[] args)throws IOException{
        recursiveHanoi test = new recursiveHanoi();
        ticTok time = new ticTok();
        Long start = time.tic();
        test.solve(20, 'A', 'C', 'B');
        Long end = time.toc();
        System.out.println(end-start);

    }




}