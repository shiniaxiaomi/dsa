package com.lyj;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */
public class MyStack<T> {

    int index=0;
    int size;
    T[] arr;

    MyStack(int size){
        arr= (T[]) new Object[size];
        this.size=size;
    }


    public void push(T t) throws Exception {
        if(index>=size){
            throw new Exception("栈溢出");
        }

        arr[index]=t;
        index++;
    }

    public T pop() throws Exception {
        if(index==0){
            throw new Exception("栈中已没有数据");
        }

        return arr[--index];
    }

    public boolean isEmpty(){
        return index==0;
    }


    public static void main(String[] args) throws Exception {

        MyStack myStack=new MyStack(10);

        for(int i=0;i<10;i++){
            myStack.push(i);
        }

        for(int i=0;i<10;i++){
            System.out.println(myStack.pop());
        }

    }


}
