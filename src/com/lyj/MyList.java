package com.lyj;

/**
 * Created by Yingjie.Lu on 2019/3/22.
 */
public interface MyList<T> {

    void add(T o);

    T get(int index) throws Exception;

    T remove(int index) throws Exception;

    void print();

    T update(int index,T o) throws Exception;

    int size();

    boolean isEmpty();

}
