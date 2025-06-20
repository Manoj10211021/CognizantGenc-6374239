package singletonPattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AppLogger {
    private static volatile AppLogger instance;
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private final Path logFilePath;
    
    private AppLogger() {
        this.logFilePath = Path.of("app.log");
        initializeLogFile();
    }
    
    public static AppLogger getInstance() {
        if (instance == null) {
            synchronized (AppLogger.class) {
                if (instance == null) {
                    instance = new AppLogger();
                }
            }
        }
        return instance;
    }
    
    private void initializeLogFile() {
        if (initialized.compareAndSet(false, true)) {
            try {
                Files.writeString(logFilePath,
                    "=== Log Initialized at " + getTimestamp() + " ===\n",
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.err.println("Log initialization failed: " + e.getMessage());
            }
        }
    }
    
    public void log(LogLevel level, String message) {
        String entry = String.format("[%s][%s][%s] %s\n",
            getTimestamp(),
            level,
            Thread.currentThread().getName(), // Using thread name instead of ID
            message);
        
        try {
            Files.writeString(logFilePath,
                entry,
                StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Log write failed: " + e.getMessage());
        }
    }
    
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }
    
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    
    private String getTimestamp() {
        return LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }
    
    public enum LogLevel {
        INFO, WARN, ERROR
    }
}