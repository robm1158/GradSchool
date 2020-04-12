
import Lab3.*;


public class RMullinsLab3 {

    public static void main(String[] args)throws RuntimeException{

        String fileName = "D:\\Code\\GradSchool\\Lab3\\FreqTable.txt";

        Lab3.fileRead files = new Lab3.fileRead(fileName);
        files.inputFileData();
        //files.print();
        
    }

}