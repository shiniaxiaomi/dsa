package com.lyj;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */
public class MyQueue<T> {

    boolean isFull=false;//标记是否已满

    int firstIndex=0;
    int lastIndex=0;
    int size=0;
    int maxSize=0;
    T[] arr;

    MyQueue(int size){
        arr= (T[]) new Object[size];
        this.maxSize=size;
    }

    public void add(T t){

    }

    public T offer(){
        size--;
        return arr[--firstIndex];
    }




}
