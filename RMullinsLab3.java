
import Lab3.*;


public class RMullinsLab3 {

    public static void main(String[] args)throws RuntimeException{
        Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);
        Lab3.genericStack gsEncodedData = new genericStack<Lab3.encodedData>(15);
        Lab3.genericStack dataArray = new genericStack<Lab3.encodedData>(10);
        Lab3.hashTable hasht = new hashTable();

        
        String fileName = "D:\\Code\\GradSchool\\Lab3\\FreqTable.txt";
        String encodedFile = "D:\\Code\\GradSchool\\Lab3\\Encoded.txt";
        String decodedFile = "D:\\Code\\GradSchool\\Lab3\\ClearText.txt";

        Lab3.fileManipulation freqFiles = new Lab3.fileManipulation(fileName,gs);
        Lab3.encodedFileManipulation encodeFiles = new Lab3.encodedFileManipulation(encodedFile,gsEncodedData);

        freqFiles.inputFileData();
        
        gs = freqFiles.sortData();


        Lab3.huffmanTree ht = new Lab3.huffmanTree(gs,gs.size(),fileName);
        Lab3.huffmanNode hn = new Lab3.huffmanNode();

        hn = ht.buildHuffmanTree();
        hasht = ht.getHashTable();

        Lab3.decodedFileManipulation decodedFiles = new Lab3.decodedFileManipulation(decodedFile, hasht);

        decodedFiles.inputDecodedData();
        decodedFiles.convertToBinary();

        // Lab3.encodedData encodedDataArray = new Lab3.encodedData();
        // dataArray = encodeFiles.inputEncodedData(gsEncodedData);

        // while(dataArray.size() > -1){
        //     encodedDataArray.c =  (char[])dataArray.pop();
        //     encodeFiles.decodeData(encodedDataArray.c,hn);
            
        // }

    }

}