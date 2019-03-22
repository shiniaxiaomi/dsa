package com.lyj;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */
public class MyArrayList<T> implements MyList<T> {

    private int length=0;//记录数据的长度
    private int max=10;//数组的最大值
    private T[] arr;

    MyArrayList(){
        this.arr= (T[]) new Object[this.max];
    }

    @Override
    public void add(T o) {
        //自动扩容
        if(length>this.max-1){
            this.max=2*this.max;
            T[] buff=arr;
            arr=(T[]) new Object[this.max];
            for(int i=0;i<buff.length;i++){
                arr[i]=buff[i];
            }
        }

        arr[length]=o;
        length++;
    }

    //index从0开始
    @Override
    public T get(int index) throws Exception {
        if(index>this.length){
            throw new Exception("索引已不在数据范围内");
        }
        return this.arr[index-1];
    }

    //index从0开始
    @Override
    public T remove(int index) throws Exception {
        if(isEmpty()){
            throw new Exception("数组中已无数据");
        }

        if(index>this.length){
            throw new Exception("索引已不在数据范围内");
        }
        T buff=this.arr[index-1];

        for(int i=index;i<this.length-1;i++){
            arr[i]=arr[i+1];
        }
        this.length--;
        return buff;
    }

    @Override
    public void print() {
        StringBuilder sb=new StringBuilder("[");
        for(int i=0;i<this.length;i++){
            sb.append(arr[i]+",");
        }
        String s = sb.substring(0, sb.length() - 1);
        System.out.println(s+"]");
    }

    @Override
    public T update(int index, T o) throws Exception {
        if(index>this.length){
            throw new Exception("索引已不在数据范围内");
        }
        T buff=arr[index];
        arr[index]=o;
        return buff;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length<=0;
    }


    public static void main(String[] args) throws Exception {
        MyList myList=new MyArrayList<Integer>();
        for(int i=0;i<10;i++){
            myList.add(i);
        }
        myList.print();

        System.out.println(myList.get(2));

        myList.remove(4);
        System.out.println(myList.size());
        myList.print();

        myList.update(6,8);
        myList.print();


    }


}
