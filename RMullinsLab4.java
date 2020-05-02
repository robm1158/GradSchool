import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;

public class RMullinsLab4 {
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }

    public static void main(String[] args)throws RuntimeException{

        //https://www.boraji.com/java-how-to-list-txt-file-in-a-directory

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
                //System.out.println(file.getName());
            
                String fileName = file.getName();
                Lab4.readData data = new Lab4.readData("randUniq50.txt");
                Lab4.heapSort testing = new Lab4.heapSort();
                Lab4.quickSort testQuick = new Lab4.quickSort();
                int[] test = data.readInData();
                testQuick.sort(test, 0, test.length-1);
                //testing.sort(test);
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