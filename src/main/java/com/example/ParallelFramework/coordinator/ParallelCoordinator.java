package com.example.ParallelFramework.coordinator;

import com.example.ParallelFramework.context.AbstractContext;
import com.example.ParallelFramework.context.ExecutorType;
import com.example.ParallelFramework.parallelclasses.AbstractExecutor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author : Abhijeet Deshpande
 *
 * This class takes parameter as concrete implementations of AbstractExecutors
 * Create a constructor where you want to give the type of executor you want to invoke.
 *
 * If there are multiple executors which you want to execute parallely call the executeTaskParallely method which will return result of Future from all task
 * executors.
 */
public class ParallelCoordinator {
    ExecutorService executor=null;
    public ParallelCoordinator(ExecutorType executorType) {
        switch (executorType) {
            case SINGLE_THREAD:
                executor = Executors.newSingleThreadExecutor();
                break;
            case FIXED_THREAD_POOL:
                executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
                break;
            case CACHED_THREAD_POOL:
                executor = Executors.newCachedThreadPool();
        }
    }

    public List<Future<AbstractContext>> executeTasksParallely(List<AbstractExecutor> abstractContextList) throws InterruptedException {
      return executor.invokeAll(abstractContextList);
    }

}
