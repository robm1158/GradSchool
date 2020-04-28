
// Rob Mullins
// This file is the main driver for reading in a freq table and sorting them,
// as well as encoding clear text files, and decoding alread encoded files.
import Lab3.*;
import java.util.Scanner;
import javax.management.RuntimeErrorException;


public class RMullinsLab3 {

    public static void main(String[] args)throws RuntimeException{
        Lab3.genericStack gs = new genericStack<Lab3.huffmanNode>(10);
        Lab3.genericStack gsEncodedData = new genericStack<Lab3.encodedData>(15);
        Lab3.genericStack dataArray = new genericStack<Lab3.encodedData>(10);
        Lab3.hashTable hasht = new hashTable();

        try{
            String fileName,encodedFile,decodedFile;

            // Below i read in file names for the freq table, binary
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a freq table: ");
            fileName = scanner.next();
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter a binary file: ");
            encodedFile = scanner2.next();
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Enter a clear text file: ");
            decodedFile = scanner3.next();

            // Here i will begin reading in the data from the files. I will begin by
            // reading in all the data and parsing it into a stack

            Lab3.fileManipulation freqFiles = new Lab3.fileManipulation(fileName,gs);
            Lab3.encodedFileManipulation encodeFiles = new Lab3.encodedFileManipulation(encodedFile,gsEncodedData);

            freqFiles.inputFileData();
            
            gs = freqFiles.sortData();

            // Below I will begin building the huffman tree from the read in freq table
            // I will also print the tree in pre-order traversal.

            Lab3.huffmanTree ht = new Lab3.huffmanTree(gs,gs.size(),fileName);
            Lab3.huffmanNode hn = new Lab3.huffmanNode();

            hn = ht.buildHuffmanTree();
            hasht = ht.getHashTable();
            ht.print(hn);

            // Below I will beigin reading in the encoded files and decode them back into clear text.

            Lab3.decodedFileManipulation decodedFiles = new Lab3.decodedFileManipulation(decodedFile, hasht);

            // Below I will start to read in the clear text and start to encode the data
            // based on the the freq table.

            Lab3.encodedData encodedDataArray = new Lab3.encodedData();
            dataArray = encodeFiles.inputEncodedData(gsEncodedData);

            while(dataArray.size() > -1){
                encodedDataArray.c =  (char[])dataArray.pop();
                encodeFiles.decodeData(encodedDataArray.c,hn);
                
            }

            decodedFiles.inputDecodedData();
            decodedFiles.convertToBinary();



        }
        // Catch eny errors from bad files
        catch(RuntimeException exception){
            System.out.println("File Does Not Exist");
            exception.printStackTrace();

        }
        
        

    }

}