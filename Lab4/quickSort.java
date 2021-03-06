/*
Author by Rob Mullins

Bellow is the class that handles 4 different types of quick
sorts. A standard quick sort, one that uses insertion sort
once a partition is at 100 and another once it hits at least
50, and lastly one that uses the Median of Three method. All
Methods are implimented recursively.
*/

package Lab4;

import javafx.print.PrintColor;

public class quickSort {

    // Below is the method that recursively impliments the
    // standard quick sort by using the first elemnt as the 
    // initial partition. 

    public void standardSort(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array,low,high);
            standardSort(array,low,pi-1);
            standardSort(array, pi+1,high);
        }
    }
    // Below is the method that recursively impliments the
    // standard quick sort and insertion sort at partition
    // at 100 by using the first elemnt as the 
    // initial partition. 
    public void sort100(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array,low,high);
            if (((pi-1) - low <= 100) || (high - (pi +1) >= 100)){
                Lab4.insertionSort finishSort = new insertionSort();
                finishSort.sort(array);
            }
            else{
                sort100(array,low,pi-1);
                sort100(array, pi+1,high);
            }

        }
    }
    // Below is the method that recursively impliments the
    // standard quick sort and insertion sort at partition
    // at 50 by using the first elemnt as the 
    // initial partition. 

    public void sort50(int[] array, int low, int high){
        if(low < high){
            int pi = partition(array,low,high);
            if (((pi-1) - low <= 50) || (high - (pi +1) >= 50)){
                Lab4.insertionSort finishSort = new insertionSort();
                finishSort.sort(array);
            }
            else{
                sort50(array,low,pi-1);
                sort50(array, pi+1,high);
            } 

        }
    }
    // Below is the method that recursively impliments the
    // standard quick sort using the Median of Three method
    // to determine the intial partition.

    public void medianSort(int[] array, int low, int high){
        setMedian(array);

        if(low < high){
            int pi = partition(array,low,high);
            standardSort(array,low,pi-1);
            standardSort(array, pi+1,high);
        }

    }

    // This function impliments the logic to swap the calculated
    // median from the intial, end, and middle of the data array.
    // then sorts the three and chooses the middle number.
    // it then swaps the chosen number with the first digit in the 
    // original array.

    private void setMedian(int[] array){
        int len = array.length;
        int median = Math.round(len/2);
        int first = array[0];
        int middle = array[median];
        int end = array[len-1];
        int[] temp = new int[3];
        temp[0] = first;
        temp[1] = middle;
        temp[2] = end;
        Lab4.insertionSort finishSort = new insertionSort();
        finishSort.sort(temp);

        int hold = array[0];
        array[0] = temp[1];

        if(temp[1] == middle){
            array[median] = hold;
        }
        else if(temp[1] == end){
            array[len-1] = hold;
        }
    }

    // Method that uses the pivot to begin partitioning the 
    // given array. This places all the lower numbers on the
    // left sidde and higher numbers on the right.

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