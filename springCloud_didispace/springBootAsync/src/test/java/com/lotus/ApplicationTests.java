package com.lotus;

import com.lotus.job.AsyncTask;
import com.lotus.job.CustomAsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
	private AsyncTask task;

	@Autowired
    private CustomAsyncTask customAsyncTask;

	@Test
	public void testAsync() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();

		while (true){
			if(task1.isDone() && task2.isDone() && task3.isDone()){
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

	@Test
	public void testCustomAsync() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> task1 = customAsyncTask.doTaskOne();
		Future<String> task2 = customAsyncTask.doTaskTwo();

		while (true){
			if(task1.isDone() && task2.isDone()){
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();
		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}
}