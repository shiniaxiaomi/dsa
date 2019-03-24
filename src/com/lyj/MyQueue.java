package com.lyj;

/**
 * Created by Administrator on 2019/3/22.
 */
public interface MyQueue<T> {

    void add(T t) throws Exception;

    T offer() throws Exception;

    boolean isEmpty();

}
