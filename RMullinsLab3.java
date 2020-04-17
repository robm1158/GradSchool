
import Lab3.*;


public class RMullinsLab3 {

    public static void main(String[] args)throws RuntimeException{
        Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);
        
        String fileName = "D:\\Code\\GradSchool\\Lab3\\FreqTable.txt";

        Lab3.fileManipulation files = new Lab3.fileManipulation(fileName,gs);
        files.inputFileData();
        
        gs = files.sortData();
        //files.print();
        Lab3.huffmanTree ht = new Lab3.huffmanTree(gs,gs.size(),fileName);
        ht.buildHuffmanTree();
    }

}