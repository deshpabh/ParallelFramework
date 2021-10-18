package com.example.ParallelFramework.context;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

/****
 * This class is like a model object to send data across multiple processes.
    Here I have kept the data as generic meaning you can store any data in here.
    Create your user defined context with extending this context and you will get all the methods present here.
    You can override any method if you need to add any encapsulation or validation.
 ***/
public class AbstractContext<T> implements Serializable {

    protected List<T> dataList;
    protected T data;
    protected Future future;
    protected List<Future> futureList;
    protected Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Future getFuture() {
        return future;
    }

    public void setFuture(Future future) {
        this.future = future;
    }

    public List<Future> getFutureList() {
        return futureList;
    }

    public void setFutureList(List<Future> futureList) {
        this.futureList = futureList;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
