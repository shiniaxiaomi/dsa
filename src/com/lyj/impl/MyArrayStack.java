package com.lyj.impl;

import com.lyj.MyStack;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */
public class MyArrayStack<T> implements MyStack<T> {

    int index=0;
    int size;
    T[] arr;

    MyArrayStack(int size){
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

        MyArrayStack myStack=new MyArrayStack(10);

        for(int i=0;i<10;i++){
            myStack.push(i);
        }

        for(int i=0;i<10;i++){
            System.out.println(myStack.pop());
        }

    }


}
