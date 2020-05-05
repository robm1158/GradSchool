/*
Author by Rob Mullins

Bellow is a recursive solution to a heap sort. THe main driver 
being the heapify. Heapify impliments the max heap idea and brings
the largest to the top and takes it off to order it.
*/

package Lab4;

public class heapSort {

    // Impliments heapify and sorts out which way to call it
    // based off conditions.

    public void sort(int[] array){
        int len = array.length;

        for(int index = (len/2 - 1); index >= 0; index-- ){
            heapify(array,len,index);
        }
        for(int index = len-1; index > 0; index--){
            int temp = array[0];
            array[0] = array[index];
            array[index] = temp;
            heapify(array,index,0);
        }
    }

    // Impliments the max heap style method of heapify. This 
    // will check the root node with the leaves and makes sure its
    // biggest and takes it off to sort

    private void heapify(int array[], int size, int node){
        int largeNode = node;
        int left = 2*node + 1;
        int right = 2*node + 2;

        if(left < size && array[left] > array[largeNode]){
            largeNode = left;
        }

        if(right < size && array[right] > array[largeNode]){
            largeNode = right;
        }

        if(largeNode != node){
            int change = array[node];
            array[node] = array[largeNode];
            array[largeNode] = change;
            heapify(array, size, largeNode);
        }
    }



}