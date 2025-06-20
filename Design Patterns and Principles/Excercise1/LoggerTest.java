package Excercise1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LoggerTest {
    public static void main(String[] args) {
        // Singleton verification
        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();
        System.out.println("Is singleton? " + (logger1 == logger2));
        
        // Basic logging
        logger1.info("Application starting");
        logger2.warn("Configuration not optimized");
        
        // Concurrent stress test
        ExecutorService pool = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            pool.execute(() -> {
                AppLogger logger = AppLogger.getInstance();
                logger.info("Task " + taskId + " started");
                try {
                    Thread.sleep(50);
                    if (taskId % 4 == 0) {
                        logger.warn("Task " + taskId + " experienced delay");
                    }
                } catch (InterruptedException e) {
                    logger.error("Task " + taskId + " interrupted");
                }
                logger.info("Task " + taskId + " completed");
            });
        }
        
        pool.shutdown();
        try {
            if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
                AppLogger.getInstance().error("Thread pool timeout");
            }
        } catch (InterruptedException e) {
            AppLogger.getInstance().error("Test interrupted");
        }
        
        System.out.println("Logging completed. Check app.log for results.");
    }
}