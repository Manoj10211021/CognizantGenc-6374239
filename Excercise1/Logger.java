package Excercise1;
public class Logger {
    // Private static instance of the class
    private static Logger instance;
    
    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created");
    }
    
    // Public static method to get the instance (thread-safe version)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    // Logging methods
    public void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
    
    public void logError(String message) {
        System.out.println("[ERROR] " + message);
    }
    
    public void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }
}