

/*
Author by Rob Mullins

Bellow is a stack class. This class contains the methods to push, pop, resize, size, and 
isEmpty with the constructor. I will use this to hold the ints I need to keep track of.
*/

package Lab2;

public class stackInt{

    //Here we set our class vars to hold information
    private int[] container,copy;
    private int top, max_size, curr_size;

    //constructor for stackInt to intialize it
    public stackInt(int max){
        max_size = max;
        container = new int[max_size];
        top = -1;
    }

    //Basic push function to add values into the stack
    public void push(int value){
        if (curr_size >= max_size){
            resize(max_size*2);
        }
        curr_size++;
        container[++top] = value;
    }

    //Basic pop function to remove values into the stack.
    //I rely on the -1 for later use so I do not throw an error here

    public int pop(){
        if (top >= 0){
            return(container[top--]);
        }
        else{
            return(-1);
        }
        
    }

    // Returns the size of the stack
    public int size(){
        return top;
    }
    
    //clears the entire stack
    public void clear(){
        for (int i = 0; i < top; i++)
            container[i] = (Integer)null;
        top = -1;
    }

    //Checks if the stack is empty
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        else{
            return false;
        }
    }

    //private function to resize the intially allocated stack so that we dont get over_flows
    private void resize(int new_size){

        copy = new int[new_size];
        for(int i = 0; i < curr_size; i++){
            copy[i] = container[i];
        }
        container = new int[new_size];
        container = copy;
        max_size = new_size;
    }

}