package com.example.ParallelFramework.parallelclasses;

import com.example.ParallelFramework.context.AbstractContext;

import java.util.concurrent.Callable;

/****
 * @Author Abhijeet Deshpande
 * This class particularly has 4 methods intializa, execute, commit and backout. Which will be called through call method.
 * These executors will be having ExecutorFramework support.
 *
 * If you want to execute single executor, you can just call the call() method and all the 4 methods will be executed
 */
public abstract class AbstractExecutor implements CustomExecutor, Callable<AbstractContext> {

    public AbstractContext abstractContext = null;
    public AbstractExecutor(AbstractContext abstractContext){
        this.abstractContext=abstractContext;
    }

    @Override
    public AbstractContext call() throws Exception {
        initializeData(abstractContext);
        executeData(abstractContext);
        commitData(abstractContext);
        backoutData(abstractContext);
        return abstractContext;
    }

}
