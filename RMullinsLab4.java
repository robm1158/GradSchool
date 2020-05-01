import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;

public class RMullinsLab4 {
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }


    public static void main(String[] args)throws RuntimeException{

		File directoryPath = new File("D:\\Code\\GradSchool\\");

		System.out.println("\n------------Text files------------");
		File[] files=directoryPath.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		


        try{
            for (File file : files) {
                System.out.println(file.getName());
            
                String fileName = file.getName();
                //"E:\\Maters\\DataStructures\\Module 13\\Lab4InputFiles-1\\Lab 4 Input Files\\asc50.dat";
                Lab4.readData data = new Lab4.readData(fileName);
                Lab4.heapSort testing = new Lab4.heapSort();
                int[] test = data.readInData();
                testing.sort(test);
                printArray(test);

                // Lab4.createData genData = new Lab4.createData();
                // genData.generateRandomData(1,9000,5000);
                // genData.generateAscOrderedData(1, 5000);
                // genData.generateDescOrderedData(1, 5000);
                // genData.generateUniqueData(1,10000,5000);
                // genData.orderUniqueData();
                // genData.generateFiles();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}