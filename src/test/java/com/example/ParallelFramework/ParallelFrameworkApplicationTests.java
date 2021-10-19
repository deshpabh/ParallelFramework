package com.example.ParallelFramework;

import com.example.ParallelFramework.context.ExecutorType;
import com.example.ParallelFramework.coordinator.ParallelCoordinator;
import com.example.ParallelFramework.coordinator.SerialCoordinator;
import com.example.ParallelFramework.model.DemoContext;
import com.example.ParallelFramework.model.ParticipantMockModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.concurrent.Future;

@SpringBootTest
class ParallelFrameworkApplicationTests {

	private static DemoContext demoContext;

	@Test
	void serialContextLoadsTest() {
		demoContext = new DemoContext();
		demoContext.setData(new ParticipantMockModel(null,null,null));
		ParticipantExecutor participantExecutor = new ParticipantExecutor(demoContext);
		try {
			new SerialCoordinator(Arrays.asList(participantExecutor));
		}catch (Exception e){

		}
		Assert.notNull(demoContext.getResult());
		Assert.isTrue((Integer) demoContext.getResult() == 1);
	}

	@Test
	void parallelContextLoad(){
		demoContext = new DemoContext();
		demoContext.setData(new ParticipantMockModel(null,null,null));
		ParticipantExecutor participantExecutor = new ParticipantExecutor(demoContext);
		ParticipantSecondExecutor participantSecondExecutor = new ParticipantSecondExecutor(demoContext);
		try{
			new ParallelCoordinator(ExecutorType.FIXED_THREAD_POOL).executeTasksParallely(Arrays.asList(participantExecutor,participantSecondExecutor));
		}catch (Exception e){

		}
		Assert.notNull(demoContext.getResult());
	}

}
