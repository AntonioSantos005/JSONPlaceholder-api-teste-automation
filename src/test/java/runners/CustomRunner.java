package runners;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;

import io.cucumber.junit.Cucumber;
import listener.CustomListener;

public class CustomRunner extends Cucumber {

	public CustomRunner(Class<?> clazz) throws InitializationError, IOException {
		super(clazz);
		setScheduler(new ThreadPull());
	}
	
	private static class ThreadPull implements RunnerScheduler{

		private ExecutorService executor;
		
		public ThreadPull() {
			executor = Executors.newFixedThreadPool(3);
		}
		
		@Override
		public void schedule(Runnable run) {
			executor.submit(run);
			
		}

		@Override
		public void finished() {
			executor.shutdown();
			try {
				executor.awaitTermination(30, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}
	
	@Override
	public void run(RunNotifier notifier) {
		notifier.addFirstListener(new CustomListener());
		super.run(notifier);
	}
	
}
