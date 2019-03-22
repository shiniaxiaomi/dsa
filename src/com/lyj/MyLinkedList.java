package com.lyj;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */

/**
 * 单向链表
 */
public class MyLinkedList<T> implements MyList<T> {

    Node firstNode=null;
    Node currentNode=null;
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
    public void add(T t) {
        Node node=new Node(t);

        if(size==0){
            firstNode=node;
            currentNode=node;
        }else{
            currentNode.nextNode=node;
            currentNode=node;
        }

        size++;
    }

    //index从0开始
    public Node getNode(int index) throws Exception {
        if(index>this.size){
            throw new Exception("索引已不在数据范围内");
        }

        if(index==0){
            return firstNode;
        }else{
            Node node=firstNode;
            for(int i=0;i<index;i++){
                node=node.nextNode;
            }
            return node;
        }
    }

    //index从0开始
    @Override
    public T get(int index) throws Exception {
        if(index>this.size){
            throw new Exception("索引已不在数据范围内");
        }

        Node node = getNode(index);

        return node.getData();
    }

    @Override
    public T remove(int index) throws Exception {
        if(index>this.size){
            throw new Exception("索引已不在数据范围内");
        }

        Node node = getNode(index-1);//获取要删除的节点的上一个节点
        Node removeNode = node.nextNode;
        node.nextNode=removeNode.nextNode;
        this.size--;

        return removeNode.getData();
    }

    @Override
    public void print() {
        StringBuilder sb=new StringBuilder("[");

        if(this.size==0){
            sb.append(firstNode.getData()+",");
        }else{
            Node node=firstNode;
            for(int i=0;i<this.size;i++){
                sb.append(node.getData()+",");
                node=node.nextNode;
            }
        }
        String s = sb.substring(0, sb.length() - 1);
        System.out.println(s+"]");
    }

    @Override
    public T update(int index, T o) throws Exception {
        if(index>this.size){
            throw new Exception("索引已不在数据范围内");
        }

        Node node = getNode(index);
        T buff=node.getData();
        node.setData(o);
        return buff;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }

    public static void main(String[] args) throws Exception {

        MyList myList=new MyLinkedList<Integer>();
        for(int i=0;i<10;i++){
            myList.add(i);
        }

        myList.print();
        System.out.println(myList.get(2));

        myList.remove(5);
        myList.print();

        myList.update(7,3);
        myList.print();

    }

}
