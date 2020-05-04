import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FilenameFilter;

public class RMullinsLab4 {

    public static void main(String[] args)throws RuntimeException{
        
        boolean creategen = false;
        if(creategen){
            Lab4.createData genData = new Lab4.createData();
            genData.generateRandomData(1,20000,20000);
            genData.generateAscOrderedData(1, 20000);
            genData.generateDescOrderedData(1, 20000);
            genData.generateUniqueData(1,30000,20000);
            genData.orderUniqueData();
            genData.generateFiles();

        }

        //https://www.boraji.com/java-how-to-list-txt-file-in-a-directory

		File directoryPath = new File("D:\\Code\\GradSchool\\");

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
            Lab4.ticToc timing = new Lab4.ticToc();
            ArrayList<Integer> standSortData = new ArrayList<Integer>();
            ArrayList<Integer> sort100Data = new ArrayList<Integer>();
            ArrayList<Integer> sort50Data = new ArrayList<Integer>();
            ArrayList<Integer> medianSortData = new ArrayList<Integer>();
            ArrayList<Integer> heapSortData = new ArrayList<Integer>();



            for (File file : files) {
                long time1 = 0,time2= 0,time3= 0,time4= 0,time5= 0;

                int count = 0;
                String fileName = file.getName();

                System.out.println("Standard Quick Sort\n");

                for(int i = 0; i < 100; i++){
                    long start = timing.tic();
                    
                    Lab4.readData data = new Lab4.readData(fileName);

                    int[] test = data.readInData();
                    testQuick.standardSort(test, 0, test.length-1);
                    long end = timing.tic();
                    long total = (end-start);
                    if(count != 0){
                        time1 = time1 + total;

                    }
                    count++;

                }
                standSortData.add((int) (time1 / count));
                System.out.println(fileName + ": " + time1/count+ " ns\n" );
                System.out.println("-------------------");

                System.out.println("Median of Three Quick Sort\n");
                count = 0;
                for(int i = 0; i < 100; i++){
                    long start = timing.tic();
                    
                    Lab4.readData data = new Lab4.readData(fileName);

                    int[] test = data.readInData();
                    testQuick.medianSort(test, 0, test.length-1);
                    long end = timing.tic();
                    long total = (end-start);
                    if(count != 0){
                        time2 = time2 + total;
                    }
                    count++;

                }
                medianSortData.add((int) (time2 / count));

                System.out.println(fileName + ": " + time2/count+ " ns\n" );
                System.out.println("-------------------");

                System.out.println("Insertion at 100 Quick Sort\n");
                count = 0;
                for(int i = 0; i < 100; i++){
                    long start = timing.tic();
                    
                    Lab4.readData data = new Lab4.readData(fileName);

                    int[] test = data.readInData();
                    testQuick.sort100(test, 0, test.length-1);
                    long end = timing.tic();
                    long total = (end-start);
                    if(count != 0){
                        time3 = time3 + total;
                    }
                    count++;

                }
                sort100Data.add((int) (time3 / count));

                System.out.println(fileName + ": " + time3/count+ " ns\n" );
                System.out.println("-------------------");

                System.out.println("Insertion at 50 Quick Sort\n");
                count = 0;
                for(int i = 0; i < 100; i++){
                    long start = timing.tic();
                    
                    Lab4.readData data = new Lab4.readData(fileName);

                    int[] test = data.readInData();
                    testQuick.sort50(test, 0, test.length-1);
                    long end = timing.tic();
                    long total = (end-start);
                    if(count != 0){
                        time4 = time4 + total;
                    }
                    count++;

                }
                sort50Data.add((int) (time4 / count));

                System.out.println(fileName + ": " + time4/count+ " ns\n" );
                System.out.println("-------------------");

                System.out.println("Heap Sort\n");
                count = 0;
                for(int i = 0; i < 100; i++){
                    long start = timing.tic();
                    
                    Lab4.readData data = new Lab4.readData(fileName);

                    int[] test = data.readInData();
                    testQuick.medianSort(test, 0, test.length-1);
                    long end = timing.tic();
                    long total = (end-start);
                    if(count != 0){
                        time5 = time5 + total;
                    }
                    count++;

                }
                heapSortData.add((int) (time5 / count));

                System.out.println(fileName + ": " + time5/count+ " ns\n" );
                System.out.println("-------------------");

                
            }
            Lab4.fileTasks fileWritting = new Lab4.fileTasks();
            fileWritting.createFile("Data.txt");
            fileWritting.writeFile("Data.txt", "Standard Quick Sort: ");

            for(int i = 0; i < standSortData.size(); i++){
                fileWritting.writeFile("Data.txt", standSortData.get(i)+",");
            }

            fileWritting.writeFile("Data.txt", "\n Insertion at 100 Quick Sort: ");

            for(int i = 0; i < sort100Data.size(); i++){
                fileWritting.writeFile("Data.txt", sort100Data.get(i)+",");
            }

            fileWritting.writeFile("Data.txt", "\n Insertion at 50 Quick Sort: ");

            for(int i = 0; i < sort50Data.size(); i++){
                fileWritting.writeFile("Data.txt", sort50Data.get(i)+",");
            }

            fileWritting.writeFile("Data.txt", "\n Median at Three Quick Sort: ");

            for(int i = 0; i < medianSortData.size(); i++){
                fileWritting.writeFile("Data.txt", medianSortData.get(i)+",");
            }

            fileWritting.writeFile("Data.txt", "\n Heap Sort: ");

            for(int i = 0; i < heapSortData.size(); i++){
                fileWritting.writeFile("Data.txt", heapSortData.get(i)+",");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}