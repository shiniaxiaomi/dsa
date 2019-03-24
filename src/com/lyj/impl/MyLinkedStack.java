package com.lyj.impl;

import com.lyj.MyStack;

/**
 * Created by Administrator on 2019/3/22.
 */
public class MyLinkedStack<T> implements MyStack<T> {


    Node firstNode=null;
    Node lastNode=null;

    int size=0;

    class Node{
        Node nextNode=null;
        T data;

        public T getData() {
            return data;
        }

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void push(T t) throws Exception {
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
    public T pop() throws Exception {
        if(size==0){
            throw new Exception("元素为空！");
        }
        T data = firstNode.getData();
        firstNode=firstNode.nextNode;
        size--;

        return data;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack=new MyLinkedStack<Integer>();

        for(int i=0;i<10;i++){
            myStack.push(i);
        }

        for(int i=0;i<5;i++){
            System.out.println(myStack.pop());
        }

        for(int i=10;i<15;i++){
            myStack.push(i);
        }


        for(int i=0;i<10;i++){
            System.out.println(myStack.pop());
        }

    }

}
