// Rob Mullins
// THis class is a generall stack that will take any data type and place
// it in a stack representation.

package Lab3;

import java.util.EmptyStackException;

public class genericStack<T> extends Object{

    // Class vars

    private T[] container;
    private int top,maxSize,currSize;

    // Constructor to intialize the stack

    @SuppressWarnings("unchecked")
    public genericStack(int max){
        this.maxSize = max;
        this.container = (T[]) new Object[maxSize];
        this.top = -1;

    }

    // Adds items to the the stack and resizing the
    // stack as neeeded.

    public void push(T data){
        if(currSize >= maxSize){
            this.resize();
        }
        this.currSize++;
        this.container[++top] = data;

    }

    // Removes the element at the top of the stack

    public T pop() throws EmptyStackException{
        if( top < 0){
            throw new EmptyStackException();
        }
        else{
            T data = this.container[top--];
            return data;
        }

    }

    // utility function to resize the stack if it gets full
    // and something is trying to be pushed

    @SuppressWarnings("unchecked")
    private void resize(){
        T[] newStack = (T[]) new Object[this.maxSize*2];
        for(int index = 0; index < maxSize; index++){
            newStack[index] = this.container[index];
        }
        this.container = newStack;
        this.maxSize = this.maxSize*2;
    }

    // Gets the current size of stack

    public int size(){
        return this.top;
    }

    // Looks at the top of the stack with out removing it

    public T peek() {
        return container[top];
    }

    // Checks if stack is empty

    public boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        else{
            return false;
        }

    }


}