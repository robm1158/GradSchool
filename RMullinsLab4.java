import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;

public class RMullinsLab4 {
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i]+" "); 
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
            Lab4.heapSort testing = new Lab4.heapSort();
            Lab4.quickSort testQuick = new Lab4.quickSort();
            Lab4.insertionSort testInset = new Lab4.insertionSort();
            
            for (File file : files) {
            
                String fileName = file.getName();
                Lab4.readData data = new Lab4.readData("testing.txt");

                int[] test = data.readInData();
                testQuick.medianSort(test, 0, test.length-1);

                printArray(test);
                System.out.println("-------------------");

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}