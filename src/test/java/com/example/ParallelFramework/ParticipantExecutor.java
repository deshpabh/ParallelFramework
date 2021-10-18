package com.example.ParallelFramework;

import com.example.ParallelFramework.context.AbstractContext;
import com.example.ParallelFramework.context.ExecutorType;
import com.example.ParallelFramework.model.ParticipantMockModel;
import com.example.ParallelFramework.parallelclasses.AbstractExecutor;

import java.time.LocalDate;

public class ParticipantExecutor extends AbstractExecutor {

    public ParticipantExecutor(AbstractContext abstractContext) {
        super(abstractContext);
    }

    @Override
    public void initializeData(AbstractContext abstractContext) {
        abstractContext.setData(new ParticipantMockModel("Abhijeet","Deshpande", LocalDate.of(LocalDate.now().getYear()-1,LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth())));
    }

    @Override
    public void commitData(AbstractContext abstractContext) {
        System.out.println("Inside Commit::");
        System.out.println("Data is ::"+abstractContext.getData());
    }

    @Override
    public void executeData(AbstractContext abstractContext) {
        System.out.println("Inside execute");
        LocalDate date =((ParticipantMockModel) abstractContext.getData()).getDob();
        Integer age =LocalDate.now().getYear()- date.getYear();
        abstractContext.setResult(age);
        System.out.println(age);

    }

    @Override
    public void backoutData(AbstractContext abstractContext) {

    }
}
