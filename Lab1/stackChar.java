/*
Author by Rob Mullins

Bellow is a stack class. This class contains the methods to push, pop, resize, size, and 
isEmpty with the constructor. I will use this to hold the chars I parse from the input file.*/
public class stackChar{

    //Here we set our class vars to hold information
    private char[] container,copy;
    private int top, max_size, curr_size;

    //constructor for stackChar to intialize it
    public stackChar(int max){
        max_size = max;
        container = new char[max_size];
        top = -1;
    }

    //Basic push function to add values into the stack
    public void push(char value){
        if (curr_size >= max_size){
            System.out.println("System overflow resize stack");
            resize(max_size*2);
        }
        curr_size++;
        container[++top] = value;


    }

    //Basic pop function to remove values into the stack

    public char pop(){
        if (top >= 0){
            return(container[top--]);
        }
        else{
            throw new RuntimeException("Stack underflow!!");
        }
        
    }

    // Returns the size of the stack
    public int size(){
        return top;
    }
    
    //clears the entire stack
    public void clear(){
        for (int i = 0; i < top; i++)
            container[i] = (Character)null;
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

        copy = new char[new_size];
        for(int i = 0; i < curr_size; i++){
            copy[i] = container[i];
        }
        container = new char[new_size];
        container = copy;
        max_size = new_size;
    }

}