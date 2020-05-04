package Lab4;

public class insertionSort {

    public void sort(int[] array){

        int len = array.length;
        for(int index = 1; index < len; index++){
            int key = array[index];
            int j = index - 1;

            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j = j-1;
            }
            array[j + 1] = key;

        }

    }
    
}