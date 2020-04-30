import java.io.IOException;

public class RMullinsLab4 {
    public static void main(String[] args)throws RuntimeException{
        try{
            
            String fileName = "E:\\Maters\\DataStructures\\Module 13\\Lab4InputFiles-1\\Lab 4 Input Files\\asc50.dat";
            Lab4.readData data = new Lab4.readData(fileName);
            Lab4.createData genData = new Lab4.createData();
            genData.generateRandomData(1,9000,5000);
            genData.generateAscOrderedData(1, 5000);
            genData.generateDescOrderedData(1, 5000);
            genData.generateUniqueData(1,10000,5000);
            genData.orderUniqueData();
            genData.generateFiles();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}