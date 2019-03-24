package com.lyj;

/**
 * Created by Administrator on 2019/3/22.
 */
public interface MyStack<T> {

    void push(T t) throws Exception;

    T pop() throws Exception;

    boolean isEmpty();

}
