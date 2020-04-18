package Lab3;

import java.util.EmptyStackException;

public class genericStack<T> extends Object{

    private T[] container;
    private int top,maxSize,currSize;

    @SuppressWarnings("unchecked")
    public genericStack(int max){
        this.maxSize = max;
        this.container = (T[]) new Object[maxSize];
        this.top = -1;

    }

    public void push(T data){
        if(currSize >= maxSize){
            this.resize();
        }
        this.currSize++;
        this.container[++top] = data;

    }

    public T pop() throws EmptyStackException{
        if( top < 0){
            throw new EmptyStackException();
        }
        else{
            T data = this.container[top--];
            return data;
        }

    }

    @SuppressWarnings("unchecked")
    private void resize(){
        T[] newStack = (T[]) new Object[this.maxSize*2];
        for(int index = 0; index < maxSize; index++){
            newStack[index] = this.container[index];
        }
        this.container = newStack;
        this.maxSize = this.maxSize*2;
    }

   /* public void reverse(){
        T[] newStack = (T[]) new Object[this.maxSize];
        int count = 1;
        for(int index = currSize; index > 0; index--){
            newStack[index] = this.container[count++];
        }
        this.container = newStack;

    }*/

    public int size(){
        return this.top;
    }

    public T peek() {
        return container[top];
    }

    public boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        else{
            return false;
        }

    }


}