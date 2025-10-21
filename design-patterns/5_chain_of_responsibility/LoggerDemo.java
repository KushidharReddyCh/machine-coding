public class LoggerDemo {
    public static void main(String[] args) {
        
        LogProcessor logProcessor = getChainOfLoggers();
        logProcessor.logMessage(LogProcessor.DEBUG, "test");
        logProcessor.logMessage(LogProcessor.INFO, "TEST1");
        logProcessor.logMessage(LogProcessor.ERROR, "TEST2");
        logProcessor.logMessage(LogProcessor.FATAL, "TEST3");

    }   

    public static LogProcessor getChainOfLoggers(){
        LogProcessor fatalLogger = new FatalLogProcessor(LogProcessor.FATAL);
        LogProcessor errorLogger = new ErrorLogProcessor(LogProcessor.ERROR);
        LogProcessor infoLogger = new InfoLogProcessor(LogProcessor.INFO);
        LogProcessor debugLogger = new DebugLogProcessor(LogProcessor.DEBUG);
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);
        return debugLogger;
    }
}
