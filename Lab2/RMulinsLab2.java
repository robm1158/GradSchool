/*
Author by Rob Mullins

Bellow is a stack class. This class contains the methods to push, pop, resize, size, and 
isEmpty with the constructor. I will use this to hold the ints I need to keep track of.
*/

package Lab2;
import java.io.*;
import java.util.Scanner;

class RMullinsLab2{

    public static void main(String[] args)throws IOException{
        recursiveHanoi test = new recursiveHanoi();
        iterHanoi testIter = new iterHanoi(3);
        testIter.solve(3);

    }

}