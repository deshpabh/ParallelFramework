package com.example.ParallelFramework.parallelclasses;

import com.example.ParallelFramework.context.AbstractContext;

public interface CustomExecutor {
    void initializeData(AbstractContext abstractContext);
    void commitData(AbstractContext abstractContext);
    void executeData(AbstractContext abstractContext);
    void backoutData(AbstractContext abstractContext);
}
