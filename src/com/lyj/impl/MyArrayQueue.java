package com.lyj.impl;

import com.lyj.MyQueue;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */
public class MyArrayQueue<T> implements MyQueue<T>{

    int firstIndex=0;
    int lastIndex=0;
    int size=0;
    int maxSize=0;
    T[] arr;

    MyArrayQueue(int size){
        arr= (T[]) new Object[size];
        this.maxSize=size;
    }

    public void add(T t) throws Exception {
        if(size==maxSize){
            throw new Exception("队列已满！");
        }

        if(lastIndex<maxSize){
            arr[lastIndex]=t;
        }else{
            arr[(lastIndex+1)%maxSize]=t;
        }

        lastIndex=(lastIndex+1)%maxSize;
        size++;
    }

    public T offer() throws Exception {
        if(size==0){
            throw new Exception("队列已空！");
        }

        T buff = arr[firstIndex];
        firstIndex=(firstIndex+1)%maxSize;
        size--;
        return buff;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }


    public static void main(String[] args) throws Exception {

        MyArrayQueue myQueue=new MyArrayQueue(10);

        for(int i=0;i<7;i++){
            myQueue.add(i);
        }

        for(int i=0;i<3;i++){
            System.out.println(myQueue.offer());
        }


        for(int i=0;i<6;i++){
            myQueue.add(i);
        }

        for(int i=0;i<10;i++){
            System.out.println(myQueue.offer());
        }

    }



}
