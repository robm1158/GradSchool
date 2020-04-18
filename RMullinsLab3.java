
import Lab3.*;


public class RMullinsLab3 {

    public static void main(String[] args)throws RuntimeException{
        Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);
        Lab3.genericStack gsEncodedData = new genericStack<Lab3.encodedData>(15);

        
        String fileName = "D:\\Code\\GradSchool\\Lab3\\FreqTable.txt";
        String encodedFile = "D:\\Code\\GradSchool\\Lab3\\Encoded.txt";

        Lab3.fileManipulation freqFiles = new Lab3.fileManipulation(fileName,gs);
        Lab3.fileManipulation encodeFiles = new Lab3.fileManipulation(encodedFile,gs);

        freqFiles.inputFileData();
        
        gs = freqFiles.sortData();


        Lab3.huffmanTree ht = new Lab3.huffmanTree(gs,gs.size(),fileName);
        ht.buildHuffmanTree();
        encodeFiles.inputEncodedData(gsEncodedData);
    }

}