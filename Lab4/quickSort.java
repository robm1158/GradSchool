package Lab4;

public class quickSort {

    public void sort(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array,low,high);
            // if (low - (pi-1) <= 100)
            sort(array,low,pi-1);
            sort(array, pi+1,high);
        }
    }

    private int partition(int[] array, int low, int high){
        int pivot = array[low];
        int index = high;

        for(int j = high; j > low; j--){
            if(array[j] > pivot){

                int temp = array[index];
                array[index] = array[j];
                array[j] = temp;
                index--;

            }
        }

        int temp2 = array[index];
        array[index] = array[low];
        array[low] = temp2;

        return index;

    }
}