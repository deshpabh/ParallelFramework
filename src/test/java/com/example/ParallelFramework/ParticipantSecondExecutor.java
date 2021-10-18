package com.example.ParallelFramework;

import com.example.ParallelFramework.context.AbstractContext;
import com.example.ParallelFramework.parallelclasses.AbstractExecutor;

public class ParticipantSecondExecutor extends AbstractExecutor {


    public ParticipantSecondExecutor(AbstractContext abstractContext) {
        super(abstractContext);
    }

    @Override
    public void initializeData(AbstractContext abstractContext) {

    }

    @Override
    public void commitData(AbstractContext abstractContext) {

    }

    @Override
    public void executeData(AbstractContext abstractContext) {
        abstractContext.setResult((Integer)abstractContext.getResult()+1);
        System.out.println("In Second Result "+abstractContext.getResult());
    }

    @Override
    public void backoutData(AbstractContext abstractContext) {

    }
}
