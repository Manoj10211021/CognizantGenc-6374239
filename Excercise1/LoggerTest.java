package Excercise1;
public class LoggerTest {
    public static void main(String[] args) {
        // Get the Logger instance multiple times
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        
        // Test if all references point to the same object
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        
        // Use the logger
        logger1.logInfo("Application started");
        logger2.logWarning("Low memory detected");
        logger3.logError("Failed to load configuration");
        
        // Test in a multi-threaded environment
        Runnable runnable = () -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.logInfo("Logging from thread: " + Thread.currentThread().getName());
        };
        
        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");
        
        thread1.start();
        thread2.start();
    }
}