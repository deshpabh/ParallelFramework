package com.example.ParallelFramework.coordinator;

import com.example.ParallelFramework.parallelclasses.AbstractExecutor;

import java.util.List;

public class SerialCoordinator {
    public SerialCoordinator(List<AbstractExecutor> abstractExecutorList){

           abstractExecutorList.forEach(abstractExecutor -> {
               try{
                   abstractExecutor.call();
               }catch (Exception e){
                   e.printStackTrace();
               }
           });

    }
}
