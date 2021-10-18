package com.example.ParallelFramework.parallelclasses;

import com.example.ParallelFramework.context.AbstractContext;
/*
@Author : Abhijeet Deshpande
THis interface has 4 defaults methods mocking crud operations.
Write your code with implementing these methods and just use call() method to run this in single instance
For parallel execution pass the concrete instance of this class to the Parallel Coordinator instance.
 */
public interface CustomExecutor {
    void initializeData(AbstractContext abstractContext);
    void commitData(AbstractContext abstractContext);
    void executeData(AbstractContext abstractContext);
    void backoutData(AbstractContext abstractContext);
}
