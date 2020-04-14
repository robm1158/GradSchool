
import Lab3.*;


public class RMullinsLab3 {

    public static void main(String[] args)throws RuntimeException{

        String fileName = "D:\\Code\\GradSchool\\Lab3\\FreqTable.txt";

        Lab3.fileManipulation files = new Lab3.fileManipulation(fileName);
        files.inputFileData();
        
        files.sortData();
        files.print();
    }

}