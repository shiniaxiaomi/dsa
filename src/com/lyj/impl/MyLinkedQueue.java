package com.lyj.impl;

import com.lyj.MyQueue;

/**
 * Created by Administrator on 2019/3/22.
 */
public class MyLinkedQueue<T> implements MyQueue<T> {

    Node firstNode;
    Node lastNode;
    int size=0;

    class Node{
        Node nextNode=null;//下一个节点
        T data;//节点的数据

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        Node(T t){
            this.data=t;
        }
    }

    @Override
    public void add(T t) throws Exception {
        Node node=new Node(t);
        if(size==0){
            firstNode=node;
            lastNode=node;
        }else{
            lastNode.nextNode=node;
            lastNode=node;
        }

        size++;
    }

    @Override
    public T offer() throws Exception {

        if(size==0){
            throw new Exception("队列已空");
        }

        T data = firstNode.getData();
        firstNode=firstNode.nextNode;
        size--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    public static void main(String[] args) throws Exception {
        MyQueue myQueue=new MyLinkedQueue<Integer>();

        for(int i=0;i<10;i++){
            myQueue.add(i);
        }

        for(int i=0;i<5;i++){
            System.out.println(myQueue.offer());
        }

        for(int i=10;i<15;i++){
            myQueue.add(i);
        }

        for(int i=0;i<10;i++){
            System.out.println(myQueue.offer());
        }


    }
}
